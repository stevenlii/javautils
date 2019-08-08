package com.paymoon.demo.enumdemo;
public enum MsgTypeEnum {
    //消息类型
    MSG_TYPE_SYSTEM(10001),
    //消息类型
    MSG_TYPE_LIVE_SYSTEM(10002);

    private int msgType;

    private MsgTypeEnum(int msgType){
        this.msgType = msgType;
    }

    public int getMsgType() {
        return this.msgType;
    }
    /**
     * 
     * 方法描述 根据类型的名称，返回类型的枚举实例。 
     *
     */
    public static MsgTypeEnum fromMsgType(int msgType) {  
        for (MsgTypeEnum type : MsgTypeEnum.values()) {  
            if (type.getMsgType() == msgType) {  
                return type;  
            }  
        }  
        return null;  
    } 
}
