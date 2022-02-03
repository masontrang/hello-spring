package com.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Objects;

/**
 * Created by Mason Trang
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

//    // Handles requests at /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    // Handles requests at /goodbye
    @GetMapping("goodbye")
//    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // lives at /hello/hello
    // Handles requests of the form /hello?name=LaunchCode
//    @GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name, String language){
        if (Objects.equals(language, "English")) {
            return "Hello, " + name + "!";
        }
        else if (Objects.equals(language, "Spanish")){
            return "Hola, " + name + "!";
        }
        else if (Objects.equals(language, "French")){
            return "Bonjour, " + name + "!";
        }
        else if (Objects.equals(language, "Chinese")){
            return "Chinese, " + name + "!";
        }
        else if (Objects.equals(language, "Spider")){
            return "Spiderspider, " + name + "!";
        }
        else{
            return "";
        }
    }

//    // Handles requests of the form /hello/LaunchCode
//    @GetMapping("hello/{name}")
////    @ResponseBody
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    // lives at /hello/form
    @GetMapping("form")
//    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit a request to /hello
                "<input type='text' name='name'>" +
                "<select name='language' id='language-select'>" +
                "    <option value=>--Please choose an language--</option>" +
                "    <option value='English'>English</option>" +
                "    <option value='Spanish'>Spanish</option>" +
                "    <option value='French'>French</option>" +
                "    <option value='Chinese'>Chinese</option>" +
                "    <option value='Spider'>Spider</option>" +
                "</select>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
