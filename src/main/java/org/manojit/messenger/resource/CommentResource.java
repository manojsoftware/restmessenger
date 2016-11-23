package org.manojit.messenger.resource;

import javax.ws.rs.Path;

@Path("/")
public class CommentResource {
public void getComments(){
	System.out.println("this is a getcomments method");
}
	
}
