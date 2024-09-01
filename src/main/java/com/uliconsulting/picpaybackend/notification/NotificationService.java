package com.uliconsulting.picpaybackend.notification;

import org.springframework.stereotype.Service;

import com.uliconsulting.picpaybackend.transaction.Transaction;

@Service
public class NotificationService {
 
    // Vou usar o processo de transação assincrona para evitar ter mensaem de erros constantes reportadas pelos users
    //Muitos roolback de forma desnecessaria
    //Ou seja esta operação sera desacoplada e enviada de forma eventual, um atraso ok mas probelmas em fazer a transação seria complicado* 
    //Vou usar o kafka para mensageria, com 2 componentes NotificationProducer  e NotificationConsumer 
    public void notify(Transaction transaction){



    }    
}
