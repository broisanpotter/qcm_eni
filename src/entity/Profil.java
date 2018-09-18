package entity;

public class Profil {

    int codeProfil;
    String libelle;

    public Profil() {
    }

    public Profil(int codeProfil, String libelle) {
        this.codeProfil = codeProfil;
        this.libelle = libelle;
    }

    public int getCodeProfil() {
        return codeProfil;
    }

    public void setCodeProfil(int codeProfil) {
        this.codeProfil = codeProfil;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
