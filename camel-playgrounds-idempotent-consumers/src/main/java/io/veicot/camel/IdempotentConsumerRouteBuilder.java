package io.veicot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class IdempotentConsumerRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:{{camel.playgrounds.idempotentconsumers.dir}}?idempotent=true&idempotentRepository=#idempotentRepository")
                .log("${header.CamelFileName}");
    }
}
