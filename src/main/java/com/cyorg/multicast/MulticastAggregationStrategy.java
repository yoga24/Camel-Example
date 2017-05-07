package com.cyorg.multicast;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by yorga on 27-04-2017.
 */
public class MulticastAggregationStrategy implements AggregationStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(MulticastAggregationStrategy.class);

    @Override
    public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {

        if(oldExchange == null) {
            oldExchange = newExchange;
        }   else    {

            String oldBody = oldExchange.getIn().getBody(String.class);
            String newBody = newExchange.getIn().getBody(String.class);

            String body = oldBody + " ++ " + newBody;
            oldExchange.getIn().setBody(body);
        }

        LOG.info(" Aggregator --> "+newExchange.getIn().getBody(String.class));

        return oldExchange;
    }
}
