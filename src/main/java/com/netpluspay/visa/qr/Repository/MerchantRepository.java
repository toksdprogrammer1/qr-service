package com.netpluspay.visa.qr.Repository;

import com.netpluspay.visa.qr.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant, String> {

    Merchant findByMerchantId (String merchantId);
}
