package com.zqk.ronghua.controller;

import com.zqk.ronghua.service.AdminService;
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
    @Autowired
    private AdminService adminService;
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/index")
    public String index_() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    @GetMapping("/furnitures")
    public String furnitures() {
        return "furnitures";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/contact")
    public String doContact(@RequestParam("name") String name,
                            @RequestParam("email") String email,
                            @RequestParam("phonenumber") String phonenumber,
                            @RequestParam("text") String text,
                            Model model) {
        if (name == null || name == "") {
            model.addAttribute("error", "姓名不能为空");
            return "contact";
        }
        if ((phonenumber == null || phonenumber == "") && (email == null || email == "")) {
            model.addAttribute("error", "电话号码或邮箱不能同时为空");
            return "contact";
        }else {
            model.addAttribute("error", "您已成功发送信息，感谢您的关注和支持，稍后我们会派专人与您联系！");
        }
        userService.create(name, email, phonenumber, text);
        return "contact";
    }
    @PostMapping("/contact_index")
    public String doContact_index(@RequestParam("name") String name,
                            @RequestParam("email") String email,
                            @RequestParam("phonenumber") String phonenumber,
                            @RequestParam("text") String text,
                            Model model) {
        if (name == null || name == "") {
            model.addAttribute("error", "姓名不能为空");
            return "index";
        }
        if ((phonenumber == null || phonenumber == "") && (email == null || email == "")) {
            model.addAttribute("error", "电话号码或邮箱不能同时为空");
            return "index";
        }else {
            model.addAttribute("error", "您已成功发送信息，感谢您的关注和支持，稍后我们会派专人与您联系！");
        }
        userService.create(name, email, phonenumber, text);
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        System.out.println("hello world!");
        model.addAttribute("users", adminService.findAll());
        return "admin";
    }

    @PostMapping("/login")
    public String doContact(@RequestParam("password") String password) {
        if(password.equals("123456"))
            return "redirect:/admin";
        else
            return "login";
    }

    @GetMapping("/delete")
    public String delete(){
        adminService.deleteAll();
        return "redirect:/admin";
    }
}

