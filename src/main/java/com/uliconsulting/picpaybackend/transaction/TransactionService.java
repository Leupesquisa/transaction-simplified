package com.uliconsulting.picpaybackend.transaction;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uliconsulting.picpaybackend.autorization.AuthorizerService;
import com.uliconsulting.picpaybackend.notification.NotificationService;
import com.uliconsulting.picpaybackend.wallet.Wallet;
import com.uliconsulting.picpaybackend.wallet.WalletRepository;
import com.uliconsulting.picpaybackend.wallet.WalletType;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final WalletRepository walletRepository;
    private final AuthorizerService athorizerService;
    private final NotificationService notificationService;



    public TransactionService (TransactionRepository transactionRepository, WalletRepository walletRepository, AuthorizerService athorizerService, NotificationService notificationService){
            this.transactionRepository= transactionRepository;
            this.walletRepository= walletRepository;
            this.athorizerService = athorizerService;
            this.notificationService = notificationService;

    }

    @SuppressWarnings("null")
    @Transactional
    public Transaction create(Transaction transaction){

      
        validate(transaction);        


    
        var newTransaction =  transactionRepository.save(transaction);

         var walletPayer = walletRepository.findById(transaction.payer()).get();
         var walletPayee = walletRepository.findById(transaction.payer()).get(); 
     
         walletRepository.save(walletPayer.debit(transaction.value()));
   
         walletRepository.save(walletPayee.credit(transaction.value()));

         athorizerService.authorize(transaction);

          
          notificationService.notify(); 


    return newTransaction;

    }
    
        @SuppressWarnings("null")
        private void validate(Transaction transaction) {
               
            walletRepository.findById(transaction.payee())
                .map(payee -> walletRepository.findById(transaction.payer())
                    .map(payer -> isTransactionValid(transaction, payer) ? transaction : null)
                  
                    .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - "+ transaction)))
                .orElseThrow(() -> new InvalidTransactionException("Invalid transaction - %s".formatted(transaction)));
       
        }

        private boolean isTransactionValid(Transaction transaction, Wallet payer){
            return payer.type() == WalletType.COMUM.getValue() &&
                   payer.balance().compareTo(transaction.value()) >= 0 &&
                   !payer.id().equals(transaction.payee());     

        }

        public List<Transaction> getTransaction() {
           return transactionRepository.findAll();
        }
}
