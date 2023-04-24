package ru.kaleev.SpringCourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage (@RequestParam(value = "name", required = false) String name, Model model){
        //System.out.println("Hello " + name);
        model.addAttribute("message", "Hello " + name);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage (){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b")int b, @RequestParam("action") String action, Model model){

        int answer = 0;
        switch (action) {
            case "multiplication":
                answer = a * b;
                break;
            case "addition":
                answer = a + b;
                break;
            case "subtraction":
                answer = a - b;
                break;
            case "division":
                answer = a / b;
                break;
        }

        model.addAttribute("answer", answer);

        return "first/calculator";
    }
}
