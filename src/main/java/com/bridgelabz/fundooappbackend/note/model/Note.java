package com.bridgelabz.fundooappbackend.note.model;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;
import com.bridgelabz.fundooappbackend.user.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**********************************************************************************************************
 * @author :Pramila Tawari 
 * Purpose :Note Model
 *
 *********************************************************************************************************/
@Component
@Entity
@Table(name = "noteDetails")
@JsonIgnoreProperties(value = { "user" })
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@NotNull
	private String title;

	@NotNull
	private String description;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@ManyToMany(mappedBy = "notes")
	List<Label> labels;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", description=" + description + ", user=" + user + "]";
	}

	public Note() {
		super();
	}

	public Note(int id, @NotNull String title, @NotNull String description, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.user = user;
	}

}
