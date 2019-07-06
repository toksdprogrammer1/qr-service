package com.netpluspay.visa.qr.services;


import com.mastercard.labs.mpqriot.qrsdk.domain.MerchantQrFromClient;
import com.netpluspay.visa.mpqriot.qrsdk.QRUtil;
//import com.netpluspay.visa.mpqriot.qrsdk.domain.MerchantQrFromClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

@Service
public class QRImageService {

    public static final Logger logger = LoggerFactory.getLogger(QRImageService.class);

    public byte[] generateQrImageDataToTransfer(String qrCode, String shortCode) {
        BufferedImage bImage = null;
        byte[] imgData = null;
        try {
            String qrImagePath = qrImagePath(qrCode, shortCode);
            bImage = ImageIO.read(new File(qrImagePath));

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", bos);
            imgData = bos.toByteArray();
            return imgData;
        } catch (IOException ex) {
            ex.printStackTrace();
            logger.info("error preparing qr image for http request!");
            return null;
        }

    }

    private String qrImagePath(String qrCode, String shortCode) {
        QRUtil qrUtil;
        String merchantPathCustomized = QRUtil.class.getClassLoader().getResource("MES_branding.png").toString();

        try {
            qrUtil = new QRUtil();
            MerchantQrFromClient merchantQrFromClient = new MerchantQrFromClient();
            merchantQrFromClient.setMerchantSdsAlias(shortCode);
            merchantQrFromClient.setQrCode(qrCode);
            merchantQrFromClient.setMerchantPathCustomized(merchantPathCustomized);

            String qrImagePath = qrUtil.generateQR(merchantQrFromClient);
            System.out.println("qrimagepath =  " + qrImagePath);
            return qrImagePath;
        } catch (Exception e) {
            logger.info("error generating qrImage!");
            e.printStackTrace();
        }
        return null;

    }

}
