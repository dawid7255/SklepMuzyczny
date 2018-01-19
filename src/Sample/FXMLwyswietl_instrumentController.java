package Sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static Sample.Serializacja.*;

public class FXMLwyswietl_instrumentController implements Initializable {

    private static ObservableList<Gitara> wybranyrekordGitara, wszystkoGitara;
    private static ObservableList<Klawisze> wybranyrekordKlawisze, wszystkoKlawisze;
    private static ObservableList<Perkusja> wybranyrekordPerkusja, wszystkoPerkusja;
    private static ObservableList<Naglosnienie> wybranyrekordNaglosnienie, wszystkoNaglosnienie;
    private int NumerRekorduGitara,NumerRekorduKlawisze, NumerRekorduPerkusja, NumerRekorduNaglosnienie;

    // edycja gitara
    @FXML private TextField nazwaGitara;
    @FXML private TextField producentGitara;
    @FXML private TextField cenaGitara;
    @FXML private TextField liczbastrunGitara;
    @FXML private TextField liczbaprzystawekGitara;
    @FXML private TextField liczbaprogowGitara;
    @FXML private ComboBox<String> rodzajGitara;
    private ObservableList<String> rodzajeGitar = FXCollections.observableArrayList("Klasyczna", "Basowa", "Elektryczna", "Akustyczna");
    // tabela gitar
    @FXML private TableView tabelaGitar;
    @FXML private TableColumn kolumnaGitaraNazwa;
    @FXML private TableColumn kolumnaGitaraProducent;
    @FXML private TableColumn kolumnaGitaraCena;
    @FXML private TableColumn kolumnaGitaraLiczbaStrun;
    @FXML private TableColumn kolumnaGitaraLiczbaPrzystawek;
    @FXML private TableColumn kolumnaGitaraLiczbaProgow;
    @FXML private TableColumn kolumnaGitaraRodzaj;

    // edycja klawiszy
    private @FXML TextField nazwaKlawisze;
    private @FXML TextField producentKlawisze;
    private @FXML TextField cenaKlawisze;
    private @FXML ComboBox<String> rodzajKlawisze;
    private ObservableList<String> rodzajeKlawiszy = FXCollections.observableArrayList("Młoteczkowe", "Elektroniczne");
    // tabela klawiszy
    private @FXML TableView tabelaKlawisze;
    private @FXML TableColumn kolumnaKlawiszeNazwa;
    private @FXML TableColumn kolumnaKlawiszeProducent;
    private @FXML TableColumn kolumnaKlawiszeCena;
    private @FXML TableColumn kolumnaKlawiszeRodzaj;

    // edycja perkusja
    private @FXML TextField nazwaPerkusja;
    private @FXML TextField producentPerkusja;
    private @FXML TextField cenaPerkusja;
    private @FXML ComboBox<String> rodzajPerkusja;
    private ObservableList<String> rodzajePerkusji = FXCollections.observableArrayList("\"Żywe\"", "Elektroniczne");
    // tabela perkusji
    private @FXML TableView tabelaPerkusja;
    private @FXML TableColumn kolumnaPerkusjaNazwa;
    private @FXML TableColumn kolumnaPerkusjaProducent;
    private @FXML TableColumn kolumnaPerkusjaCena;
    private @FXML TableColumn kolumnaPerkusjaRodzaj;

    //edycja naglosnienie
    private @FXML TextField nazwaNaglosnienie;
    private @FXML TextField producentNaglosnienie;
    private @FXML TextField cenaNaglosnienie;
    private @FXML ComboBox<String> rodzajNaglosnienie;
    private ObservableList<String> rodzajeNaglosnienia = FXCollections.observableArrayList("Konsola", "Głośnik","Mikrofon");
    private @FXML ComboBox<String> klasaNaglosnienie;
    private ObservableList<String> klasyNaglosnienia = FXCollections.observableArrayList("Domowe", "Estradowe");
    // tabela perkusji
    private @FXML TableView tabelaNaglosnienie;
    private @FXML TableColumn kolumnaNaglosnienieRodzaj;
    private @FXML TableColumn kolumnaNaglosnienieNazwa;
    private @FXML TableColumn kolumnaNaglosnienieProducent;
    private @FXML TableColumn kolumnaNaglosnienieCena;
    private @FXML TableColumn kolumnaNaglosnienieKlasa;

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


