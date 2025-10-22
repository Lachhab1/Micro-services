package net.ccn36.part3.billingservice.web;

import net.ccn36.part3.billingservice.entity.Bill;
import net.ccn36.part3.billingservice.entity.ProductItem;
import net.ccn36.part3.billingservice.feign.CustomerRestClient;
import net.ccn36.part3.billingservice.feign.ProductRestClient;
import net.ccn36.part3.billingservice.repository.BillRepository;
import net.ccn36.part3.billingservice.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class BillRestController {

    @Autowired
    private BillRepository billRepository;
    @Autowired
    private ProductItemRepository productItemRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/bills/{billId}")
    public Bill getBill(@PathVariable Long billId) {
        Bill bill = billRepository.findById(billId)
                .orElseThrow(() -> new RuntimeException("Bill not found"));

        List<ProductItem> items = productItemRepository.findByBillId(bill.getId());

        items.forEach(item -> item.setProduct(productRestClient.findProductById(item.getProductId())));

        bill.setProductItems(items);

        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));

        return bill;
    }

    @GetMapping("/bills")
    public List<Bill> getBills() {
        List<Bill> bills = billRepository.findAll();
        bills.forEach(bill -> {
            List<ProductItem> items = productItemRepository.findByBillId(bill.getId());
            items.forEach(item -> item.setProduct(productRestClient.findProductById(item.getProductId())));
            bill.setProductItems(items);
            bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        });
        return bills;
    }
}
