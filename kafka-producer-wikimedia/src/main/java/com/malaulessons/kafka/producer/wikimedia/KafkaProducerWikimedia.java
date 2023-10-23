/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.malaulessons.kafka.producer.wikimedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KafkaProducerWikimedia implements CommandLineRunner{

    public static void main(String[] args){
        SpringApplication.run(KafkaProducerWikimedia.class, args);
    }

    @Autowired
    private WikimediaChangesProducer wikimediaChangesProducer;
    
    @Override
    public void run(String... args) throws Exception {
        wikimediaChangesProducer.sendMessage();
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

