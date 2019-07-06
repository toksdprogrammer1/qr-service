package com.netpluspay.visa.qr.Controller;


import com.netpluspay.visa.qr.Controller.Response.CashInPostResponse;
import com.netpluspay.visa.qr.Controller.Response.CashOutPostResponse;
import com.netpluspay.visa.qr.Controller.Response.ReceiveP2MpostResponse;
import com.netpluspay.visa.qr.Model.*;

import com.netpluspay.visa.qr.services.VisaQRService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
@RequestMapping("/")
public class VisaController {

    //private static Logger logger = LoggerFactory.getLogger(VisaController.class);
    private final VisaQRService visaQRService;

    @Autowired
    public VisaController(VisaQRService visaQRService){
        this.visaQRService = visaQRService;

    }

    @CrossOrigin
    @RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public ResponseEntity<String> hello() {

        return new ResponseEntity<>("Hello World", HttpStatus.OK);

    }

    @CrossOrigin
    @RequestMapping(path = "/qr-service-0.0.1-SNAPSHOT/pushpayment/transactions/receive/p2m", method = RequestMethod.POST)
    public ResponseEntity<ReceiveP2MpostResponse> postreceiveP2M(@Valid @RequestBody ReceiveP2MpostPayload receiveP2MpostPayload, final BindingResult errors) {
        //logger.info(receiveP2MpostPayload.toString());
        if(errors.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            //logger.info(receiveP2MpostPayload.toString());
            receiveP2MpostPayload = visaQRService.saveReceiveP2MpostPayload(receiveP2MpostPayload);
            ReceiveP2MpostResponse receiveP2MpostResponse = new ReceiveP2MpostResponse();
            receiveP2MpostResponse.setMerchantCategoryCode("522");
            receiveP2MpostResponse.setResponseCode("00");
            receiveP2MpostResponse.setMerchantCity("Lagos");
            receiveP2MpostResponse.setMerchantName(receiveP2MpostPayload.getConsumerName());
            return new ResponseEntity<>(receiveP2MpostResponse, HttpStatus.OK);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/qr-service-0.0.1-SNAPSHOTpushpayment/advice/receive/p2m", method = RequestMethod.POST)
    public ResponseEntity postReceiveP2MAdvice(@Valid @RequestBody ReceiveP2MAdvicepostPayload receiveP2MAdvicepostPayload, final BindingResult errors) {
        if(errors.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try {
            //logger.info(receiveP2MAdvicepostPayload.toString());
            visaQRService.saveReceiveP2MAdvicepostPayload(receiveP2MAdvicepostPayload);

            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception ex){
           // logger.info(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/qr-service-0.0.1-SNAPSHOT/pushpayment/transactions/receive/ci", method = RequestMethod.POST)
    public ResponseEntity<CashInPostResponse> postCashIn(@Valid @RequestBody CashInpostPayload cashInpostPayload, final BindingResult errors) {

        if(errors.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            visaQRService.saveCashInpostPayload(cashInpostPayload);
            CashInPostResponse cashInPostResponse = new CashInPostResponse();
            cashInPostResponse.setResponseCode("00");
            return new ResponseEntity<>(cashInPostResponse, HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/qr-service-0.0.1-SNAPSHOTpushpayment/advice/receive/ci ", method = RequestMethod.POST)
    public ResponseEntity postCashInAdvice(@Valid @RequestBody CashInAdvicepostPayload cashInAdvicepostPayload, final BindingResult errors) {
        if(errors.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try {
            visaQRService.saveCashInAdvicepostPayload(cashInAdvicepostPayload);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/qr-service-0.0.1-SNAPSHOT/pushpayment/transactions/receive/co", method = RequestMethod.POST)
    public ResponseEntity<CashOutPostResponse> postCashOut(@Valid @RequestBody CashOutPostPayload cashOutPostPayload, final BindingResult errors) {

        if(errors.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            visaQRService.saveCashOutPostPayload(cashOutPostPayload);
            CashOutPostResponse cashOutPostResponse = new CashOutPostResponse();
            cashOutPostResponse.setResponseCode("00");
            cashOutPostResponse.setAgentName(cashOutPostPayload.getAgentName());
            return new ResponseEntity<>(cashOutPostResponse, HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @RequestMapping(path = "/qr-service-0.0.1-SNAPSHOT/pushpaymentadvice/receive/co ", method = RequestMethod.POST)
    public ResponseEntity postCashInAdvice(@Valid @RequestBody CashOutAdvicepostPayload cashOutAdvicepostPayload, final BindingResult errors) {
        if(errors.hasErrors()){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        try {
            visaQRService.saveCashOutAdvicepostPayload(cashOutAdvicepostPayload);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @CrossOrigin
    @RequestMapping(path = "qr-service-0.0.1-SNAPSHOT", method = RequestMethod.POST)
    public ResponseEntity<String> connect() {

        return new ResponseEntity<>("Connected", HttpStatus.OK);

    }

}
