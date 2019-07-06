package com.netpluspay.visa.qr.Controller.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CashInPostResponse {

    private String authIdResponse;


    private String responseCode;


    private String receiverTransactionId;

}
