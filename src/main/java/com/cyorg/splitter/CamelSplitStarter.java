package com.cyorg.splitter;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

/**
 * Created by yorga on 06-05-2017.
 */
public class CamelSplitStarter {
    public static void main(String[] args) {
        AbstractXmlApplicationContext springCtx = new ClassPathXmlApplicationContext("META-INF/spring/camel-split-context.xml");

        CamelContext camelContext = (CamelContext) springCtx.getBean("splitterCamelContext");
        ProducerTemplate producerTemplate = (ProducerTemplate) springCtx.getBean("producerTemplate");

        DefaultMessage message = new DefaultMessage();
        DefaultExchange exchange = new DefaultExchange(camelContext);


//        message.setHeader("content","Spinrg Java Loader");
//        message.setBody(" -- Success --");
//        exchange.setIn(message);
//        producerTemplate.send("direct:logBody",exchange);
//        System.out.println("Hello World");

        message.setBody(Arrays.asList("THIS","IS","A","CAMEL","SPLIT","EXAMPLE"));
        exchange.setIn(message);


//        1. Start Simple Splitter Route
//        producerTemplate.send("direct:startSimpleSplitRoute",exchange);


        producerTemplate.send("direct:startParallelSplitRoute",exchange);


//        producerTemplate.send("direct:startAggParallelSplitRoute",exchange);


    }
}
