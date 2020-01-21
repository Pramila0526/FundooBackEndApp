package com.bridgelabz.fundooappbackend.collaborate.service;

import com.bridgelabz.fundooappbackend.collaborate.dto.CollaborateDto;
import com.bridgelabz.fundooappbackend.note.response.Responses;

public interface CollaborateService
{
	public Responses collaborate(CollaborateDto collaborateDto, String token);

}
