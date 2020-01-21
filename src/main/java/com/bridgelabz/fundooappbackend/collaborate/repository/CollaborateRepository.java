package com.bridgelabz.fundooappbackend.collaborate.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bridgelabz.fundooappbackend.collaborate.model.Collaborate;

@Repository
public interface CollaborateRepository extends JpaRepository<Collaborate, Object> 
{
	// For finding or recovering the user account by MailId
	// User findByEmail(String email);
    
    // Note deleteById(int id);
}