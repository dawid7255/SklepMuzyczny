package Sample;

public class Perkusja extends Instrument {
    private String rodzaj;

    public Perkusja(String nazwa, float cena, String producent, String rodzaj) {
        super(nazwa, cena, producent);
        this.rodzaj = rodzaj;
    }

    public Perkusja(){
    }

    public String getRodzaj() {
        return rodzaj;
    }
    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}