    private  void usun(ObservableList wszystko, TableView tabela, ObservableList wybranyrekord) throws IOException {
        wszystko = tabela.getItems();
        wybranyrekord = tabela.getSelectionModel().getSelectedItems();
        wybranyrekord.forEach(wszystko::remove);
    }

    @FXML
    private void UsunGitaraAction(ActionEvent event) throws IOException {
        usun(wszystkoGitara,tabelaGitar,wybranyrekordGitara);
    }

    @FXML
    private void EdytujGitaraAction() throws IOException {
        NumerRekorduGitara = tabelaGitar.getSelectionModel().getSelectedIndex();
        setWybranyrekordGitara(wybranyrekordGitara);
        nazwaGitara.setText(listaGitar.get(NumerRekorduGitara).getNazwa());
        producentGitara.setText(listaGitar.get(NumerRekorduGitara).getProducent());
        cenaGitara.setText(String.valueOf(listaGitar.get(NumerRekorduGitara).getCena()));
        liczbastrunGitara.setText(String.valueOf(listaGitar.get(NumerRekorduGitara).getLiczba_strun()));
        liczbaprzystawekGitara.setText(String.valueOf(listaGitar.get(NumerRekorduGitara).getLiczba_przystawek()));
        liczbaprogowGitara.setText(String.valueOf(listaGitar.get(NumerRekorduGitara).getLiczba_progow()));
    }

    @FXML
    private void zatwierdzEdycjeGitaraAction(ActionEvent event) throws IOException {
        listaGitar.get(NumerRekorduGitara).setNazwa(nazwaGitara.getText());
        listaGitar.get(NumerRekorduGitara).setProducent(producentGitara.getText());
        listaGitar.get(NumerRekorduGitara).setCena(Float.valueOf(cenaGitara.getText()));
        listaGitar.get(NumerRekorduGitara).setLiczba_strun(Integer.valueOf(liczbastrunGitara.getText()));
        listaGitar.get(NumerRekorduGitara).setLiczba_progow(Integer.valueOf(liczbaprogowGitara.getText()));
        listaGitar.get(NumerRekorduGitara).setLiczba_przystawek(Integer.valueOf(liczbaprzystawekGitara.getText()));
        listaGitar.get(NumerRekorduGitara).setRodzaj(rodzajGitara.getValue());
        //odswiezanie tablicy
        tabelaGitar.getColumns().clear();
        tabelaGitar.getColumns().addAll(kolumnaGitaraNazwa,kolumnaGitaraProducent,kolumnaGitaraCena,kolumnaGitaraLiczbaStrun,
                kolumnaGitaraLiczbaPrzystawek, kolumnaGitaraLiczbaProgow,kolumnaGitaraRodzaj);
    }

    @FXML
    private void UsunKlawiszeAction(ActionEvent event) throws IOException {
        usun(wszystkoKlawisze,tabelaKlawisze,wybranyrekordKlawisze);
    }

    @FXML
    private void EdytujKlawiszeAction() throws IOException {
        NumerRekorduKlawisze = tabelaKlawisze.getSelectionModel().getSelectedIndex();
        setWybranyrekordKlawisze(wybranyrekordKlawisze);
        nazwaKlawisze.setText(listaKlawiszy.get(NumerRekorduKlawisze).getNazwa());
        producentKlawisze.setText(listaKlawiszy.get(NumerRekorduKlawisze).getProducent());
        cenaKlawisze.setText(String.valueOf(listaKlawiszy.get(NumerRekorduKlawisze).getCena()));
    }

    @FXML
    private void zatwierdzEdycjeKlawiszeAction(ActionEvent event) throws IOException {
        listaKlawiszy.get(NumerRekorduKlawisze).setNazwa(nazwaKlawisze.getText());
        listaKlawiszy.get(NumerRekorduKlawisze).setProducent(producentKlawisze.getText());
        listaKlawiszy.get(NumerRekorduKlawisze).setCena(Float.valueOf(cenaKlawisze.getText()));
        listaKlawiszy.get(NumerRekorduKlawisze).setRodzaj(rodzajKlawisze.getValue());
        //odswiezanie tablicy
        tabelaKlawisze.getColumns().clear();
        tabelaKlawisze.getColumns().addAll(kolumnaKlawiszeNazwa,kolumnaKlawiszeProducent,
                kolumnaKlawiszeCena,kolumnaKlawiszeRodzaj);
    }

