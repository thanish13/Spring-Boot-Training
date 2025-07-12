package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validation;
import jakarta.ws.rs.core.Response;
import org.example.api.RestApp;
import org.example.model.Employee;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.*;

@Component
public class RestAppImpl implements RestApp {

    ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

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
            throw new ConstraintViolationException(error);
        }

        return Response.accepted(employee).build();

    }

    @Override
    public Response asyncRequest() throws ExecutionException, InterruptedException {

        Thread.sleep(3000);
        return response();
    }

    @Override
    public Response execRequest() throws JsonProcessingException, ExecutionException, InterruptedException {
        ScheduledFuture<Response> result = executorService.schedule(this::response, 5L, TimeUnit.SECONDS);

        return result.get();
    }

    public Response response(){
        return Response.accepted("Async").build();
    }
}
