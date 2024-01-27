package example.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("string-hello")
    @ResponseBody   // HttpMessageConverter -> StringConverter
    public String Hello(@RequestParam("data") String data, Model model) {

        return "hello " + data;
    }

    @GetMapping("api-hello")
    @ResponseBody   // HttpMessageConverter -> JsonConverter
    public Hello apiHello(@RequestParam("data") String data) {
        Hello hello = new Hello();
        hello.setName(data);

        return hello;
    }

    static class Hello {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
