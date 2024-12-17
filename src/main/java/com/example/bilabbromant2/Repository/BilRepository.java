package com.example.bilabbromant2.Repository;
import com.example.bilabbromant2.Model.Bil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BilRepository {
    @Autowired
    JdbcTemplate template;

    public List<Bil> fetchAllBil(){
        String sql="SELECT * FROM bil";
        RowMapper <Bil> rowMapper= new BeanPropertyRowMapper<>(Bil.class);
        return template.query(sql,rowMapper);
    }
    public void addBil(Bil bil){

        String sql = "INSERT INTO bil(stelnummer,mærke,model,brandstof,odometer,bilStatus,pris)VALUES(?,?,?,?,?,?,?)";
        template.update(sql,bil.getStelnummer(),bil.getMærke(),bil.getModel(),bil.getBrandstof(),bil.getOdometer(),bil.getBilStatus(),bil.getPris());
    }
    public Bil findBilByStelNummer(String stelnummer) {
        String sql = "SELECT * FROM bil WHERE stelnummer=?";

        RowMapper<Bil> rowMapper = new BeanPropertyRowMapper<>(Bil.class);
        Bil b =template.queryForObject(sql,rowMapper,stelnummer);
        return b;


    }


    public Boolean deleteBil (String stelnummer){
        String sql = "DELETE FROM bil WHERE stelnummer=?";
        return template.update(sql, stelnummer) > 0;

    }
    public void updateBil (Bil b){
        String sql = "UPDATE bil SET mærke=?,model=?,brandstof=?,odometer=?,bilStatus=?,pris=? WHERE stelnummer=? ";
        template.update(sql, b.getMærke(), b.getModel(), b.getBrandstof(), b.getOdometer(),b.getBilStatus(),b.getPris(), b.getStelnummer());
    }
    public void updateBilPris(String stelnummer, Double pris) {
        String sql = "UPDATE bil SET pris = ? WHERE stelnummer = ?";
        template.update(sql, pris, stelnummer);
    }

    //tilføj af se det udlejede biler


    public List<Bil> findUdlejedeBiler() {
        String sql = """
        SELECT b.stelnummer, b.mærke, b.model, b.brandstof, b.odometer, b.bilStatus,b.pris
        FROM bil b
        INNER JOIN lejeaftale l ON b.Stelnummer = l.Stelnummer
        WHERE CURDATE() BETWEEN l.start_dato AND l.slut_dato
    """;


        return template.query(sql, (databaserække, rækkenummer) -> new Bil(
                databaserække.getString("stelnummer"),
                databaserække.getString("mærke"),
                databaserække.getString("model"),
                databaserække.getString("brandstof"),
                databaserække.getInt("odometer"),
                databaserække.getString("bilStatus"),
                databaserække.getDouble("pris")
        ));
    }

}

