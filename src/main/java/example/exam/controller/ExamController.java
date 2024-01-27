package example.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExamController {

    @GetMapping("hello")
    public String hello(Model model) {

        model.addAttribute("data", "spring!!");

        return "hello";
    }

    @GetMapping("mvc-hello")
    public String mvcHello(@RequestParam("data") String data, Model model) {

        model.addAttribute("data", data);

        return "mvc-hello";
    }
}
