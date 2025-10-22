package net.ccn36.part3.billingservice.feign;

import net.ccn36.part3.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="product-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    public Product findProductById(@PathVariable String id);
    @GetMapping("/api/products")
    public PagedModel<Product> getAllProducts();
}
