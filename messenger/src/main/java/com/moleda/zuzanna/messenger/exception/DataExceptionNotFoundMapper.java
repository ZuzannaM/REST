package com.moleda.zuzanna.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.moleda.zuzanna.messenger.model.ErrorMessage;

@Provider
public class DataExceptionNotFoundMapper implements ExceptionMapper<DataExceptionNotFound>{

	@Override
	public Response toResponse(DataExceptionNotFound ex) {
		ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), 404, "www.google.com");
		return Response.status(Status.NOT_FOUND)
				.entity(errorMessage)
				.build();
	}

}
