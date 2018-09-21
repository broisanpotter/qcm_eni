package entity;

public class Promotion {

    String codePromo;
    String libelle;

    public Promotion() {
    }

    public Promotion(String codePromo, String libelle) {
        this.codePromo = codePromo;
        this.libelle = libelle;
    }

    public String getCodePromo() {
        return codePromo;
    }

    public void setCodePromo(String codePromo) {
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
