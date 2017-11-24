package catboot4.controller;


import catboot4.model.Cat;
import catboot4.service.CatService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Created by USER on 29.10.2017.
 */
@Controller
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MainController {
    @Autowired
    CatService catService;
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("catsList", catService.catList());
        model.addAttribute("cat", new Cat());
        return "index";
    }
    @PostMapping("/add")
    public String add(@ModelAttribute("cat") Cat cat, Model model){
        catService.create(cat);
        model.addAttribute("catsList", catService.catList());
        model.addAttribute("cat", new Cat());
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String update(@PathVariable int id , Model model){
        model.addAttribute("cat", catService.fetchById(id));
        return "update";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/error")
    public String erorr (Model model){
        model.addAttribute("loginError", true);
        return "erorr";
    }
}
