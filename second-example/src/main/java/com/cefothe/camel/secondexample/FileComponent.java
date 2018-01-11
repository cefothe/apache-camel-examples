package com.cefothe.camel.secondexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileComponent extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:////home/cefothe/Documents/presentatation-data?noop=true")
                .log("File name ${headers.CamelFileName}")
                .to("direct:content-base-route");
    }
}
