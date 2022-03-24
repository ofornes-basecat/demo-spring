package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GeneralController {

    @GetMapping("/")
    public String main(Model model) {
        return "index";
    }

    @GetMapping("/modals/modal1")
    public String modal1() {
        return "modal1";
    }

    @GetMapping("/modals/modal2")
    public String modal2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "modal2";
    }

    @GetMapping("/modals/no-implementat")
    public String modalNoImplementat(@RequestParam("element") String name, Model model) {
        model.addAttribute("element", name);
        return "no_implementat";
    }
}
