package gr.ypes.electionsapp.configuration;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import gr.ypes.electionsapp.exception.GenericExceptionMapper;
import gr.ypes.electionsapp.exception.ServiceExceptionMapper;
import gr.ypes.electionsapp.resource.PeripheryResource;

@Component
@ApplicationPath("/v1")
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig(ObjectMapper objectMapper) {
    	//RESOURCES
    	register(PeripheryResource.class);
    	
    	
    	//EXCEPTIONS
        register(ServiceExceptionMapper.class);
        register(GenericExceptionMapper.class);
        
        // register jackson for json 
        register(new ObjectMapperContextResolver(objectMapper));
    }

    @Provider
    public static class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
   
      private final ObjectMapper mapper;
   
      public ObjectMapperContextResolver(ObjectMapper mapper) {
        this.mapper = mapper;
      }
   
      @Override
      public ObjectMapper getContext(Class<?> type) {
        return mapper;
      }
    }

}
