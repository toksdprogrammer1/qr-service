package com.netpluspay.visa.qr.Controller;

import com.netpluspay.visa.qr.services.QRImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/qr")
public class QRController {
    //public static final Logger logger = LoggerFactory.getLogger(MerchantEnablementService.class);

    private final QRImageService qrImageService;

    @Autowired
    public QRController(QRImageService qrImageService) {
        this.qrImageService = qrImageService;
    }


    @RequestMapping(path= "GetImage" ,method = RequestMethod.GET)
    public ResponseEntity getImage(@RequestParam String merchantId, @RequestParam String merchantName,
                                   @RequestParam String referenceId, @RequestParam(defaultValue="0") double amount) {
        byte[] imgData = qrImageService.generateQrImageDataToTransfer(merchantId, merchantName);
        if (imgData == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);
            return new ResponseEntity(imgData, headers, HttpStatus.OK);
        }
    }
}
