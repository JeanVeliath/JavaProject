package sample;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Student record");
//        Line line = new Line(100,100,350,100);
//        Group root1 = new Group(b);
        primaryStage.setScene(new Scene(root, 475, 300));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
