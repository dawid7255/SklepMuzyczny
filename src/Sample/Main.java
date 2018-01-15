package Sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/** Klasa glowna programu. Tutaj startuje pierwsza scena.*/
public class Main extends Application {
    /**
     * zmienna statyczna sluzaca do zmiany scen
     */
    static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Sklep muzyczny");
        primaryStage.setScene(new Scene(root, 1024, 600));
        primaryStage.show();
    }

    /**
     * @param sceneName zmienna przechowujaca nazwe sceny na ktora ma zmienic sie aplikacja
     * @throws IOException wyjatek?
     */
    public static void zmianaSceny(String sceneName) throws IOException{
        Parent root = FXMLLoader.load(Main.class.getResource(sceneName));
        stage.setScene(new Scene(root, 1024,600));
    }


    /**
     * @param args ...?
     */
    public static void main(String[] args) {
        launch(args);
    }
}
