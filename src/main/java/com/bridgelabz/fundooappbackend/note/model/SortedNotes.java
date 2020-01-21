package com.bridgelabz.fundooappbackend.note.model;

import java.util.List;

public class SortedNotes {
	private Note note;
	private List<Label> label;
	public Note getNote() {
		return note;
	}
	public void setNote(Note note) {
		this.note = note;
	}
	public List<Label> getLabel() {
		return label;
	}
	public void setLabel(List<Label> label) {
		this.label = label;
	}
	public SortedNotes(Note note, List<Label> label) {
		super();
		this.note = note;
		this.label = label;
	}
	public SortedNotes() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SortedNotes [note=" + note + ", label=" + label + "]";
	}
}