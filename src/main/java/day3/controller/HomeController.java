package day3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("data", "Hello, Spring from IntelliJ! :)");
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/login_proc")
    public String login_proc() {
        return "login_proc";
    }

    @RequestMapping("/updateBoard_proc")
    public String updateBoard_proc() {
        return "updateBoard_proc";
    }

    @RequestMapping("/logout_proc")
    public String logout_proc() {
        return "logout_proc";
    }

    @RequestMapping("/deleteBoard_proc")
    public String deleteBoard_proc() {
        return "deleteBoard_proc";
    }
    @RequestMapping("/getBoard")
    public String getBoard() {
        return "getBoard";
    }

    @RequestMapping("/getBoardList")
    public String getBoardList() {
        return "getBoardList";
    }

    @RequestMapping("/insertBoard")
    public String insertBoard() {
        return "insertBoard";
    }

    @RequestMapping("/insertBoard_proc")
    public String insertBoard_proc() {
        return "insertBoard_proc";
    }
}