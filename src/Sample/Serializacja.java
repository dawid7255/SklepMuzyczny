package Sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.beans.PersistenceDelegate;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Serializacja {

    public static ObservableList<Gitara> listaGitar = FXCollections.observableArrayList();

    public static ObservableList<Klawisze> listaKlawiszy = FXCollections.observableArrayList();

    public static ObservableList<Perkusja> listaPerkusji = FXCollections.observableArrayList();

    public static ObservableList<Naglosnienie> listaNaglosnienie = FXCollections.observableArrayList();

    public static ObservableList<Uslugi> listaUslug = FXCollections.observableArrayList();

    public static List glownaLista = new ArrayList<>();

    public static void ZapiszAction() throws IOException {
        glownaLista.clear();
        Stage zapisPliku = new Stage();

        for (int i = 0; i < listaGitar.size(); i++) {
            glownaLista.add(listaGitar.get(i));
        }

        for (int i = 0; i < listaKlawiszy.size(); i++) {
            glownaLista.add(listaKlawiszy.get(i));
        }

        for (int i = 0; i < listaPerkusji.size(); i++) {
            glownaLista.add(listaPerkusji.get(i));
        }

        for (int i = 0; i < listaNaglosnienie.size(); i++) {
            glownaLista.add(listaNaglosnienie.get(i));
        }

        for (int i = 0; i < listaUslug.size(); i++) {
            glownaLista.add(listaUslug.get(i));
        }

        FileChooser zapisywaniePliku = new FileChooser();
        zapisywaniePliku.setTitle("Zapisz plik");
        zapisywaniePliku.setInitialDirectory(new File(System.getProperty("user.home")));
        zapisywaniePliku.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pliki XML", "*.xml"));
        File zapisywanyPlik = zapisywaniePliku.showSaveDialog(zapisPliku);
        if (zapisywanyPlik != null) {
            XMLEncoder zapis = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(zapisywanyPlik)));

            for (int i = 0; i < glownaLista.size(); i++) {
                PersistenceDelegate pd = zapis.getPersistenceDelegate(Integer.class);
                zapis.setPersistenceDelegate(BigDecimal.class, pd);
                zapis.writeObject(glownaLista.get(i));
            }
            zapis.close();
            System.out.println("Zapisało plik");
        }
    }

    public static void WczytajAction() throws IOException {
        //otwarcie pliku
        Stage otwarciepliku = new Stage();

        glownaLista.clear(); //czyszczenie listy glownej
        listaGitar.clear();
        listaKlawiszy.clear();
        listaPerkusji.clear();
        listaNaglosnienie.clear();
        listaUslug.clear();

        FileChooser OknoOtwieraniaPliku = new FileChooser();
        OknoOtwieraniaPliku.setTitle("Otwórz plik");
        OknoOtwieraniaPliku.setInitialDirectory(new File(System.getProperty("user.home")));
        OknoOtwieraniaPliku.getExtensionFilters().add(new FileChooser.ExtensionFilter("Pliki XML", "*.xml"));
        File otwieranyPlik = OknoOtwieraniaPliku.showOpenDialog(otwarciepliku); // Pokaż okno
        if (otwieranyPlik != null) {
            XMLDecoder odczyt = new XMLDecoder(new BufferedInputStream(new FileInputStream(otwieranyPlik)));

            while (true) {
                try {
                    glownaLista.add(odczyt.readObject());
                } catch (Exception e) {
                    break;
                }
            }

            for (int i = 0; i < glownaLista.size(); i++) {
                String klasa = glownaLista.get(i).getClass().toString();
                if (klasa.equals("class Sample.Gitara")) {
                    listaGitar.add((Gitara) glownaLista.get(i));
                }
                if (klasa.equals("class Sample.Klawisze")) {
                    listaKlawiszy.add((Klawisze) glownaLista.get(i));
                }
                if (klasa.equals("class Sample.Perkusja")) {
                    listaPerkusji.add((Perkusja) glownaLista.get(i));
                }
                if (klasa.equals("class Sample.Naglosnienie")) {
                    listaNaglosnienie.add((Naglosnienie) glownaLista.get(i));
                }
                if (klasa.equals("class Sample.Uslugi")) {
                    listaUslug.add((Uslugi) glownaLista.get(i));
                }
            }
        }
        System.out.println("Otwarto plik");
    }
}