package com.cyorg.splitter;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yorga on 27-04-2017.
 */
public class SplitAggregationStrategy implements AggregationStrategy {

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

        

        return oldExchange;
    }
}
