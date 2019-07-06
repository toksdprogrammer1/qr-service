package com.netpluspay.visa.qr.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode
public class CashOutAdvicepostPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private String localTransactionTime;

    @NotNull
    private String visaTransactionId;


    @NotNull
    private String originatorCountryCode;


    @NotNull
   private String decimalPositionIndicator;


    @NotNull
   private String retrievalReferenceNumber;


    @NotNull
   private String velocityLimitIndicator;


    @NotNull
   private String agentCountryCode;

    @Transient
   private String encConsumerName;

   private String consumerName;

    @NotNull
   private String messageType;


    @NotNull
    private String rejectionCode;

    @NotNull
    private String localTransactionDate;


   @Transient
    private String encAgentPAN ;

    private String agentPAN;


    private String originatorBIN;


    private String systemTraceAuditNumber;



    private String responseCode;



    private String transactionCurrencyCode;


    @Transient
    private String encConsumerPAN;

    private String consumerPAN;


    private String agentCity;


    private String transactionAmount;



    private String authIdResponse;



    private String transmissionDateTime;

}
