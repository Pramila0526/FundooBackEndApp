package com.bridgelabz.fundooappbackend.note.dto;

public class DeleteNoteDto {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DeleteNoteDto(int id) {
		super();
		this.id = id;
	}

	public DeleteNoteDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String toString() {
		return "DeleteDto [id=" + id + "]";
	}
}
