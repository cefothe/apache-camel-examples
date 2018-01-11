package com.cefothe.camel.fourthexample;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.springframework.stereotype.Component;

@Component
public class AggregatorComponent extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("direct:aggregator").log("aggregation").aggregate(constant(true), (oldExchange, newExchange) -> {
            if (oldExchange == null) {
                return newExchange;
            }
            String oldBody = oldExchange.getIn().getBody(String.class);
            String newBody = newExchange.getIn().getBody(String.class);
            String body = oldBody + newBody;
            oldExchange.getIn().setBody(body);
            return oldExchange;
        }).completionSize(3)
        .log("Sending out ${body}");
    }
}
