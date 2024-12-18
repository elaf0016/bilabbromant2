package com.example.bilabbromant2.Controller;
import com.example.bilabbromant2.Model.Lejeaftale;
import com.example.bilabbromant2.Service.BilService;
import com.example.bilabbromant2.Service.LejeaftaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/lejeaftale")

@Controller
public class LejeaftaleController {

    @Autowired
    LejeaftaleService lejeaftaleService;

    // Viser forsiden for dataregistrering med alle lejeaftaler
    @GetMapping("/dataregForsiden")
    public String index(Model model) {

        model.addAttribute("lejeaftaler", lejeaftaleService.fetchAllLejeaftale());
        return "home/dataregForsiden";
    }

    // Viser formular til oprettelse af en ny lejeaftale
    @GetMapping("/create")
    public String createLejeaftaleForm(Model model) {
        model.addAttribute("lejeaftale", new Lejeaftale());
        return "home/lejeaftale/createlejeaftale";
    }

    // Håndterer oprettelse af en ny lejeaftale
    @PostMapping("/create")
    public String createLejeaftale(@ModelAttribute Lejeaftale l) {
        lejeaftaleService.addLejeaftale(l);
        return "redirect:/lejeaftale/dataregForsiden";
    }

    // Sletter en lejeaftale baseret på lejeaftale_id
    @GetMapping("/delete/{lejeaftale_id}")
    public String deletelejeaftale(@PathVariable("lejeaftale_id") int lejeaftale_id ) {
        boolean deleted = lejeaftaleService.deleteLejeaftale(lejeaftale_id);
        if(deleted) {
            return "redirect:/lejeaftale/dataregForsiden";
        } else{
            return "redirect:/lejeaftale/dataregForsiden";
        }
    }

    // Viser formular til opdatering af en eksisterende lejeaftale
    @GetMapping("/update/{lejeaftale_id}")
    public String updateLejeaftaleForm(@PathVariable("lejeaftale_id") int lejeaftale_id, Model model) {
        Lejeaftale lejeaftale = lejeaftaleService.findLejeaftaleById(lejeaftale_id);

        model.addAttribute("lejeaftale",lejeaftale);
        return "home/lejeaftale/updateLejeaftale";
    }

    // Håndterer opdatering af en eksisterende lejeaftale
    @PostMapping("/update")
    public String updateLejeaftale(@ModelAttribute Lejeaftale lejeaftale){
        lejeaftaleService.updateLejeaftale(lejeaftale);
        return "redirect:/lejeaftale/dataregForsiden";
    }

    // Viser en enkelt lejeaftale baseret på lejeaftale_id
    @GetMapping("/view/{lejeaftale_id}")
    public String viewLejeaftale(@PathVariable("lejeaftale_id") int lejeaftale_id, Model model) {
        model.addAttribute("lejeaftale", lejeaftaleService.findLejeaftaleById(lejeaftale_id));
        return "home/lejeaftale/viewLejeaftale";
    }

}
