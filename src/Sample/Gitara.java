package Sample;

public class Gitara extends Instrument {
    private int liczba_strun;
    private int liczba_przystawek;
    private int liczba_progow;
    private String rodzaj;

    public Gitara(String nazwa, float cena, String producent, int liczba_strun, int liczba_przystawek, int liczba_progow, String rodzaj) {
        super(nazwa, cena, producent);
        this.liczba_strun = liczba_strun;
        this.liczba_przystawek = liczba_przystawek;
        this.liczba_progow = liczba_progow;
        this.rodzaj = rodzaj;
    }

    public Gitara(){
    }

    public int getLiczba_strun() {
        return liczba_strun;
    }

    public void setLiczba_strun(int liczba_strun) {
        this.liczba_strun = liczba_strun;
    }

    public int getLiczba_przystawek() {
        return liczba_przystawek;
    }

    public void setLiczba_przystawek(int liczba_przystawek) {
        this.liczba_przystawek = liczba_przystawek;
    }

    public int getLiczba_progow() {
        return liczba_progow;
    }

    public void setLiczba_progow(int liczba_progow) {
        this.liczba_progow = liczba_progow;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }
}