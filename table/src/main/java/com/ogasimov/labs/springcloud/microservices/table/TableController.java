package com.ogasimov.labs.springcloud.microservices.table;

import java.util.List;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TableController {
    @Autowired
    private TableService tableService;

    @HystrixCommand(fallbackMethod = "myFallBack")
    @GetMapping("/tables")
    public List<Integer> getTables() {
        return tableService.getTableIds();
    }

    @GetMapping("/tables/free")
    public List<Integer> getFreeTables() {
        return tableService.getFreeTableIds();
    }

    @PutMapping("/table/{id}/free")
    public void freeTable(@PathVariable Integer id) {
        tableService.updateTable(id, true);
    }

    @PutMapping("/table/{id}/occupy")
    public void occupyTable(@PathVariable Integer id) {
        tableService.updateTable(id, false);
    }

    public void myFallBack() throws Exception {
        throw new Exception(">>> ERROR IN TableController <<<");
    }
}
