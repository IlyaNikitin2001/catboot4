package catboot4.controller;

import catboot4.model.Cat;
import catboot4.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by USER on 11.11.2017.
 */
@Controller
public class GreetingController {
    @Autowired
    CatService catService;

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "greeting";
    }
    @PostMapping("/addcats")
    public String getDog(@ModelAttribute("cat") Cat cat , Model model ){
        catService.create(cat);
        List<Cat> catsList = catService.catList();
        model.addAttribute("cat", new Cat());
        model.addAttribute("catsList", catsList);
        return "result";
    }
    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable int id){
        catService.deleteById(id);
        return "redirect:/";
    }
}