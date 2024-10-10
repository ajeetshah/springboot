package com.learn.springboot.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/messaging")
public class MessagingController {

    @Autowired
    private MessagingService messagingService;

    @PostMapping("/set/{key}/{value}")
    public void setValue(@PathVariable String key, @PathVariable String value) {
        messagingService.saveValue(key, value);
    }

    @GetMapping("/get/{key}")
    public Object getValue(@PathVariable String key) {
        return messagingService.getValue(key);
    }
}
