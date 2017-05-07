package com.cyorg.threadpool;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.impl.DefaultMessage;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yorga on 07-05-2017.k
 */
public class CamelThreadPoolStarter {
    public static void main(String[] args) {
        AbstractXmlApplicationContext springCtx = new ClassPathXmlApplicationContext("META-INF/spring/camel-thread-context.xml");

        CamelContext camelContext = (CamelContext) springCtx.getBean("threadPoolCamelContext");
        ProducerTemplate producerTemplate = (ProducerTemplate) springCtx.getBean("producerTemplate");

        DefaultMessage message = new DefaultMessage();
        DefaultExchange exchange = new DefaultExchange(camelContext);

        message.setBody("Camel Thread Pool Message Body");
        exchange.setIn(message);


        producerTemplate.send("direct:threadPoolSizeDemoRoute",exchange);
    }
}
