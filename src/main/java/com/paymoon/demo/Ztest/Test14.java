package com.paymoon.demo.Ztest;

import java.util.LinkedList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test14 {
	private static final Logger logger = LogManager.getLogger();

	public static void main(String[] args) {
		List<App> apps = new LinkedList<>();
		AppNum appNum = new AppNum();
		App app = new App();
		app.setNum(100);
		appNum.setNum(100);
		app.setAppNum(appNum);
		apps.add(app);
		App app2 = new App();
		AppNum appNum2 = new AppNum();
		app2.setNum(5);
		appNum2.setNum(5);
		app2.setAppNum(appNum2);
		apps.add(app2);
		AppNum appNum3 = new AppNum();
		App app3 = new App();
		app3.setNum(999);
		appNum3.setNum(999);
		app3.setAppNum(appNum3);
		apps.add(app3);
		
		App appTemp = new App();
		App appTempI = new App();
		App appTempJ = new App();
		for (int i = 0; i < apps.size(); i++) {
			for (int j = i + 1; j < apps.size(); j++) {
				if (apps.get(i).getNum() < apps.get(j).getNum()) {
					appTempI = apps.get(i);
					appTempJ = apps.get(j);
					apps.set(j, appTempI);
					apps.set(i,appTempJ);
				}
			}
		}
		List<App> appSorted = new LinkedList<>();
		for (App a : apps) {
			System.out.println(String.format("a.getNum() %s,a.getAppNum().getNum() %s",a.getNum(),a.getAppNum().getNum()));
			
		}
	}
	
}
