package io.veicot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.idempotent.jdbc.JdbcMessageIdRepository;
import org.apache.camel.spi.IdempotentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class IdempotentConsumerRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("file:./src/data?idempotent=true&idempotentRepository=#idempotentRepository")
                .log("${body}")
                .log("${header.CamelFileName}");
    }
}
