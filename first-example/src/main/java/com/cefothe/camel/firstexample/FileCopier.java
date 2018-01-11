package com.cefothe.camel.firstexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileCopier extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:///home/cefothe/Documents/presentatation-data?noop=true")
                .log("${headers.CamelFileName}")
                .to("file:///home/cefothe/Documents/presentatation-data-output");
    }
}