    @FXML
    private void UsunPerkusjeAction(ActionEvent event) throws IOException {
        usun(wszystkoPerkusja,tabelaPerkusja,wybranyrekordPerkusja);
    }

    @FXML
    private void EdytujPerkusjeAction() throws IOException {
        NumerRekorduPerkusja = tabelaPerkusja.getSelectionModel().getSelectedIndex();
        setWybranyrekordPerkusja(wybranyrekordPerkusja);
        nazwaPerkusja.setText(listaPerkusji.get(NumerRekorduPerkusja).getNazwa());
        producentPerkusja.setText(listaPerkusji.get(NumerRekorduPerkusja).getProducent());
        cenaPerkusja.setText(String.valueOf(listaPerkusji.get(NumerRekorduPerkusja).getCena()));
    }

    @FXML
    private void zatwierdzEdycjePerkusjaAction(ActionEvent event) throws IOException {
        listaPerkusji.get(NumerRekorduPerkusja).setNazwa(nazwaPerkusja.getText());
        listaPerkusji.get(NumerRekorduPerkusja).setProducent(producentPerkusja.getText());
        listaPerkusji.get(NumerRekorduPerkusja).setCena(Float.valueOf(cenaPerkusja.getText()));
        listaPerkusji.get(NumerRekorduPerkusja).setRodzaj(rodzajPerkusja.getValue());
        //odswiezanie tablicy
        tabelaPerkusja.getColumns().clear();
        tabelaPerkusja.getColumns().addAll(kolumnaPerkusjaNazwa,kolumnaPerkusjaProducent,
                kolumnaPerkusjaCena,kolumnaPerkusjaRodzaj);
    }

    @FXML
    private void UsunNaglosnienieAction(ActionEvent event) throws IOException {
        usun(wszystkoNaglosnienie,tabelaNaglosnienie,wybranyrekordNaglosnienie);
    }

    @FXML
    private void EdytujNaglosnienieAction() throws IOException {
        NumerRekorduNaglosnienie= tabelaNaglosnienie.getSelectionModel().getSelectedIndex();
        setWybranyrekordNaglosnienie(wybranyrekordNaglosnienie);
        nazwaNaglosnienie.setText(listaNaglosnienie.get(NumerRekorduNaglosnienie).getNazwa());
        producentNaglosnienie.setText(listaNaglosnienie.get(NumerRekorduNaglosnienie).getProducent());
        cenaNaglosnienie.setText(String.valueOf(listaNaglosnienie.get(NumerRekorduNaglosnienie).getCena()));
    }

