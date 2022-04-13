package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name ", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //"http에서 body부에 return문을 직접 넣어 주겠다"라는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;  //"hello spring"
    }

    //데이터를 반환해야 할경우, API를 사용하는 경우가 많다.
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }   //기본적인 Api방식, json은 key(name): value

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
