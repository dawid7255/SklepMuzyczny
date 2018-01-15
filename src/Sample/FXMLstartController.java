package Sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class FXMLstartController implements Initializable {

    @FXML
    private void STARTAction(ActionEvent event) throws IOException {
        Main.zmianaSceny("start.fxml");
    }

    @FXML
    private void otworz_plikAction(ActionEvent event) throws IOException {
        /*try {
            Serializacja.WczytajAction();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @FXML
    private void zapisz_plikAction(ActionEvent event) throws IOException {
        /*try {
            Serializacja.ZapiszAction();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {}
}
