package com.uliconsulting.picpaybackend.autorization;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.uliconsulting.picpaybackend.transaction.Transaction;

@Service
public class AuthorizerService {

    // No SprinBoot 3.2 temos o RestClient para camar serviços externos via http
    private RestClient restClient;
 
    //faço a injecção do builder e com builder posso chamar a URl
    public AuthorizerService(RestClient.Builder builder){
        this.restClient = builder
        .baseUrl("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc")
        .build();

    }


    //Aqui terei um metodo que recebe a transacao e faz o trabajo de autorizar ou não  
    @SuppressWarnings("null")
    public void authorize(Transaction transaction){
       //Devo usar post para melhoria em vez de get, retrieve para converter em entidade
       //Chamo o autorizador e espero a resposta de forma sincrona, porq se responder uma excepção a transação e invalidada  faço rollback  
        var response = restClient.get()
            .retrieve()
            .toEntity(Authorization.class);

            if (response.getStatusCode().isError() || !response.getBody().isAuthorized()) {
                throw new UnauthorizedTransactionException("Unauthorized transaction!");                
            }
    }
    
}
