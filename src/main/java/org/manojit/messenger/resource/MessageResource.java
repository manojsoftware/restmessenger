package org.manojit.messenger.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.manojit.messenger.model.Message;
import org.manojit.messenger.service.MessageService;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService service=new MessageService();
	@GET
	public List<Message> getMessage() {
		return service.getAllMessages();

	}
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId")long id){
		
		return service.getMessage(id);
		
	}
	@POST
	public Message addMessaage(Message message){
		return service.addMessage(message);
	}
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId")long id,Message message){
		message.setId(id);
		return service.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	public Message deleteMessage(@PathParam("messageId")long id){
		return service.removeMessage(id);
	}

	@Path("/{messageId}/comments")
	public CommentResource getComments(){
	 return  new CommentResource();
		
	}
}
