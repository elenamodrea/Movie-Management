package Model;

import javax.persistence.*;

@Entity
@Table(name="film")
public class Film {
    @Id
    @Column(name="idFilm", nullable = false,unique = true)
    private String idFilm;
    @Column(name="nume", nullable = false)
    private String nume;
    @Column(name="tip", nullable = false)
    private String tip;
    @Column(name="anRealizare", nullable = false)
    private String anRealizare;
    @Column(name="categorie", nullable = false)
    private String categorie;

    public Film() {
    }

    public Film(String idFilm, String nume, String tip, String anRealizare, String categorie) {
        this.idFilm = idFilm;
        this.nume = nume;
        this.tip = tip;
        this.anRealizare = anRealizare;
        this.categorie = categorie;
    }

    public String getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getAnRealizare() {
        return anRealizare;
    }

    public void setAnRealizare(String anRealizare) {
        this.anRealizare = anRealizare;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
