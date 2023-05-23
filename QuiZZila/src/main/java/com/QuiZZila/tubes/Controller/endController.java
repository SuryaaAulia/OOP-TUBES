package com.QuiZZila.tubes.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class endController {
    @GetMapping("/end")
    public String endpage(Model end){
        return "endView.html";
    }
}
