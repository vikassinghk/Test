package com.aop.action;

public enum ActionAuditType {
	Activity_1("Activity 1"), Activity_2("Activity 2");

	private String mDescription;

	private ActionAuditType(String aDescription) {
		mDescription = aDescription;
	}

	public String getDescription() {
		return mDescription;
	}

	public void setDescription(String aDescription) {
		mDescription = aDescription;
	}
}