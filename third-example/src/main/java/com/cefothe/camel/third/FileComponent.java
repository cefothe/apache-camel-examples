package com.cefothe.camel.third;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class FileComponent extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:////home/cefothe/Documents/presentatation-data?noop=true")
                .filter(header("CamelFileName").endsWith(".xml"))
                .log("File name ${headers.CamelFileName}")
                .to("direct:xml-json-route");
    }
}
