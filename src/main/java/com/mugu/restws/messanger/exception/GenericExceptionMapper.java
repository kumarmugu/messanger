package com.mugu.restws.messanger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.mugu.restws.messanger.model.ErrorMessage;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage ex = new ErrorMessage(exception.getMessage(),500,"www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(ex).build();
	}

}
