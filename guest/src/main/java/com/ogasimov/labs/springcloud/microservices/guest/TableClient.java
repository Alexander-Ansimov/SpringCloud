package com.ogasimov.labs.springcloud.microservices.guest;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("table")
public interface TableClient {

    @GetMapping("/tables/free")
    List<Integer> getFreeTables();

    @PutMapping("/table/{id}/free")
    void freeTable(@PathVariable("id") Integer id);

    @PutMapping("/table/{id}/occupy")
    void occupyTable(@PathVariable("id") Integer id);
}
