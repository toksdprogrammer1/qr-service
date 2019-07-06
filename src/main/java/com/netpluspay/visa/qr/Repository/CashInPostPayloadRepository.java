package com.netpluspay.visa.qr.Repository;

import com.netpluspay.visa.qr.Model.CashInpostPayload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashInPostPayloadRepository extends JpaRepository<CashInpostPayload, String> {
}
