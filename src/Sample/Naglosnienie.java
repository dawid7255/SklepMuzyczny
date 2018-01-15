package Sample;

public class Naglosnienie extends Instrument {
    private String rodzaj;
    private String klasa;

    public Naglosnienie(String rodzaj, String nazwa, float cena, String producent, String klasa) {

        super(nazwa, cena, producent);
        this.rodzaj = rodzaj;
        this.klasa = klasa;
    }

    public Naglosnienie(){

    }

    public String getRodzaj() {
        return rodzaj;
    }
    public void setRodzaj(String klasa) {
        this.rodzaj = klasa;
    }

    public String getKlasa() {
        return klasa;
    }
    public void setKlasa(String klasa) {
        this.klasa = klasa;
    }
}
