package entity;

public class Test {

    Integer idTest;
    String libelle;
    String description;
    Integer duree;
    Integer seuilHaut;
    Integer seuilBas;

    public Test() {
    }

    public Test(Integer idTest) {
        this.idTest = idTest;
    }

    public Test(Integer idTest, String libelle, String description, Integer duree, Integer seuilHaut, Integer seuilBas) {
        this.idTest = idTest;
        this.libelle = libelle;
        this.description = description;
        this.duree = duree;
        this.seuilHaut = seuilHaut;
        this.seuilBas = seuilBas;
    }


    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getSeuilHaut() {
        return seuilHaut;
    }

    public void setSeuilHaut(Integer seuilHaut) {
        this.seuilHaut = seuilHaut;
    }

    public Integer getSeuilBas() {
        return seuilBas;
    }

    public void setSeuilBas(Integer seuilBas) {
        this.seuilBas = seuilBas;
    }
}
