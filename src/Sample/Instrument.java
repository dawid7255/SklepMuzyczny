package Sample;

public class Instrument extends Produkt {
    private String producent;


    public Instrument(String nazwa, float cena, String producent) {
        super(nazwa, cena);
        this.producent = producent;
    }

    public Instrument() {
    }

    public String getProducent() {
        return producent;
    }

    public void setProducent(String producent) {
        this.producent = producent;
    }
}