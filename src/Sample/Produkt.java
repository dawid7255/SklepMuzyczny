package Sample;

public class Produkt {
    private String nazwa;
    private float cena;

    public Produkt(String nazwa, float cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Produkt() {
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getCena() {
        return cena;
    }

    public void setCena(float cena) {
        this.cena = cena;
    }
}
