package com.netpluspay.visa.qr.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown=true)
public class Merchant implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String merchantName;
    private String merchantId;
    private String email;
    private String phone;
    private String bvn;
    private String bank;
    private String address;
    private String state;
    private String country;
    private Date datetime = new Date();


}
