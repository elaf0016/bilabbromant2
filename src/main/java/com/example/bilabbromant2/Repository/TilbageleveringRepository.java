package com.example.bilabbromant2.Repository;
import com.example.bilabbromant2.Model.Tilbagelevering;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class TilbageleveringRepository {
    @Autowired
    JdbcTemplate template;
    // Henter alle tilbageleveringer fra databasen
    public List<Tilbagelevering>fetchAllTilbagelevering(){
        String sql="SELECT * FROM tilbagelevering";
        RowMapper<Tilbagelevering> rowMapper= new BeanPropertyRowMapper<>(Tilbagelevering.class);
        return template.query(sql,rowMapper);
    }
    // Tilføjer en ny tilbagelevering til databasen
    public void addTilbagelevering(Tilbagelevering tilbagelevering){
        String sql ="INSERT INTO tilbagelevering(tilbagelevering_id,lejeaftale_id,stelnummer,afleveringsdato,tilstandsrapport,status) VALUES (?,?,?,?,?,?)";
        template.update(sql,tilbagelevering.getTilbagelevering_id(),tilbagelevering.getLejeaftale_id(),tilbagelevering.getStelnummer(),tilbagelevering.getAfleveringsdato(),tilbagelevering.getTilstandsrapport(),tilbagelevering.getStatus());

    }

}
