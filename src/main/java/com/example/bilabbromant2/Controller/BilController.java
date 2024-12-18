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

    // Viser alle biler
    @GetMapping("/bil/viewAll")
    public String indexBil(Model model) {
        model.addAttribute("biler", bilService.fetchAllBil());
        return "home/bil/viewAllBil";
    }

    // Viser formular til oprettelse af en ny bil
    @GetMapping("/bil/create")
    public String createBil(Model model) {
        model.addAttribute("bil", new Bil());
        return "home/bil/createBil";
    }

    // Håndterer oprettelse af en ny bil
    @PostMapping("/bil/create")
    public String createBil(@ModelAttribute Bil b) {
        bilService.addBil(b);
        return "redirect:/bil/viewAll";
    }

    // Sletter en bil baseret på stelnummer
    @GetMapping("/bil/deleteBil/{stelnummer}")
    public String deleteBil(@PathVariable("stelnummer") String stelnummer) {
        boolean deleted = bilService.deleteBil(stelnummer);
        if (deleted) {
            return "redirect:/bil/viewAll";
        } else {
            return "redirect:/bil/viewAll";
        }
    }

    // Viser formular til opdatering af en eksisterende bil
    @GetMapping("/bil/updateBil/{stelnummer}")
    public String updateBil(@PathVariable("stelnummer") String stelnummer, Model model) {
        model.addAttribute("bil", bilService.findBilByStelNummer(stelnummer));
        return "home/bil/updateBil";
    }

    // Håndterer opdatering af en eksisterende bil
    @PostMapping("/bil/updateBil")
    public String update(@ModelAttribute Bil bil) {
        bilService.updateBil(bil);
        return "redirect:/bil/viewAll";
    }

    // Viser detaljer for en specifik bil baseret på stelnummer
    @GetMapping("/bil/view/{stelnummer}")
    public String viewBil(@PathVariable("stelnummer") String stelnummer, Model model) {
        model.addAttribute("bil", bilService.findBilByStelNummer(stelnummer));
        return "home/bil/viewOneBil";
    }


}
