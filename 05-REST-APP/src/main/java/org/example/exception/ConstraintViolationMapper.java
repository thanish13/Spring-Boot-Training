package org.example.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

public class ConstraintViolationMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exception.getMessage())
                .type(MediaType.APPLICATION_JSON).build();
    }

    private ValidationError toValidationError(ConstraintViolation constraintViolation) {
        ValidationError error = new ValidationError();
        error.setPath(constraintViolation.getPropertyPath().toString());
        error.setMessage(constraintViolation.getMessage());
        return error;
    }

    private static class ValidationError {

        private String path;
        private String message;

        // Getters and setters
        public void setPath(String path){
            this.path = path;
        }

        public void setMessage(String message){
            this.message = message;
        }
    }
}
