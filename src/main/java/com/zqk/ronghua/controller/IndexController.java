package com.zqk.ronghua.controller;

import com.zqk.ronghua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/index")
    public String index_(){
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }
    @GetMapping("/furnitures")
    public String furnitures(){
        return "furnitures";
    }

    @PostMapping("/contact")
    public String doContact(@RequestParam("name") String name,
                            @RequestParam("email") String email,
                            @RequestParam("phonenumber") String phonenumber,
                            @RequestParam("text") String text,
                            Model model){
        if(name == null || name == ""){
            model.addAttribute("error","姓名不能为空");
            return "contact";
        }
        if((phonenumber == null || phonenumber == "")&&(email == null ||email=="")){
            model.addAttribute("error","电话号码或邮箱不能同时为空");
            return "contact";
        }
        userService.create(name,email,phonenumber,text);
        return "redirect:/contact";
    }
    @PostMapping("/index")
    public String doIndex(@RequestParam("name") String name,
                            @RequestParam("email") String email,
                            @RequestParam("phonenumber") String phonenumber,
                            @RequestParam("text") String text,
                            Model model){
        if(name == null || name == ""){
            model.addAttribute("error","姓名不能为空");
            return "index";
        }
        if((phonenumber == null || phonenumber == "")&&(email == null ||email=="")){
            model.addAttribute("error","电话号码或邮箱不能同时为空");
            return "index";
        }
        userService.create(name,email,phonenumber,text);
        return "redirect:/index";
    }
}
