package com.tejovat.tims.dto;

public class AutoNumberDto {
	
	private String nextno;
	
	
	public AutoNumberDto() {
		
	}

	public AutoNumberDto(String nextno) {
		this.nextno = nextno;
	}
	
	public String getNextno() {
		return nextno;
	}
	public void setNextno(String nextno) {
		this.nextno = nextno;
	}
}
