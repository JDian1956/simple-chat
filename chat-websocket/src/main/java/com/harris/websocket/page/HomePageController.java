package com.harris.websocket.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Harris
 */
@Controller
public class HomePageController {

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
