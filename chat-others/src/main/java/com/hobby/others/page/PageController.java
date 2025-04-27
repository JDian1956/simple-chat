package com.hobby.others.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@Controller
public class PageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/websocket")
    public String websocket() {
        return "websocket";
    }

    @GetMapping("/stomp")
    public String stomp() {
        return "stomp";
    }
}
