package Sample;


public class Klawisze extends Instrument {
    private String rodzaj;
    public Klawisze(String nazwa, float cena, String producent, String rodzaj) {

        super(nazwa, cena, producent);
        this.rodzaj = rodzaj;
    }

    public Klawisze(){

    }

    public String getRodzaj() {
        return rodzaj;
    }
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
