package com.uliconsulting.picpaybackend.notification;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.uliconsulting.picpaybackend.transaction.Transaction;

@Service
public class NotificationConsumer {
    private RestClient restClient;
    
    
    public NotificationConsumer(RestClient.Builder builder){
        this.restClient = builder
            .baseUrl("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6")
            .build();
    }

    // @KafkaListener(topics = "transaction-notification") para o consumo de forma assincrona
    @SuppressWarnings("null")
    @KafkaListener(topics = "transaction-notification", groupId = "pickpay-backend")    
    public void receivedNotification(Transaction transaction ){

        var response = restClient.get()
            .retrieve()
            .toEntity(Notification.class);
    //Se eu lançar uma Exception no KafkaListener a menssagem n é consumida, 
    //sendo entrgeue em tempo oportuno porq se n for consumida n sera removida do topico sera feito o rollback *  
        if(response.getStatusCode().isError() || !response.getBody().message())
             throw new NotificationException("Error Notification!");

    }
}
