package entity;

import Dal.DalProposition;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;

public class Question {

    int idQuestion;
    String enonce;
    String media;
    int points;
    int  idTheme;
    ArrayList<Proposition> propositionsListe;


    public Question() {

    }

    public Question(int idQuestion, String enonce, int points, int idTheme) {
        this.idQuestion = idQuestion;
        this.enonce = enonce;
        this.points = points;
        this.idTheme = idTheme;
    }

    public Question(int idQuestion, String enonce, String media, int points, int idTheme) {
        this.idQuestion = idQuestion;
        this.enonce = enonce;
        this.media = media;
        this.points = points;
        this.idTheme = idTheme;
    }

    @Override
    public String toString() {
        return "Question{" +
                "idQuestion=" + idQuestion +
                ", enonce='" + enonce + '\'' +
                ", media='" + media + '\'' +
                ", points=" + points +
                ", idTheme=" + idTheme +
                '}';
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public ArrayList<Proposition> getPropositionsListe() {
        if(this.propositionsListe == null){
            try {
                this.propositionsListe = DalProposition.promotionsByQuestion(this.getIdQuestion());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return propositionsListe;
    }

    public void setPropositionsListe(ArrayList<Proposition> propositionsListe) {
        this.propositionsListe = propositionsListe;
    }
}
