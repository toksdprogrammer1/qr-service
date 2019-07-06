package com.netpluspay.visa.qr.util;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWEDecrypter;
import com.nimbusds.jose.JWEObject;
import com.nimbusds.jose.crypto.AESDecrypter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Arrays;

@Component
public class DecryptUtil {

    //public static Logger logger = LoggerFactory.getLogger(DecryptUtil.class);



    @Value("${mes.sharedSecret}")
    private  String sharedSecret;

    public  String decrypt(String encryptedText) {
        //String sharedSecret = env.getProperty("mes.sharedSecret");
        System.out.println(sharedSecret);
        JWEObject jweObject = null;
        try {
            jweObject = JWEObject.parse(encryptedText);
            JWEDecrypter decrypter = new AESDecrypter(getKeyBytes());
            jweObject.decrypt(decrypter);
            System.out.println(jweObject.getPayload().toString());
            return jweObject.getPayload().toString();
        } catch (ParseException | JOSEException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    private  byte [] getKeyBytes(){

        MessageDigest sha = null;
        byte[] key = null;
        try {
            key = sharedSecret.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-256");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 32); // use only first 256 bit

        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return key;
    }
}
