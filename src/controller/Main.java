package controller;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Task;

import java.io.IOException;
import java.util.Date;


public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayaout;
    private ObservableList<Task> taskData = FXCollections.observableArrayList();


    public Main (){
        taskData = FXCollections.observableArrayList();
        taskData.add(new Task("house work", new Date(44444)));
        taskData.add(new Task("program", new Date(55555)));
        taskData.add(new Task("walk", new Date(234653)));
    }


    @Override
    public void start(Stage primaryStage) {
//        Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/editingIntervalScene.fxml"));
//        Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/editingTaskScene.fxml"));
//            Parent root = FXMLLoader.load(getClass().getResource("../view/fxml/listOfTaskScene.fxml"));

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Task Manager");

        // initRootLayout


        // showPersonOverview
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../view/fxml/listScene.fxml"));
            Parent root = loader.load();

            primaryStage.setScene(new Scene(root));
            primaryStage.show();

            TaskOverviewController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Task> getTaskData() {
        return taskData;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
