package com.netpluspay.visa.qr.Repository;

import com.netpluspay.visa.qr.Model.CashOutPostPayload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashOutPayloadRepository extends JpaRepository<CashOutPostPayload, String> {
}
