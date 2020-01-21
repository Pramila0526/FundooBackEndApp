package com.bridgelabz.fundooappbackend.note.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.fundooappbackend.note.dto.LabelDto;
import com.bridgelabz.fundooappbackend.note.dto.UpdateLabelDto;
import com.bridgelabz.fundooappbackend.note.response.Responses;
import com.bridgelabz.fundooappbackend.note.service.LabelServiceImplementation;
import com.bridgelabz.fundooappbackend.user.message.Messages;
import com.bridgelabz.fundooappbackend.user.response.Response;

@RestController   
@RequestMapping("/label")
public class LabelController {
	
	 @Autowired
     LabelServiceImplementation labelServiceImplementation;
	 
	 @GetMapping("/demolabel")
     public String demo()
     {
   	  return "Hello Label User!!";
     }	
	 
	 @PostMapping("/addlabel")
	  	public ResponseEntity<Responses> addLabel(@RequestBody LabelDto labelDto,@RequestHeader String token)
	  	{
	  		return new ResponseEntity<Responses>(labelServiceImplementation.addLabel(labelDto,token), HttpStatus.OK); // give response for user 200
	  	}
	 
	 @PostMapping("/updatelabel")
	  	public ResponseEntity<Responses> updateLabel(@RequestBody UpdateLabelDto updateLabelDto,@RequestHeader String token)
	  	{
	  		return new ResponseEntity<Responses>(labelServiceImplementation.updateLabel(updateLabelDto, token), HttpStatus.OK); // give response for user 200
	  	}
	 
	 @DeleteMapping("/{id}")
	  	public ResponseEntity<Responses> deleteLabel(@PathVariable int id,@RequestHeader String token)
	  	{
	  		return new ResponseEntity<Responses>(labelServiceImplementation.deleteLabel(id, token), HttpStatus.OK); // give response for user 200
	  	}
	 
	 @GetMapping("/findlabel/{id}")
		public ResponseEntity<Responses> findLabel(@PathVariable int id, @RequestHeader String token) 
		{
			return new ResponseEntity<Responses>(labelServiceImplementation.findLabel(id,token), HttpStatus.OK);
		}
	 
	 @GetMapping("/getalllabels")
		public Response getAllLabels(@RequestHeader String token) 
		{
			return new Response(Messages.OK,null,labelServiceImplementation.getAllLabels(token));
		}
}