    @FXML
    private void zatwierdzEdycjeNaglosnienieAction(ActionEvent event) throws IOException {
        listaNaglosnienie.get(NumerRekorduNaglosnienie).setNazwa(nazwaNaglosnienie.getText());
        listaNaglosnienie.get(NumerRekorduNaglosnienie).setProducent(producentNaglosnienie.getText());
        listaNaglosnienie.get(NumerRekorduNaglosnienie).setCena(Float.valueOf(cenaNaglosnienie.getText()));
        listaNaglosnienie.get(NumerRekorduNaglosnienie).setRodzaj(rodzajNaglosnienie.getValue());
        listaNaglosnienie.get(NumerRekorduNaglosnienie).setKlasa(klasaNaglosnienie.getValue());
        //odswiezanie tablicy
        tabelaNaglosnienie.getColumns().clear();
        tabelaNaglosnienie.getColumns().addAll(kolumnaNaglosnienieRodzaj,kolumnaNaglosnienieNazwa,
                kolumnaNaglosnienieProducent,kolumnaNaglosnienieCena,kolumnaNaglosnienieKlasa);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rodzajGitara.setItems(rodzajeGitar);
        rodzajKlawisze.setItems(rodzajeKlawiszy);
        rodzajPerkusja.setItems(rodzajePerkusji);
        rodzajNaglosnienie.setItems(rodzajeNaglosnienia);
        klasaNaglosnienie.setItems(klasyNaglosnienia);

        tabelaGitar.itemsProperty().setValue(listaGitar);
        kolumnaGitaraNazwa.setCellValueFactory(new PropertyValueFactory<Gitara, String>("nazwa"));
        kolumnaGitaraProducent.setCellValueFactory(new PropertyValueFactory<Gitara, String>("producent"));
        kolumnaGitaraCena.setCellValueFactory(new PropertyValueFactory<Gitara, Float>("cena"));
        kolumnaGitaraLiczbaStrun.setCellValueFactory(new PropertyValueFactory<Gitara, Integer>("liczba_strun"));
        kolumnaGitaraLiczbaPrzystawek.setCellValueFactory(new PropertyValueFactory<Gitara, Integer>("liczba_przystawek"));
        kolumnaGitaraLiczbaProgow.setCellValueFactory(new PropertyValueFactory<Gitara, Integer>("liczba_progow"));
        kolumnaGitaraRodzaj.setCellValueFactory(new PropertyValueFactory<Gitara, String>("rodzaj"));

        tabelaKlawisze.itemsProperty().setValue(listaKlawiszy);
        kolumnaKlawiszeNazwa.setCellValueFactory(new PropertyValueFactory<Klawisze, String>("nazwa"));
        kolumnaKlawiszeProducent.setCellValueFactory(new PropertyValueFactory<Klawisze, String>("producent"));
        kolumnaKlawiszeCena.setCellValueFactory(new PropertyValueFactory<Klawisze, Float>("cena"));
        kolumnaKlawiszeRodzaj.setCellValueFactory(new PropertyValueFactory<Klawisze, String>("rodzaj"));

        tabelaPerkusja.itemsProperty().setValue(listaPerkusji);
        kolumnaPerkusjaNazwa.setCellValueFactory(new PropertyValueFactory<Perkusja, String>("nazwa"));
        kolumnaPerkusjaProducent.setCellValueFactory(new PropertyValueFactory<Perkusja, String>("producent"));
        kolumnaPerkusjaCena.setCellValueFactory(new PropertyValueFactory<Perkusja, Float>("cena"));
        kolumnaPerkusjaRodzaj.setCellValueFactory(new PropertyValueFactory<Perkusja, String>("rodzaj"));

        tabelaNaglosnienie.itemsProperty().setValue(listaNaglosnienie);
        kolumnaNaglosnienieRodzaj.setCellValueFactory(new PropertyValueFactory<Naglosnienie, String>("rodzaj"));
        kolumnaNaglosnienieNazwa.setCellValueFactory(new PropertyValueFactory<Naglosnienie, String>("nazwa"));
        kolumnaNaglosnienieProducent.setCellValueFactory(new PropertyValueFactory<Naglosnienie, String>("producent"));
        kolumnaNaglosnienieCena.setCellValueFactory(new PropertyValueFactory<Naglosnienie, Float>("cena"));
        kolumnaNaglosnienieKlasa.setCellValueFactory(new PropertyValueFactory<Naglosnienie,String>("klasa"));
    }

    public static ObservableList<Gitara> getWybranyrekordGitara() {
        return wybranyrekordGitara;
    }

    public static void setWybranyrekordGitara(ObservableList<Gitara> wybranyrekordGitara) {
        FXMLwyswietl_instrumentController.wybranyrekordGitara = wybranyrekordGitara;
    }

    public static ObservableList<Klawisze> getWybranyrekordKlawisze() {
        return wybranyrekordKlawisze;
    }

    public static void setWybranyrekordKlawisze(ObservableList<Klawisze> wybranyrekordKlawisze) {
        FXMLwyswietl_instrumentController.wybranyrekordKlawisze = wybranyrekordKlawisze;
    }

    public static ObservableList<Perkusja> getWybranyrekordPerkusja() {
        return wybranyrekordPerkusja;
    }

    public static void setWybranyrekordPerkusja(ObservableList<Perkusja> wybranyrekordPerkusja) {
        FXMLwyswietl_instrumentController.wybranyrekordPerkusja = wybranyrekordPerkusja;
    }

    public static ObservableList<Naglosnienie> getWybranyrekordNaglosnienie() {
        return wybranyrekordNaglosnienie;
    }

    public static void setWybranyrekordNaglosnienie(ObservableList<Naglosnienie> wybranyrekordNaglosnienie) {
        FXMLwyswietl_instrumentController.wybranyrekordNaglosnienie = wybranyrekordNaglosnienie;
    }
}
