package com.paymoon.demo.z20200324;
/**
 * 关于在idea中使用Thread.activeCount()的问题_LYuanZhuo的博客-CSDN博客
https://blog.csdn.net/qq_42862882/article/details/89309399
 * @author stephenlii
 *第二段说的确实是错的
应该这么举例，某一时刻线程A和B都拿到了主内存中的inc=10并且完成了++操作，那这个时候线程A和B的工作内存中inc=11，假设接下来B线程取得优先权，将工作内存中的inc=11（通过总线）写回到主内存，此时触发总线嗅探机制通知线程A，你的工作内存中的inc失效了需要重新从主内存读取，确实这个时候线程A会重新读取主内存中的inc=11，但是接下来执行的指令是将11写回主内存（store），而不是进行++操作，因为++操作已经执行过了，只不过结果被失效。

更深入的来讲，在这种情况下，这个失效机制（总线嗅探）会消耗掉线程A对inc变量的use操作。最终导致inc的值<=10000。

另外，补充一下变量inc从主内存到某个线程的工作内存再回传的具体过程：
read：读取主内存中的值（既线程A读到主内存中inc=10）
load：将主内存中的inc=10复制或者说加载到自己的工作内存（更深入地讲，复制到了栈中的局部变量表里）
use：在工作内存中对inc进行++计算，得到结果inc=11，此时这个11被压入了操作数栈中
assign：将操作数栈中的11复制给局部变量表
store：将inc变量传回主内存（这个过程需要通过总线，会触发总线嗅探）
write：将被传回的inc（11）写到主内存的inc变量上，即刷新主内存
这个过程中提到的局部变量表和操作数栈也就是分析jvm内存模型的时候栈->栈帧中的结构，可以另行了解。
 */
public class Test {
    public volatile int inc = 0;
     
    public void increase() {
        inc++;
    }
     
    public static void main(String[] args) {
    	System.out.println(Thread.activeCount());
        final Test test = new Test();
        for(int i=0;i<100;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<100000;j++)
                        test.increase();
                };
            }.start();
        }
         
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }
}