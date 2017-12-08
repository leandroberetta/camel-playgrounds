package io.veicot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class QuartzRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("quartz2://myGroup/myTimerName?cron=0+0/1+*+1/1+*+?+*")
                .log("Hello!");
    }
}
