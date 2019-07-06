package com.netpluspay.visa.qr.Model;




import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Data
@EqualsAndHashCode
public class ReceiveP2MpostPayload {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    private String localTransactionTime;


    private String billIdFormat;

    @NotNull
    private String originatorCountryCode;

    @NotNull
    private String decimalPositionIndicator;


    private String transactionFeeAmount;


    @NotNull
    private String transactionCurrencyCode;



    private String velocityLimitIndicator;


    @Transient
    private String encMerchantPAN;

    private String merchantPAN;


    @NotNull
    private String retrievalReferenceNumber;


    @NotNull
    private String systemTraceAuditNumber;


    @NotNull
    private String localTransactionDate;


    @Transient
    private String encConsumerName ;

    private String consumerName ;

    private String refId;

    @NotNull
    private String originatorBIN;

    private String billId;

    @Transient
    private String encConsumerPAN;

    private String consumerPAN;

    @NotNull
    private String visaTransactionId;


    @NotNull
    private String transactionAmount;


    @NotNull
    private String transmissionDateTime;


}

