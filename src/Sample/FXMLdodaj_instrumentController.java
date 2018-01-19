package Sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Sample.Serializacja.*;

public class FXMLdodaj_instrumentController implements Initializable {


    //gitara
    private @FXML TextField nazwaGitara;
    private @FXML TextField producentGitara;
    private @FXML TextField cenaGitara;
    private @FXML TextField liczbastrunGitara;
    private @FXML TextField liczbaprzystawekGitara;
    private @FXML TextField liczbaprogowGitara;
    private @FXML ComboBox<String> rodzajGitara;
    private ObservableList<String> rodzajeGitar = FXCollections.observableArrayList("Klasyczna", "Basowa", "Elektryczna", "Akustyczna");

    //klawisze
    private @FXML TextField nazwaKlawisze;
    private @FXML TextField producentKlawisze;
    private @FXML TextField cenaKlawisze;
    private @FXML ComboBox<String> rodzajKlawisze;
    private ObservableList<String> rodzajeKlawiszy = FXCollections.observableArrayList("Młoteczkowe", "Elektroniczne");

    //perkusja
    private @FXML TextField nazwaPerkusja;
    private @FXML TextField producentPerkusja;
    private @FXML TextField cenaPerkusja;
    private @FXML ComboBox<String> rodzajPerkusja;
    private ObservableList<String> rodzajePerkusji = FXCollections.observableArrayList("\"Żywe\"", "Elektroniczne");

    //naglosnienie
    private @FXML TextField nazwaNaglosnienie;
    private @FXML TextField producentNaglosnienie;
    private @FXML TextField cenaNaglosnienie;
    private @FXML ComboBox<String> rodzajNaglosnienie;
    private ObservableList<String> rodzajeNaglosnienia = FXCollections.observableArrayList("Konsola", "Głośnik","Mikrofon");
    private @FXML ComboBox<String> klasaNaglosnienie;
    private ObservableList<String> klasyNaglosnienia = FXCollections.observableArrayList("Domowe", "Estradowe");


    //funkcje menu
    @FXML
    private void STARTAction(ActionEvent event) throws IOException {
        Main.zmianaSceny("start.fxml");
    }

    @FXML
    private void otworz_plikAction(ActionEvent event) throws IOException {
        try {
            Serializacja.WczytajAction();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void zapisz_plikAction(ActionEvent event) throws IOException {
        try {
            Serializacja.ZapiszAction();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void zamknijAction(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @FXML
    private void dodaj_instrumentyAction(ActionEvent event) throws IOException {
        Main.zmianaSceny("dodaj_instrument.fxml");
    }

    @FXML
    private void wyswietl_instrumentyAction(ActionEvent event) throws IOException {
        Main.zmianaSceny("wyswietl_instrument.fxml");
    }

    @FXML
    private void dodaj_uslugiAction(ActionEvent event) throws IOException {
        Main.zmianaSceny("dodaj_usluge.fxml");
    }

    @FXML
    private void wyswietl_uslugiAction(ActionEvent event) throws IOException {
        Main.zmianaSceny("wyswietl_uslugi.fxml");
    }

    @FXML
    private void dodajGitaraAction (ActionEvent event) throws IOException {
        listaGitar.add(new Gitara(
                nazwaGitara.getText(),
                Float.valueOf(cenaGitara.getText()),
                producentGitara.getText(),
                Integer.valueOf(liczbastrunGitara.getText()),
                Integer.valueOf(liczbaprzystawekGitara.getText()),
                Integer.valueOf(liczbaprogowGitara.getText()),
                rodzajGitara.getValue()));
    }

    @FXML
    private void omnieAction(ActionEvent event) throws IOException {
        onas.messagebox();
    }


    @FXML
    private void dodajKlawiszeAction (ActionEvent event) throws IOException{
        listaKlawiszy.add(new Klawisze(
                nazwaKlawisze.getText(),
                Float.valueOf(cenaKlawisze.getText()),
                producentKlawisze.getText(),
                rodzajKlawisze.getValue()));
    }


    @FXML
    private void dodajPerkusjaAction (ActionEvent event) throws IOException {
        listaPerkusji.add(new Perkusja(
                nazwaPerkusja.getText(),
                Float.valueOf(cenaPerkusja.getText()),
                producentPerkusja.getText(),
                rodzajPerkusja.getValue()));
    }


    @FXML
    private void dodajNaglosnienieAction (ActionEvent event) throws IOException{
        listaNaglosnienie.add(new Naglosnienie(
                rodzajNaglosnienie.getValue(),
                nazwaNaglosnienie.getText(),
                Float.valueOf(cenaNaglosnienie.getText()),
                producentNaglosnienie.getText(),
                klasaNaglosnienie.getValue()));
    }

    //inicjalizacja ComboBoxa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rodzajGitara.setItems(rodzajeGitar);
        rodzajKlawisze.setItems(rodzajeKlawiszy);
        rodzajPerkusja.setItems(rodzajePerkusji);
        rodzajNaglosnienie.setItems(rodzajeNaglosnienia);
        klasaNaglosnienie.setItems(klasyNaglosnienia);
    }
}
