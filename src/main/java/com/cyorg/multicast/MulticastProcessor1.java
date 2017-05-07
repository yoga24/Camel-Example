package com.cyorg.multicast;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yorga on 07-05-2017.
 */
public class MulticastProcessor1 implements Processor{

    private static final Logger LOG = LoggerFactory.getLogger(MulticastProcessor1.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        LOG.info("Logging from Multicast Processor 1 -> "+body);
        body = body + " MP1";
        exchange.getOut().setBody(body);
        Thread.sleep(10000);
        LOG.info("Before Processor-1 end");
//        throw new Exception("Exception Test");
    }
}
