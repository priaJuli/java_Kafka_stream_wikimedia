/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.malaulessons.kafka.consumer.database;

import com.malaulessons.kafka.consumer.database.entity.WikimediaData;
import com.malaulessons.kafka.consumer.database.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
 
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    
    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }
    
    @KafkaListener(
            topics="wikimedia_recentchange",
            groupId="myGroup"
    )

    public void consume(String eventMessage){
        LOGGER.info(String.format("Message received -> %s", eventMessage));
        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        
        dataRepository.save(wikimediaData);
        
    }
}
