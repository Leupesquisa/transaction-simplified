package com.uliconsulting.picpaybackend.notification;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.uliconsulting.picpaybackend.transaction.Transaction;

@Service
public class NotificationProducer {

    private final KafkaTemplate<String, Transaction> KafkaTemplate;

    public NotificationProducer(KafkaTemplate<String, Transaction> KafkaTemplate){

            this.KafkaTemplate= KafkaTemplate; 
    }
    // ENVIO DA TRANSAÇAO AO KAFKA
    public void sendNotification(Transaction transaction){
        KafkaTemplate.send("transaction-notification", transaction);
    }

    
    
}
