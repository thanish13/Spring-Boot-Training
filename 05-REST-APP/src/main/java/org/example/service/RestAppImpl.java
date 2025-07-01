package org.example.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.ws.rs.core.Response;
import org.example.api.RestApp;
import org.example.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RestAppImpl implements RestApp {

    @Override
    public Response getRequest() {

        return Response.accepted().entity("Done").build();
    }

    @Override
    public Response postRequest( Object body) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        Employee employee = mapper.readValue(mapper.writeValueAsString(body), Employee.class);

        Set<ConstraintViolation<Employee>> error = Validation.buildDefaultValidatorFactory().getValidator().validate(employee);

        if (!error.isEmpty()){
            return Response.status(400).entity("Bad Request").build();
        }

        return Response.accepted(employee).build();

    }
}
