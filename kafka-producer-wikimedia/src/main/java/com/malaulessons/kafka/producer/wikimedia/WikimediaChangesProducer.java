/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.malaulessons.kafka.producer.wikimedia;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WikimediaChangesProducer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesProducer.class);
    
    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangesProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
    public void sendMessage() throws InterruptedException{
        String topic = "wikimedia_recentchange";
        
        // to read real time data from wikimedia
        EventHandler eventHandler = new WikimediaChangesHandler(kafkaTemplate, topic);
        
        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
        
        EventSource.Builder builder = new EventSource.Builder(eventHandler, URI.create(url));
        EventSource eventsource = builder.build();
        eventsource.start();
        
        TimeUnit.MINUTES.sleep(10);
    }

}
