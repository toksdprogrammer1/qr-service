package com.netpluspay.visa.qr.Repository;

import com.netpluspay.visa.qr.Model.CashOutAdvicepostPayload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashOutAdvicePayloadRepository extends JpaRepository<CashOutAdvicepostPayload, String> {
}
