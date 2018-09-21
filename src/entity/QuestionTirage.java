package entity;

import Dal.DalQuestion;

import java.sql.SQLException;

public class QuestionTirage {

    Boolean estMarquee;
    Integer numOrdre;
    Integer idEpreuve;
    Integer idQuestion;
    Question question;

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

    public Question getQuestion() {
        if(this.question == null){
            try {
                this.question = DalQuestion.getQuestion(this.idQuestion);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return this.question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
