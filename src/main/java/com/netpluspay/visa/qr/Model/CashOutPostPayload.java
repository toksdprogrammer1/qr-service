package com.netpluspay.visa.qr.Model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@EqualsAndHashCode
public class CashOutPostPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Transient
    private String encAgentPAN;

    private  String agentPAN;


    private String localTransactionTime;



    private String visaTransactionId;



    private String originatorCountryCode;



    private String decimalPositionIndicator;



    private String transactionCurrencyCode;



    private String velocityLimitIndicator;



    private String retrievalReferenceNumber;



    private String systemTraceAuditNumber;



    private String localTransactionDate;


    @Transient
    private String encAgentName;

    private String agentName;



    private String originatorBIN;



    private String agentCity;


    @Transient
    private String encConsumerPAN;

    private String consumerPAN;


    private String transactionAmount;



    private String transmissionDateTime;

}
