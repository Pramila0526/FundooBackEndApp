package com.bridgelabz.fundooappbackend.note.model;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import com.bridgelabz.fundooappbackend.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name = "labelDetails")
@JsonIgnoreProperties(value= {"user"})
public class Label implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String name;
	
	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	private User user;

	@ManyToMany
	@JoinTable(name = "labeledNotes", joinColumns = @JoinColumn(name = "label_id"))
	List<Note> notes;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	@Override
	public String toString() {
		return "Label [id=" + id + ", name=" + name + ", user=" + user + "]";
	}


	public Label(int id, @NotNull String name, User user) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
	}

	public Label() {
		super();
	}
}
	