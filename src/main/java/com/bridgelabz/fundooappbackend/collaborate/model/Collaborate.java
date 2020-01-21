package com.bridgelabz.fundooappbackend.collaborate.model;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "colDetails")
public class Collaborate implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private int noteId;
	
	@NotNull
	private String email;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Collaborate() {
		super();
	}

	public Collaborate(int id, @NotNull int noteId, @NotNull String email) {
		super();
		this.id = id;
		this.noteId = noteId;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Collaborate [id=" + id + ", noteId=" + noteId + ", email=" + email + "]";
	}
}