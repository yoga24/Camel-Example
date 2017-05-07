package com.cyorg.multicast;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yorga on 07-05-2017.
 */
public class MulticastProcessor2 implements Processor{

    private static final Logger LOG = LoggerFactory.getLogger(MulticastProcessor2.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String body = exchange.getIn().getBody(String.class);
        LOG.info("Logging from Multicast Processor 2 -> "+body);
        body = body + " MP2";
        exchange.getOut().setBody(body);
        LOG.info("Before Processor-2 end");
    }
}
