package com.netpluspay.visa.qr.services;

import com.netpluspay.visa.qr.Model.*;
import com.netpluspay.visa.qr.Repository.*;

import com.netpluspay.visa.qr.util.DecryptUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


@Service
public class VisaQRService {

    @Autowired
    private ReceiveP2MAdvicepostPayloadRepository receiveP2MAdvicepostPayloadRepository;

    @Autowired
    private ReceiveP2MpostPayloadRepository receiveP2MpostPayloadRepository;

    @Autowired
    private CashInAdvicePayloadRepository cashInAdvicePayloadRepository;

    @Autowired
    private CashInPostPayloadRepository cashInPostPayloadRepository;

    @Autowired
    private CashOutAdvicePayloadRepository cashOutAdvicePayloadRepository;

    @Autowired
    private CashOutPayloadRepository cashOutPayloadRepository;

    @Autowired
    private DecryptUtil decryptUtil;


    public ReceiveP2MpostPayload saveReceiveP2MpostPayload(ReceiveP2MpostPayload receiveP2MpostPayload){

        receiveP2MpostPayload.setConsumerName(decryptUtil.decrypt(receiveP2MpostPayload.getEncConsumerName()));
        receiveP2MpostPayload.setConsumerPAN(decryptUtil.decrypt(receiveP2MpostPayload.getEncConsumerPAN()));
        receiveP2MpostPayload.setMerchantPAN(decryptUtil.decrypt(receiveP2MpostPayload.getEncMerchantPAN()));
        return receiveP2MpostPayloadRepository.saveAndFlush(receiveP2MpostPayload);
    }

    public ReceiveP2MAdvicepostPayload saveReceiveP2MAdvicepostPayload(ReceiveP2MAdvicepostPayload receiveP2MAdvicepostPayload){

        receiveP2MAdvicepostPayload.setConsumerName(decryptUtil.decrypt(receiveP2MAdvicepostPayload.getEncConsumerName()));
        receiveP2MAdvicepostPayload.setConsumerPAN(decryptUtil.decrypt(receiveP2MAdvicepostPayload.getEncConsumerPAN()));
        receiveP2MAdvicepostPayload.setMerchantPAN(decryptUtil.decrypt(receiveP2MAdvicepostPayload.getEncMerchantPAN()));
        return receiveP2MAdvicepostPayloadRepository.saveAndFlush(receiveP2MAdvicepostPayload);
    }

    public CashInpostPayload saveCashInpostPayload(CashInpostPayload cashInpostPayload){

        cashInpostPayload.setConsumerPAN(decryptUtil.decrypt(cashInpostPayload.getEncAgentName()));
        cashInpostPayload.setAgentName(decryptUtil.decrypt(cashInpostPayload.getEncAgentName()));
        return cashInPostPayloadRepository.saveAndFlush(cashInpostPayload);
    }

    public CashInAdvicepostPayload saveCashInAdvicepostPayload(CashInAdvicepostPayload cashInAdvicepostPayload){

        cashInAdvicepostPayload.setConsumerPAN(decryptUtil.decrypt(cashInAdvicepostPayload.getEncConsumerPAN()));
        cashInAdvicepostPayload.setAgentName(decryptUtil.decrypt(cashInAdvicepostPayload.getEncAgentName()));

        return cashInAdvicePayloadRepository.saveAndFlush(cashInAdvicepostPayload);
    }

    public CashOutPostPayload saveCashOutPostPayload(CashOutPostPayload cashOutPostPayload){

        cashOutPostPayload.setConsumerPAN(decryptUtil.decrypt(cashOutPostPayload.getEncAgentName()));
        cashOutPostPayload.setAgentName(decryptUtil.decrypt(cashOutPostPayload.getEncAgentName()));
        cashOutPostPayload.setAgentPAN(decryptUtil.decrypt(cashOutPostPayload.getEncAgentPAN()));
        return cashOutPayloadRepository.saveAndFlush(cashOutPostPayload);
    }

    public CashOutAdvicepostPayload saveCashOutAdvicepostPayload(CashOutAdvicepostPayload cashOutAdvicepostPayload){

        cashOutAdvicepostPayload.setConsumerPAN(decryptUtil.decrypt(cashOutAdvicepostPayload.getEncConsumerPAN()));
        cashOutAdvicepostPayload.setConsumerName(decryptUtil.decrypt(cashOutAdvicepostPayload.getEncConsumerName()));
        cashOutAdvicepostPayload.setAgentPAN(decryptUtil.decrypt(cashOutAdvicepostPayload.getEncAgentPAN()));

        return cashOutAdvicePayloadRepository.saveAndFlush(cashOutAdvicepostPayload);
    }

}
