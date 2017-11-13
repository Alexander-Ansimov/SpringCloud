package com.ogasimov.labs.springcloud.microservices.guest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("Bill")
public interface BillClient {

    @DeleteMapping("/bills/{tableId}")
    void payBills(@PathVariable("tableId") Integer tableId);
}
