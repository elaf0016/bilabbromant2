package com.example.bilabbromant2.Service;

import com.example.bilabbromant2.Model.FejlMangler;
import com.example.bilabbromant2.Repository.FejelManglerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FejlManglerService {
    @Autowired
    FejelManglerRepository fejelManglerRepository;
    public List<FejlMangler> fetchAllFejlMangler(){
        return fejelManglerRepository.fetchAllFejlMangler();
    }
    public void addFejlMangler(FejlMangler fejlMangler){
        fejelManglerRepository.addFejlMangler(fejlMangler);
    }

}
