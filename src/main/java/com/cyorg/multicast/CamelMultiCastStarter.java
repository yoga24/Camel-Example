package com.cyorg.multicast;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yorga on 07-05-2017.
 */
public class CamelMultiCastStarter {
    public static void main(String[] args) {

        AbstractXmlApplicationContext springCtx = new ClassPathXmlApplicationContext("META-INF/spring/camel-multicast-context.xml");

        CamelContext camelContext = (CamelContext) springCtx.getBean("multicastCamelContext");
        ProducerTemplate producerTemplate = (ProducerTemplate) springCtx.getBean("producerTemplate");

        DefaultMessage message = new DefaultMessage();
        DefaultExchange exchange = new DefaultExchange(camelContext);

        message.setBody("Camel Multicast Message Body");
        exchange.setIn(message);


//        producerTemplate.send("direct:simpleMulticastRoute", exchange);

//        producerTemplate.send("direct:parallelMulticastRoute", exchange);

//        producerTemplate.send("direct:exceptionMulticastRoute", exchange);

        producerTemplate.send("direct:streamingMulticastRoute", exchange);
    }
}
