package com.netpluspay.visa.qr.Controller.Response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class QRData {

    private String payloadFormatIndicatorTAG00;
    private String mVisaMerchantPanTAG02;
    private String merchantAliasAG03;
    private String masterCardPan1TAG04;
    private String masterCardPan2TAG05;
    private String merchantCategoryCodeTAG552;
    private String currencyCodeTAG53;
    private String transactionAmountTAG54;
    private String convenienceFeeIndicatorTAG55;
    private String convenienceFeeAmountTAG556;
    private String convenienceFeePercentageTAG57;
    private String countryCodeTAG58;
    private String merchantNameTAG59;
    private String cityNameTAG60;
    private String postalCodeTAG61;
}
