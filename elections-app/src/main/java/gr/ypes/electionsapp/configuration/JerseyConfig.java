package gr.ypes.electionsapp.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import gr.ypes.electionsapp.exception.GenericExceptionMapper;
import gr.ypes.electionsapp.exception.ServiceExceptionMapper;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(ServiceExceptionMapper.class);
        register(GenericExceptionMapper.class);
    }
}
