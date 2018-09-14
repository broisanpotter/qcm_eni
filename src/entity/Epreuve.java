package entity;

import java.util.ArrayList;
import java.util.Date;

public class Epreuve {

    Integer idEpreuve;
    Date dateDebutValidite;
    Date dateFinValidite;
    Integer tempsEcoule;
    String etat;
    Double note_obtenue;
    String niveau_obtenu;

    Test test;
    Utilisateur utilisateur;

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

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public ArrayList<QuestionTirage> getQuestionsTirage() {
        return questionsTirage;
    }

    public void setQuestionsTirage(ArrayList<QuestionTirage> questionsTirage) {
        this.questionsTirage = questionsTirage;
    }

    ArrayList<QuestionTirage> questionsTirage;

}
