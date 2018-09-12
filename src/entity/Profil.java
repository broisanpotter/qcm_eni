package entity;

public class Profil {

    Integer codeProfil;
    String libelle;

    public Profil() {
    }

    public Profil(Integer codeProfil, String libelle) {
        this.codeProfil = codeProfil;
        this.libelle = libelle;
    }

    public Integer getCodeProfil() {
        return codeProfil;
    }

    public void setCodeProfil(Integer codeProfil) {
        this.codeProfil = codeProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Profil{" +
                "codeProfil=" + codeProfil +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
