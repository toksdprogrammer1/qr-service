package com.netpluspay.visa.qr.Repository;

import com.netpluspay.visa.qr.Model.CashInAdvicepostPayload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashInAdvicePayloadRepository extends JpaRepository<CashInAdvicepostPayload, String> {
}
