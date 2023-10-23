/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.malaulessons.kafka.consumer.database.repository;

import com.malaulessons.kafka.consumer.database.entity.WikimediaData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface WikimediaDataRepository extends JpaRepository<WikimediaData, Long> {
    
}
