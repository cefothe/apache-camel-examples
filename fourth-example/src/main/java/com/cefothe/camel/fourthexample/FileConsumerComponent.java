package com.cefothe.camel.fourthexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileConsumerComponent extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("file:///home/cefothe/Documents/presentatation-data/spritter")
                .split().tokenizeXML("CD", "CATALOG").streaming()
        .to("direct:print-body");
    }
}
