package com.example.bilabbromant2.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StatistikRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    //finder hvor mange biler der er udlejde

    public int findAntalLejedeBiler() {
        String sql = "SELECT COUNT(*) FROM Lejeaftale WHERE CURDATE() BETWEEN start_dato AND slut_dato";
        return jdbcTemplate.queryForObject(sql, Integer.class);//kan godt bruge int istedet for wrapperklasser men den skal ikke retuner null
    }
// viser sammlet pris på lejedebiler
    public double findSamletPrisForLejedeBiler() {
        String sql = "SELECT SUM(pris) FROM Lejeaftale WHERE CURDATE() BETWEEN start_dato AND slut_dato";
        return jdbcTemplate.queryForObject(sql, Double.class);//kan godt brug double som primativ typr
    }
}

