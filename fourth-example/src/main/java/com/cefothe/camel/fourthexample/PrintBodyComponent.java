package com.cefothe.camel.fourthexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class PrintBodyComponent extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:print-body").log("${body}").to("direct:aggregator");
    }
}
