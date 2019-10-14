package com.formation.exeption;

public class ErrorExeption extends Exception {
	
	private String exeptionName;
	private String exeptionMessage;
	
	public ErrorExeption(String exeptionName, String exeptionMessage){
		this.exeptionName = exeptionName;
		this.exeptionMessage = exeptionMessage;
	}

	public String getExeptionName() {
		return exeptionName;
	}

	public void setExeptionName(String exeptionName) {
		this.exeptionName = exeptionName;
	}

	public String getExeptionMessage() {
		return exeptionMessage;
	}

	public void setExeptionMessage(String exeptionMessage) {
		this.exeptionMessage = exeptionMessage;
	}
}
