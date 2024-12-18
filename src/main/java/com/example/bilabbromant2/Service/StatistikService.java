package com.example.bilabbromant2.Service;
import com.example.bilabbromant2.Model.Bil;
import com.example.bilabbromant2.Repository.BilRepository;
import com.example.bilabbromant2.Repository.StatistikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StatistikService {

    @Autowired
    StatistikRepository statistikRepository;

    // Henter antallet af lejede biler
    public int hentAntalLejedeBiler() {
        return statistikRepository.findAntalLejedeBiler();
    }

    // Henter den samlede pris for lejede biler
    public double hentSamletPrisForLejedeBiler() {
        return statistikRepository.findSamletPrisForLejedeBiler();
    }

    @Autowired
    BilRepository bilRepository;

    // Henter en liste over udlejede biler
    public List<Bil> hentUdlejedeBiler() {
        return bilRepository.findUdlejedeBiler();
    }
}
