package com.example.bilabbromant2.Repository;
import com.example.bilabbromant2.Model.FejlMangler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class FejelManglerRepository {
    @Autowired
    JdbcTemplate template;
//henter alle fejl og mangler fra databasen og retunerer dem som en list
    public List<FejlMangler> fetchAllFejlMangler(){
        String sql="SELECT * FROM fejlMangler";
        RowMapper<FejlMangler> rowMapper= new BeanPropertyRowMapper<>(FejlMangler.class);
        return template.query(sql,rowMapper);
    }
    // Tilføjer en fejl eller mangel til databasen
    public void addFejlMangler(FejlMangler fejlMangler){
        String sql ="INSERT INTO fejlMangler(fejl_id,tilbagelevering_id,beskrivelse,pris) VALUES (?,?,?,?)";
        template.update(sql,fejlMangler.getFejl_id(),fejlMangler.getTilbagelevering_id(),fejlMangler.getBeskrivelse(),fejlMangler.getPris());

    }


}
