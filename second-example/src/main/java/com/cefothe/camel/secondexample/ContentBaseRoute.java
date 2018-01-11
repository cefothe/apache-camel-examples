package com.cefothe.camel.secondexample;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ContentBaseRoute  extends RouteBuilder{
    @Override
    public void configure() throws Exception {
        from("direct:content-base-route")
                .choice()
                    .when(header("CamelFileName").endsWith(".jpeg"))
                        .log("Image with name ${headers.CamelFileName}")
                        .to("file:///home/cefothe/Documents/presentatation-data-output/photos")
                    .when(header("CamelFileName").endsWith(".xml"))
                        .log("XML with name ${headers.CamelFileName}")
                        .to("file:///home/cefothe/Documents/presentatation-data-output/xml");
    }
}
