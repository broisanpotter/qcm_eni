package entity;

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
    ArrayList<QuestionTirage> questionsTirage;

}
