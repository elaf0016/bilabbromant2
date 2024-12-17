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

    public int hentAntalLejedeBiler() {
        return statistikRepository.findAntalLejedeBiler();
    }

    public double hentSamletPrisForLejedeBiler() {
        return statistikRepository.findSamletPrisForLejedeBiler();
    }


    @Autowired
    BilRepository bilRepository;

    public List<Bil> hentUdlejedeBiler() {
        return bilRepository.findUdlejedeBiler();
    }
}
