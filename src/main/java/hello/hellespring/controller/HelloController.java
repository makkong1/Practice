package hello.hellespring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "Hello World");
        return "Hello";
    }

    @GetMapping("hello_mvc")
    public String hello_mvc(@RequestParam("name") String name,  Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
