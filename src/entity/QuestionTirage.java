package entity;

import java.util.ArrayList;

public class QuestionTirage {

    Boolean estMarquee;
    Integer numOrdre;
    Integer idEpreuve;
    Integer idQuestion;

    public QuestionTirage() {
    }

    public Boolean getEstMarquee() {
        return estMarquee;
    }

    public void setEstMarquee(Boolean estMarquee) {
        this.estMarquee = estMarquee;
    }

    public Integer getNumOrdre() {
        return numOrdre;
    }

    public void setNumOrdre(Integer numOrdre) {
        this.numOrdre = numOrdre;
    }

    public Integer getIdEpreuve() {
        return idEpreuve;
    }

    public void setIdEpreuve(Integer idEpreuve) {
        this.idEpreuve = idEpreuve;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }
}
