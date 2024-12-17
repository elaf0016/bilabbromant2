package com.example.bilabbromant2.Controller;



import com.example.bilabbromant2.Model.Bil;
import com.example.bilabbromant2.Service.BilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BilController {
    @Autowired
    BilService bilService;
    @GetMapping("/bil/viewAll")
    public String indexBil(Model model) {
        model.addAttribute("biler", bilService.fetchAllBil());
        return "home/bil/viewAllBil";
    }

    @GetMapping("/bil/create")
    public String createBil(Model model) {
        model.addAttribute("bil", new Bil());
        return "home/bil/createBil";
    }

    @PostMapping("/bil/create")
    public String createBil(@ModelAttribute Bil b) {
        bilService.addBil(b);
        return "redirect:/";
    }

    @GetMapping("/bil/deleteBil/{stelnummer}")
    public String deleteBil(@PathVariable("stelnummer") String stelnummer) {
        boolean deleted = bilService.deleteBil(stelnummer);
        if (deleted) {
            return "redirect:/bil/viewAll";
        } else {
            return "redirect:/bil/viewAll";
        }
    }

    @GetMapping("/bil/updateBil/{stelnummer}")
    public String updateBil(@PathVariable("stelnummer") String stelnummer, Model model) {
        model.addAttribute("bil", bilService.findBilByStelNummer(stelnummer));
        return "home/bil/updateBil";
    }

    @PostMapping("/bil/updateBil")
    public String update(@ModelAttribute Bil bil) {
        bilService.updateBil(bil);
        return "redirect:/bil/viewAll";
    }
    @GetMapping("/bil/view/{stelnummer}")
    public String viewBil(@PathVariable("stelnummer") String stelnummer, Model model) {

        model.addAttribute("bil", bilService.findBilByStelNummer(stelnummer));

        return "home/bil/viewOneBil";
    }


}
