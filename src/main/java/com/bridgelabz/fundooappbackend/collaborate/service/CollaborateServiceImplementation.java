package com.bridgelabz.fundooappbackend.collaborate.service;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.bridgelabz.fundooappbackend.collaborate.dto.CollaborateDto;
import com.bridgelabz.fundooappbackend.collaborate.model.Collaborate;
import com.bridgelabz.fundooappbackend.collaborate.repository.CollaborateRepository;
import com.bridgelabz.fundooappbackend.collaborate.utility.TokenssUtility;
import com.bridgelabz.fundooappbackend.note.model.Note;
import com.bridgelabz.fundooappbackend.note.repository.NotesRepository;
import com.bridgelabz.fundooappbackend.note.response.Responses;

public class CollaborateServiceImplementation implements CollaborateService {

	@Autowired
	private CollaborateRepository collaborateRepository;
	
	@Autowired
	private TokenssUtility tokenutility;
	
	@Autowired
	private NotesRepository noteRepository;
	
	@Autowired
	private ModelMapper mapper;
	public Responses collaborate(CollaborateDto collaborateDto, String token) {
		Collaborate collaborator = mapper.map(collaborateDto, Collaborate.class);
		String email = tokenutility.getUserToken(token);
		Optional<Note> note = noteRepository.findById(email);
		return new Responses();	
	}
}
