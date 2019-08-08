package com.paymoon.demo.enumdemo;

public enum Test {

	PLUS("Plus One"), MINUS("MinusTwo"), TIMES("MultiplyByFour"), DIVIDE("DivideByZero");
	private String operationName;

	private Test(final String operationName) {
		setOperationName(operationName);
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(final String operationName) {
		this.operationName = operationName;
	}

	public static Test getOperationName(final String operationName) {

		for (Test oprname : Test.values()) {
			if (operationName.equals(oprname.toString())) {
				return oprname;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return operationName;
	}
}