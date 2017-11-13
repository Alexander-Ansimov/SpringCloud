package com.ogasimov.labs.springcloud.microservices.guest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("order")
public interface OrderClient {

    @PostMapping("/order/{tableId}")
    Integer createOrder(@PathVariable("tableId") Integer tableId,  List<Integer> menuItems);
}
