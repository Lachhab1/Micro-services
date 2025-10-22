package net.ccn36.part3.billingservice.feign;

import net.ccn36.part3.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    public Customer findCustomerById(@PathVariable long id);
    @GetMapping("/api/customers")
    public PagedModel<Customer> getAllCustomers();

}
