package com.example.bilabbromant2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;

@Entity
@Table(name = "tilbagelevering")
public class Tilbagelevering {
    @Id
    private int tilbagelevering_id;
    private int lejeaftale_id;
    private String stelnummer;
    private Date afleveringsdato;
    private String tilstandsrapport;
    private String status;

    public Tilbagelevering(int tilbagelevering_id, int lejeaftale_id, String stelnummer, Date afleveringsdato, String tilstandsrapport, String status) {
        this.tilbagelevering_id = tilbagelevering_id;
        this.lejeaftale_id = lejeaftale_id;
        this.stelnummer = stelnummer;
        this.afleveringsdato = afleveringsdato;
        this.tilstandsrapport = tilstandsrapport;
        this.status = status;
    }
    public Tilbagelevering(){}

    public int getTilbagelevering_id() {
        return tilbagelevering_id;
    }

    public void setTilbagelevering_id(int tilbagelevering_id) {
        this.tilbagelevering_id = tilbagelevering_id;
    }

    public int getLejeaftale_id() {
        return lejeaftale_id;
    }

    public void setLejeaftale_id(int lejeaftale_id) {
        this.lejeaftale_id = lejeaftale_id;
    }

    public String getStelnummer() {
        return stelnummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public Date getAfleveringsdato() {
        return afleveringsdato;
    }

    public void setAfleveringsdato(Date afleveringsdato) {
        this.afleveringsdato = afleveringsdato;
    }

    public String getTilstandsrapport() {
        return tilstandsrapport;
    }

    public void setTilstandsrapport(String tilstandsrapport) {
        this.tilstandsrapport = tilstandsrapport;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
