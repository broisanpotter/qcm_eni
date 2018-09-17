package entity;

import java.util.ArrayList;

public class Theme {

    Integer idTheme;
    String libelle;

    ArrayList<SectionTest> sectionsTest;
    ArrayList<Question> questions;

    public Theme() {
    }

    public Theme(Integer idTheme, String libelle) {
        this.idTheme = idTheme;
        this.libelle = libelle;
    }

    public Integer getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(Integer idTheme) {
        this.idTheme = idTheme;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public ArrayList<SectionTest> getSectionsTest() {
        return sectionsTest;
    }

    public void setSectionsTest(ArrayList<SectionTest> sectionsTest) {
        this.sectionsTest = sectionsTest;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }
}
