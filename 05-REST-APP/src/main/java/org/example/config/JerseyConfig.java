package org.example.config;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import io.swagger.v3.jaxrs2.Reader;
import io.swagger.v3.jaxrs2.SwaggerSerializers;
import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.tags.Tag;
import jakarta.ws.rs.ApplicationPath;
import org.example.api.MyResource;
import org.example.api.UsersApi;
import org.example.exception.ConstraintViolationMapper;
import org.example.service.OauthApiImpl;
import org.example.service.RestAppImpl;
import org.example.service.UsersApiImpl;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ApplicationPath("/app")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {

        register(UsersApiImpl.class);
        register(RestAppImpl.class);
        register(MyResource.class);
        register(ConstraintViolationMapper.class);
        register(OauthApiImpl.class);

    }

}
