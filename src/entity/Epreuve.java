package entity;

import java.sql.Date;

public class Epreuve {

    Integer idEpreuve;
    Date dateDebutValidite;
    Date dateFinValidite;
    Integer tempsEcoule;
    String etat;
    Double note_obtenue;
    String niveau_obtenu;

    Integer idTest;
    Integer idUtilisateur;

    public Epreuve(Integer idEpreuve, Date dateDebutValidite, Date dateFinValidite, Integer tempsEcoule, String etat, Double note_obtenue, String niveau_obtenu) {
        this.idEpreuve = idEpreuve;
        this.dateDebutValidite = dateDebutValidite;
        this.dateFinValidite = dateFinValidite;
        this.tempsEcoule = tempsEcoule;
        this.etat = etat;
        this.note_obtenue = note_obtenue;
        this.niveau_obtenu = niveau_obtenu;
    }

    public Epreuve() {
    }

    public Integer getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(Integer idEpreuve) {
        this.idEpreuve = idEpreuve;
    }

    public Date getDateDebutValidite() {
        return dateDebutValidite;
    }

    public void setDateDebutValidite(Date dateDebutValidite) {
        this.dateDebutValidite = dateDebutValidite;
    }

    public Date getDateFinValidite() {
        return dateFinValidite;
    }

    public void setDateFinValidite(Date dateFinValidite) {
        this.dateFinValidite = dateFinValidite;
    }

    public Integer getTempsEcoule() {
        return tempsEcoule;
    }

    public void setTempsEcoule(Integer tempsEcoule) {
        this.tempsEcoule = tempsEcoule;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Double getNote_obtenue() {
        return note_obtenue;
    }

    public void setNote_obtenue(Double note_obtenue) {
        this.note_obtenue = note_obtenue;
    }

    public String getNiveau_obtenu() {
        return niveau_obtenu;
    }

    public void setNiveau_obtenu(String niveau_obtenu) {
        this.niveau_obtenu = niveau_obtenu;
    }

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
}
