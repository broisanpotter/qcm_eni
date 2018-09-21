package entity;

public class Proposition {

    Integer idProposition;
    String enonce;
    Boolean estBonne;
    Integer idQuestion;

    public Proposition() {
    }

    public Integer getIdProposition() {
        return idProposition;
    }

    public void setIdProposition(Integer idProposition) {
        this.idProposition = idProposition;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public Boolean getEstBonne() {
        return estBonne;
    }

    public void setEstBonne(Boolean estBonne) {
        this.estBonne = estBonne;
    }

    public Integer getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(Integer idQuestion) {
        this.idQuestion = idQuestion;
    }
}
