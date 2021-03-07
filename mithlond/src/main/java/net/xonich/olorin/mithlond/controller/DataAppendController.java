package net.xonich.olorin.mithlond.controller;

import net.xonich.olorin.mithlond.service.DataAppenderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mithlond")
public class DataAppendController {
    private final DataAppenderService dataAppenderService;

    public DataAppendController(DataAppenderService dataAppenderService) {
        this.dataAppenderService = dataAppenderService;
    }

    @PostMapping("/add/record")
    public String addRecord(@RequestBody String rec) {
        dataAppenderService.appendRecord(rec);
        return "success";
    }
}
