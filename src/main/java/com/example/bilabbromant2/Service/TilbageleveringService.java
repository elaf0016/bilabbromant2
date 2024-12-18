package com.example.bilabbromant2.Service;
import com.example.bilabbromant2.Model.Tilbagelevering;
import com.example.bilabbromant2.Repository.TilbageleveringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TilbageleveringService {
    @Autowired
    TilbageleveringRepository tilbageleveringRepository;

    public List<Tilbagelevering> fetchAllTilbagelevering(){
        return tilbageleveringRepository.fetchAllTilbagelevering();
    }

    public void addTilbagelevering(Tilbagelevering tilbagelevering){
        tilbageleveringRepository.addTilbagelevering(tilbagelevering);
    }
}
