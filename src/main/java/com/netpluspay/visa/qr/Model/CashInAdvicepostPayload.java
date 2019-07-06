package com.netpluspay.visa.qr.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode
public class CashInAdvicepostPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String localTransactionTime;


    private String visaTransactionId;



    private String originatorCountryCode;


    private String decimalPositionIndicator;


    private String transactionCurrencyCode;



    private String velocityLimitIndicator;


    private String retrievalReferenceNumber;

    @Transient
    private String encAgentName;

    private String agentName;


    private String messageType ;

    @Transient
    private String encConsumerPAN;

    private String consumerPAN;


    private String localTransactionDate;



    private String originatorBIN ;


    private String systemTraceAuditNumber;



    private String responseCode;


    private String agentCity;


    private String rejectionCode;



    private String transactionAmount;



    private String authIdResponse;


    private String transmissionDateTime;

}
