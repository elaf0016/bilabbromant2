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
    // Henter alle biler fra databasen og returnerer dem som en liste af Bil-objekter
    public List<Bil> fetchAllBil(){
        String sql="SELECT * FROM bil";
        RowMapper <Bil> rowMapper= new BeanPropertyRowMapper<>(Bil.class);
        return template.query(sql,rowMapper);
    }
    // Tilføjer en bil til databasen
    public void addBil(Bil bil){

        String sql = "INSERT INTO bil(stelnummer,mærke,model,brandstof,odometer,bilStatus,pris)VALUES(?,?,?,?,?,?,?)";
        template.update(sql,bil.getStelnummer(),bil.getMærke(),bil.getModel(),bil.getBrandstof(),bil.getOdometer(),bil.getBilStatus(),bil.getPris());
    }
    // Henter en bil fra databasen med et specifikt stelnummer
    public Bil findBilByStelNummer(String stelnummer) {
        String sql = "SELECT * FROM bil WHERE stelnummer=?";

        RowMapper<Bil> rowMapper = new BeanPropertyRowMapper<>(Bil.class);
        Bil b =template.queryForObject(sql,rowMapper,stelnummer);
        return b;
    }

    // Sletter en bil fra databasen med et specifikt stelnummer
    public Boolean deleteBil (String stelnummer){
        String sql = "DELETE FROM bil WHERE stelnummer=?";
        return template.update(sql, stelnummer) > 0;

    }
    // Opdaterer en bil i databasen undtagen stelnummer
    public void updateBil (Bil b){
        String sql = "UPDATE bil SET mærke=?,model=?,brandstof=?,odometer=?,bilStatus=?,pris=? WHERE stelnummer=? ";
        template.update(sql, b.getMærke(), b.getModel(), b.getBrandstof(), b.getOdometer(),b.getBilStatus(),b.getPris(), b.getStelnummer());
    }
    // Opdaterer kun prisen på en bil i databasen baseret på stelnummer

    public void updateBilPris(String stelnummer, Double pris) {
        String sql = "UPDATE bil SET pris = ? WHERE stelnummer = ?";
        template.update(sql, pris, stelnummer);
    }
    /**
     * Henter alle biler, der er udlejede lige nu, ved at tjekke i lejeaftale-tabellen.
     * SQL-queryen benytter en INNER JOIN mellem bil-tabellen og lejeaftale-tabellen
     * for at matche stelnummeret og filtrerer på, om nuværende dato er mellem start_dato og slut_dato.
     *
     * @return En liste af udlejede Bil-objekter
     */
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

