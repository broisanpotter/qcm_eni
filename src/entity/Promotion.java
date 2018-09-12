package entity;

public class Promotion {

    Integer codePromo;
    String libelle;

    public Promotion() {
    }

    public Promotion(Integer codePromo, String libelle) {
        this.codePromo = codePromo;
        this.libelle = libelle;
    }

    public Integer getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(Integer codePromo) {
        this.codePromo = codePromo;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "codePromo=" + codePromo +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
