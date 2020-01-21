package com.bridgelabz.fundooappbackend.note.dto;

public class LabelDto {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "LabelDto [name=" + name + "]";
	}

	public LabelDto() {
		super();
	}

	public LabelDto(String name) {
		super();
		this.name = name;
	}
}
