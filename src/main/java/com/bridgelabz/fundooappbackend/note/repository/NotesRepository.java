package com.bridgelabz.fundooappbackend.note.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.fundooappbackend.note.model.Note;

/**********************************************************************************************************
 * @author 	:Pramila Tawari 
 * Purpose	:@Repository is a Spring annotation that indicates that the decorated class is a repository.
 * 			 A repository is a mechanism for encapsulating storage, retrieval, and search behavior which 
 * 			 emulates a collection of object
 *
 *********************************************************************************************************/

@Repository
public interface NotesRepository extends JpaRepository<Note, Object> 
{
	Note findById(int id);
	//List<Note> findById(int id);
   }