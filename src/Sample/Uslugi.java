package Sample;

public class Uslugi extends Produkt{
    private String czas_wykonania;
    private String rodzaj;


    public Uslugi(String nazwa, float cena, String czas_wykonania, String rodzaj) {
        super(nazwa, cena);
        this.czas_wykonania = czas_wykonania;
        this.rodzaj = rodzaj;
    }

    public Uslugi(){

    }

    public String getCzas_wykonania() {
        return czas_wykonania;
    }
    public void setCzas_wykonania(String czas_wykonania) {
        this.czas_wykonania = czas_wykonania;
    }

    public String getRodzaj() {
        return rodzaj;
    }
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
