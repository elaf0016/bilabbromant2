package com.example.bilabbromant2.Controller;
import com.example.bilabbromant2.Model.Tilbagelevering;
import com.example.bilabbromant2.Service.FejlManglerService;
import com.example.bilabbromant2.Service.TilbageleveringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class TilbageleveringController {
    @Autowired
    TilbageleveringService tilbageleveringService;
    @Autowired
    FejlManglerService fejlManglerService;

    // Viser skade udbedring siden med alle tilbageleveringer og fejl/mangler
    @GetMapping("/skadeUbedring")
    public String indexTilbagelevering(Model model) {
        model.addAttribute("tilbageleveringer", tilbageleveringService.fetchAllTilbagelevering());
        model.addAttribute("fejlMangler", fejlManglerService.fetchAllFejlMangler());
        return "home/skadeUbedring";
    }

    // Viser formular til oprettelse af en ny tilbagelevering
    @GetMapping("/tilbagelevering/create")
    public String createTilbagelevering(Model model) {
        model.addAttribute("tilbagelevering", new Tilbagelevering());
        return "home/tilbagelevering/createTilbagelevering";
    }

    // Håndterer oprettelse af en ny tilbagelevering
    @PostMapping("/tilbagelevering/create")
    public String createTilbagelevering(@ModelAttribute Tilbagelevering t) {
        tilbageleveringService.addTilbagelevering(t);
        return "redirect:/skadeUbedring";
    }

    }





