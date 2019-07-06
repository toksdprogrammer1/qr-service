package com.netpluspay.visa.qr.Controller.Response;


import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode
public class ReceiveP2MpostResponse {



    private String merchantCity;



    private String merchantCategoryCode;



    private String feeProgramIndicator;



    private String merchantName;


    private String receiverTransactionId;


    private String merchantVerificationValue;


    private String merchantTerminalID;



    private String merchantCountryCode;



    private String responseCode;



    private String merchantID;



    private String authIdResponse;


}