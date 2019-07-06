package com.netpluspay.visa.qr.Controller;


import com.netpluspay.visa.qr.Controller.Response.QRData;
import com.netpluspay.visa.qr.Model.Merchant;
import com.netpluspay.visa.qr.Repository.MerchantRepository;
//import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@Api(value="NETPOS Endpoint", description="Query transactions notifications")
@RestController
@RequestMapping("/v1/smartpesa")
public class SmartPesaController {

    @Autowired
    private MerchantRepository merchantRepository;

    @PostMapping("/pushmerchant")
    public ResponseEntity<String> saveMerchant(@RequestBody Merchant merchant) {
        System.out.println(merchant.toString());
        merchantRepository.save(merchant);
        //push to masterpassqr laravel will be done here
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    @GetMapping(path = "/qrdata/{merchantId}")
    public ResponseEntity<QRData> getMerchantQRData(@PathVariable(name="merchantId", required=true)String merchantId) {

        Merchant merchant = merchantRepository.findByMerchantId(merchantId);
        if (merchant != null) {
            QRData qrData = new QRData();
            qrData.setMerchantNameTAG59("Test");
            qrData.setMasterCardPan1TAG04("524282020132391");
            qrData.setPayloadFormatIndicatorTAG00("01");
            qrData.setMVisaMerchantPanTAG02("4077134520222");
            qrData.setCityNameTAG60("Lagos");
            qrData.setCurrencyCodeTAG53("566");
            qrData.setMerchantCategoryCodeTAG552("6356");
            qrData.setCountryCodeTAG58("NG");
            return ResponseEntity.ok(qrData);
        }
        return ResponseEntity.notFound().build();
    }
}
