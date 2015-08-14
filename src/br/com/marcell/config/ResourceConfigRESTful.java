package br.com.marcell.config;

import org.glassfish.jersey.server.ResourceConfig;

public class ResourceConfigRESTful extends ResourceConfig {
    public ResourceConfigRESTful() {
        packages("br.com.marcell.servico.rest");
    }
}