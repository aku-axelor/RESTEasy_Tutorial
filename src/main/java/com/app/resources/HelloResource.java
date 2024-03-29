package com.app.resources;


import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/hello")
public class HelloResource {

    @Path("/printHello")
    @GET
    public Response printHello() {
        String hello="Hello";
        return Response.ok().entity(hello).build();
    }
    @Path("/addStudent")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addStudent(Map<String, Object> data) {
        String id = (String) data.get("id");
        String name = (String) data.get("name");
        
        String student = "Id is: " +id+" and "+"Name is: "  +name;
        return Response.ok().entity(student).build();
    }
    @Path("/updateStudent")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateStudent(Map<String, Object> data) {
        String id = (String) data.get("id");
        String name = (String) data.get("name");


        String updatedStudent = "Updated student with Id: " + id + " and Name: " + name;
        return Response.ok().entity(updatedStudent).build();
    }
    @Path("/deleteStudent/{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") String id) {        
        String message = "Student with ID " + id + " has been deleted";
        return Response.ok().entity(message).build();
    }
   
}