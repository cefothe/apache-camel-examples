package com.cefothe.camel.third;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class XmlToJsonConvertor extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:xml-json-route")
                .marshal()
                .xmljson()
                .setHeader("CamelFileName", simple("${headers.CamelFileName}.json"))
                .to("file:///home/cefothe/Documents/presentatation-data-output/json");
    }
}
