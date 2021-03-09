import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.geometry.Orientation;

public class Main extends Application{

    public static void main(String[] args) {

        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label lbl = new Label();
        Label lbl_in = new Label("Enter path to folder : ");
        TextField textField = new TextField();
        textField.setPrefColumnCount(80);
        Label lbl_out = new Label("Enter path to folder : ");
        TextField textField1 = new TextField();
        textField1.setPrefColumnCount(80);


        Button btn1 = new Button("Change");

        btn1.setOnAction(action -> {
            String pathToMainFolder = (textField.getText());
            String targetFolder = (textField1.getText());
            lbl.setText("Input: " + textField.getText());
            NewApp docum = new NewApp(pathToMainFolder, targetFolder);
            docum.main();
            textField.clear();
            textField1.clear();


        });
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,lbl_in, textField,lbl_out,textField1,btn1, lbl);
        Scene scene = new Scene(root, 650, 200);

        stage.setScene(scene);
        stage.setTitle("RTS File Changer");
        stage.show();
    }
}



