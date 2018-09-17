package entity;

public class SectionTest {

    Integer idSectionTest;
    Integer nbQuestionsATirer;

    Test test;
    Theme theme;

    public SectionTest() {
    }

    public SectionTest(Integer idSectionTest, Integer nbQuestionsATirer) {
        this.idSectionTest = idSectionTest;
        this.nbQuestionsATirer = nbQuestionsATirer;
    }

    public Integer getNbQuestionsATirer() {
        return nbQuestionsATirer;
    }

    public void setNbQuestionsATirer(Integer nbQuestionsATirer) {
        this.nbQuestionsATirer = nbQuestionsATirer;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }
}
