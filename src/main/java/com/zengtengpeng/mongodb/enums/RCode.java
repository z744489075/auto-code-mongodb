package com.zengtengpeng.mongodb.enums;


public enum RCode {
	SUCCESS(0,"success"),
	FAIL(1,"fail"),
	;

    private Integer code;
	private String desc;
	RCode(Integer code, String desc){
		this.code=code;
		this.desc=desc;
	}

	public Integer code(){
		return this.code;
	}

	public String desc(){
		return this.desc;
	}

}
