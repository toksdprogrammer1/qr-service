package com.netpluspay.visa.qr.Controller.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class CashOutPostResponse {

    private String responseCode;

    private String authIdResponse;

    private String receiverTransactionId;

    private String agentName;

    private String agentCity;

    private String agentCountryCode;
}
