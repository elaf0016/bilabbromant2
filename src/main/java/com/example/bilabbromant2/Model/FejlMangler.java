package com.example.bilabbromant2.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="fejlMangler")
public class FejlMangler {
    @Id
    private int fejl_id;
    private int tilbagelevering_id;
    private String beskrivelse;
    private double pris;

    public FejlMangler(){}

    public FejlMangler(int fejl_id, int tilbagelevering_id, String beskrivelse, double pris) {
        this.fejl_id = fejl_id;
        this.tilbagelevering_id = tilbagelevering_id;
        this.beskrivelse = beskrivelse;
        this.pris = pris;

    }

    public int getFejl_id() {
        return fejl_id;
    }

    public void setFejl_id(int fejl_id) {
        this.fejl_id = fejl_id;
    }

    public int getTilbagelevering_id() {
        return tilbagelevering_id;
    }

    public void setTilbagelevering_id(int tilbagelevering_id) {
        this.tilbagelevering_id = tilbagelevering_id;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }
}
