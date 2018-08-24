package io.veicot.camel;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class CustomLoadBalancerTest extends CamelTestSupport {

    @Test
    public void testLoadBalancer() throws Exception {
        MockEndpoint a = getMockEndpoint("mock:a");
        a.expectedBodiesReceived("gold-message-1", "gold-message-2");

        MockEndpoint b = getMockEndpoint("mock:b");
        b.expectedBodiesReceived("silver-message", "bronze-message");

        template.sendBodyAndHeader("direct:start", "silver-message", "type", "silver");
        template.sendBodyAndHeader("direct:start", "gold-message-1", "type", "gold");
        template.sendBodyAndHeader("direct:start", "gold-message-2", "type", "gold");
        template.sendBodyAndHeader("direct:start", "bronze-message", "type", "bronze");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct:start")
                        .loadBalance(new CustomLoadBalancer())
                        .to("direct:a").to("direct:b")
                        .end();

                from("direct:a")
                        .log("A received: ${body}")
                        .to("mock:a");

                from("direct:b")
                        .log("B received: ${body}")
                        .to("mock:b");
            }
        };
    }
}
