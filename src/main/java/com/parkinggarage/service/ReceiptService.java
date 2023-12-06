package com.parkinggarage.service;

import com.parkinggarage.billing.Receipt;
import com.parkinggarage.billing.Ticket;

public interface ReceiptService {
    Receipt generateReceipt(Ticket ticket) throws Exception;
}
