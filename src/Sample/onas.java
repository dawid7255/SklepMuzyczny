package Sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class onas {
    public static void messagebox(){
        String title = "O mnie";
        String message = "Projekt: Sklep muzyczny " +
                "\n\nDawid Wiatrowski" +
                "\nNumer albumu 129028" +
                "\n\nPaweł Szajda" +
                "\nNumer albumu 129022" +
                "\n\nInformatyka [WI]"+
                "\nStudia niestacjonarne" +
                "\n\nE-mail: " +
                "\ndawid.wiatrowski@student.put.poznan.pl" +
                "\npawel.szajda@student.put.poznan.pl";
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(450);

        javafx.scene.control.Label label = new javafx.scene.control.Label();
        label.setText(message);
        label.setTextAlignment(TextAlignment.CENTER);
        label.setFont(new javafx.scene.text.Font("Times New Roman",20));


        Button button = new Button("Zamknij");
        button.setOnAction(event -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.show();
    }
}
