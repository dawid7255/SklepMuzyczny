package Sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static Sample.Serializacja.listaUslug;

public class FXMLwyswietl_uslugiController implements Initializable {

    private static ObservableList<Uslugi> wybranyrekord;
    private ObservableList<Uslugi> wszystko;
    private int NumerRekordu;

    // edycja usługa
    @FXML private TextArea nazwaUsluga;
    @FXML private TextField czastrwaniaUsluga;
    @FXML private TextField cenaUsluga;
    @FXML private ComboBox<String> rodzajUsluga;
    private ObservableList<String> rodzajeUslug = FXCollections.observableArrayList("Wypożyczenie sprzętu", "Obsługa sprzętu","Usługi serwisowe", "Lekcja gry na gitarze");
    // tabela usług
    @FXML private TableView tabelaUslug;
    @FXML private TableColumn kolumnaUslugaNazwa;
    @FXML private TableColumn kolumnaUslugaCzastrwania;
    @FXML private TableColumn kolumnaUslugaCena;
    @FXML private TableColumn kolumnaUslugaRodzaj;

    public static ObservableList<Uslugi> getWybranyrekord() {
        return wybranyrekord;
    }

    public static void setWybranyrekord(ObservableList<Uslugi> wybranyrekord) {
        FXMLwyswietl_uslugiController.wybranyrekord = wybranyrekord;
    }

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
    private void edytujAction(ActionEvent event) throws IOException {
        NumerRekordu = tabelaUslug.getSelectionModel().getSelectedIndex();
        setWybranyrekord(wybranyrekord);
        czastrwaniaUsluga.setText(listaUslug.get(NumerRekordu).getCzas_wykonania());
        cenaUsluga.setText(String.valueOf(listaUslug.get(NumerRekordu).getCena()));
        nazwaUsluga.setText(listaUslug.get(NumerRekordu).getNazwa());
    }

    @FXML
    private void usunAction(ActionEvent event) throws IOException {
        wszystko = tabelaUslug.getItems();
        wybranyrekord = tabelaUslug.getSelectionModel().getSelectedItems();
        wybranyrekord.forEach(wszystko::remove);
    }

    @FXML
    private void omnieAction(ActionEvent event) throws IOException {
        onas.messagebox();
    }

    @FXML
    private void zatwierdzEdycjeUslugaAction(ActionEvent event) throws IOException {
        listaUslug.get(NumerRekordu).setNazwa(nazwaUsluga.getText());
        listaUslug.get(NumerRekordu).setCzas_wykonania(czastrwaniaUsluga.getText());
        listaUslug.get(NumerRekordu).setCena(Float.valueOf(cenaUsluga.getText()));
        listaUslug.get(NumerRekordu).setRodzaj(rodzajUsluga.getValue());
        //odswiezanie tablicy
        tabelaUslug.getColumns().clear();
        tabelaUslug.getColumns().addAll(kolumnaUslugaRodzaj,kolumnaUslugaCzastrwania,kolumnaUslugaCena,kolumnaUslugaNazwa);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rodzajUsluga.setItems(rodzajeUslug);

        tabelaUslug.itemsProperty().setValue(listaUslug);
        kolumnaUslugaRodzaj.setCellValueFactory(new PropertyValueFactory<Uslugi, String>("rodzaj"));
        kolumnaUslugaCzastrwania.setCellValueFactory(new PropertyValueFactory<Uslugi, String>("czas_wykonania"));
        kolumnaUslugaCena.setCellValueFactory(new PropertyValueFactory<Uslugi, Float>("cena"));
        kolumnaUslugaNazwa.setCellValueFactory(new PropertyValueFactory<Uslugi, String>("nazwa"));
    }
}
