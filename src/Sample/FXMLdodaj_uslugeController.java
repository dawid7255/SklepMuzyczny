package Sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static Sample.Serializacja.*;
//import static Sample.Serializacja.listaUslug;

public class FXMLdodaj_uslugeController implements Initializable {

    //gitara
    private @FXML TextArea nazwaUsluga;
    private @FXML TextField czastrwaniaUsluga;
    private @FXML TextField cenaUsluga;
    private @FXML ComboBox<String> rodzajUsluga;
    private ObservableList<String> rodzajeUslug = FXCollections.observableArrayList("Wypożyczenie sprzętu", "Obsługa sprzętu","Usługi serwisowe", "Lekcja gry na gitarze");

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
    private void omnieAction(ActionEvent event) throws IOException {
        onas.messagebox();
    }

    @FXML
    private void dodajUslugaAction (ActionEvent event) throws IOException{
        listaUslug.add(new Uslugi(
                nazwaUsluga.getText(),
                Float.valueOf(cenaUsluga.getText()),
                czastrwaniaUsluga.getText(),
                rodzajUsluga.getValue()));
    }

    //inicjalizacja ComboBoxa
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rodzajUsluga.setItems(rodzajeUslug);
    }
}
