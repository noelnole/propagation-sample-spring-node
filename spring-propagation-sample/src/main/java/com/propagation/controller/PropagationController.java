package com.propagation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.SpanAccessor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 */

@RestController
@RequestMapping(value = "/api")
public class PropagationController {


    private static String host = "http://172.18.0.1:4000";

    @Autowired
    private SpanAccessor accessor;

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping(value = "/bye")
    public String sendRespond(@RequestHeader(value="X-B3-TraceId") String traceId){
        if (traceId == null){
            throw new RuntimeException();
        }
        return "bye with traceId, "+traceId;
    }



    @GetMapping(value="/hello")
    public String sendWave(){
        Span currentSpan = PropagationController.this.accessor.getCurrentSpan();

        String respond = restTemplate.getForObject(host+"/wave", String.class);
        return respond;
    }

}
