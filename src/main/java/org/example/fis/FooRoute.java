package camelinaction;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * A route which is routing to foo.
 */

@SpringBootApplication
@Component
public class FooRoute extends RouteBuilder {

    public static void main(String[] args) {
        SpringApplication.run(FooRoute.class, args);
    }


    @Override
    public void configure() throws Exception {
        from("timer://foo?period=5000")
                .setBody().constant("Hello World")
                .log(">>> ${body}");
    }

}
