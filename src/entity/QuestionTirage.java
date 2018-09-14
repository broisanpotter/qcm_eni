package entity;

import java.util.ArrayList;

public class QuestionTirage {

    String estMarquee;
    Integer numOrdre;

    Epreuve epreuve;
    Question question;
    ArrayList<ReponseTirage> reponsesTirage;

    public QuestionTirage(String estMarquee, Integer numOrdre) {
        this.estMarquee = estMarquee;
        this.numOrdre = numOrdre;
    }

    public String getEstMarquee() {
        return estMarquee;
    }

    public void setEstMarquee(String estMarquee) {
        this.estMarquee = estMarquee;
    }

    public Integer getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Integer numOrdre) {
        this.numOrdre = numOrdre;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ArrayList<ReponseTirage> getReponsesTirage() {
        return reponsesTirage;
    }

    public void setReponsesTirage(ArrayList<ReponseTirage> reponsesTirage) {
        this.reponsesTirage = reponsesTirage;
    }
}
