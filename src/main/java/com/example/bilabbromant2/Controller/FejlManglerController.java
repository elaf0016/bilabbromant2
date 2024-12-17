package com.example.bilabbromant2.Controller;
import com.example.bilabbromant2.Model.FejlMangler;
import com.example.bilabbromant2.Service.FejlManglerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FejlManglerController {
    @Autowired
    FejlManglerService fejlManglerService;

    @GetMapping("/fejlMangler/create")
    public String createFejlMangler(Model model) {
        model.addAttribute("fejlMangl", new FejlMangler());
        return "home/tilbagelevering/createFejlMangler";
    }
    @PostMapping("/fejlMangler/create")
    public String createFejlMangler(@ModelAttribute FejlMangler f) {
        fejlManglerService.addFejlMangler(f);
        return "redirect:/skadeUbedring";
    }


}
