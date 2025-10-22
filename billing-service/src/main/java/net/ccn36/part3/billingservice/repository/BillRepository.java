package net.ccn36.part3.billingservice.repository;

import net.ccn36.part3.billingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Long> {
}
