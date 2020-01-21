package com.bridgelabz.fundooappbackend.note.service;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgelabz.fundooappbackend.note.dto.NoteDto;
import com.bridgelabz.fundooappbackend.note.dto.UpdateNoteDto;
import com.bridgelabz.fundooappbackend.note.message.Messages;
import com.bridgelabz.fundooappbackend.note.model.Note;
import com.bridgelabz.fundooappbackend.note.repository.NotesRepository;
import com.bridgelabz.fundooappbackend.note.response.Responses;
import com.bridgelabz.fundooappbackend.note.utility.TokensUtility;
import com.bridgelabz.fundooappbackend.user.exception.custom.TokenException;
import com.bridgelabz.fundooappbackend.user.exception.custom.UserNotFoundException;
import com.bridgelabz.fundooappbackend.user.model.User;
import com.bridgelabz.fundooappbackend.user.repository.UserRepository;
import org.springframework.data.domain.Sort;

@Service
public class NoteServiceImplementation implements NoteService {

	@Autowired
	private NotesRepository notesRepository;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private TokensUtility tokenUtility;

	@Autowired
	private UserRepository repository;

	public Responses addNewNote(NoteDto noteDto, String token) {
		Note note = mapper.map(noteDto, Note.class);
		String usermail = tokenUtility.getUserToken(token);
		User user = repository.findByEmail(usermail);
		if (user == null) {
			throw new UserNotFoundException(Messages.USER_NOT_EXISTING);
		}
		note.setUser(user);
		note = notesRepository.save(note); // Storing Users Data in Database
		return new Responses(Messages.OK, null, Messages.NOTE_CREATED);
	}

	public Responses updateNote(UpdateNoteDto updateNoteDto, String token) {
		Note note = mapper.map(updateNoteDto, Note.class);
		String useremail = tokenUtility.getUserToken(token);
		User user = repository.findByEmail(useremail);
		note.setUser(user);
		updateNoteDto.setId(updateNoteDto.getId());
		updateNoteDto.setTitle(updateNoteDto.getTitle());
		updateNoteDto.setDescription(updateNoteDto.getDescription());
		note = notesRepository.save(note);
		return new Responses(Messages.OK, "Success", Messages.NOTE_UPDATED);
	}

	public Responses deleteNote(int id, String token) {
		// Note note = mapper.map(deleteNoteDto, Note.class); // Mapping new User data
		// into the user Class
		String usertoken = tokenUtility.getUserToken(token);
		User user = repository.findByEmail(usertoken);
		Note note = notesRepository.findById(id);
		note.setUser(user);
		notesRepository.delete(note);
		return new Responses(Messages.OK, null, Messages.NOTE_DELETED);
	}

	public Responses findNote(int id, String token) {
		String usertoken = tokenUtility.getUserToken(token);
		if (usertoken.isEmpty()) {
			throw new TokenException(Messages.INVALID_TOKEN);
		}
		User user = repository.findByEmail(usertoken);
		Note note = notesRepository.findById(id);
		note.setUser(user);
		return new Responses(Messages.OK, "User Registration ", notesRepository.findById(id));
	}

	public List<Note> showUserNotes(int id, String token) {
		String usertoken = tokenUtility.getUserToken(token);
		if (usertoken.isEmpty()) {
			throw new TokenException(Messages.INVALID_TOKEN);
		}
		User user = repository.findByEmail(usertoken);
		Note note = notesRepository.findById(id);
		note.setUser(user);
		System.out.println("check");
		return notesRepository.findAll(); // sh
	}

	public List<Note> getAllNotes(String token) {
		String usertoken = tokenUtility.getUserToken(token);
		if (usertoken.isEmpty()) {
			throw new TokenException(Messages.INVALID_TOKEN);
		}
		User user = repository.findByEmail(usertoken);

		List<Note> note = notesRepository.findAll().stream().filter(e -> e.getUser().getId() == user.getId())
				.collect(Collectors.toList());
		return note;
	}

	public List<Note> sortById(String token) {
		String usertoken = tokenUtility.getUserToken(token);
		if (usertoken.isEmpty()) {
			throw new TokenException(Messages.INVALID_TOKEN);
		}
		User user = repository.findById(usertoken);
		List<Note> list = notesRepository.findAll().stream().filter(e -> e.getUser().getId() == user.getId())
				.collect(Collectors.toList());
		
		list=list.stream().sorted((list1,list2)->list1.getTitle().compareTo(list2.getTitle())).collect(Collectors.toList());          

		return list;
	}
}
