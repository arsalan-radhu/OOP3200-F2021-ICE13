/*
 * @Name: Arsalan Arif Radhu
 * @Student ID: 100813965
 * @Date: 15 December 2021
 */


package ca.durhamcollege.oop3200f2021ice13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.io.FileInputStream;


public class Main extends Application
{

    public static int WIDTH = 640;
    public static int HEIGHT = 480;

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Image Select!");


        // Step 1 - create one or more control
        Label imageLabel = new Label("Apple!");


        Button clickMeButton = new Button("Click me");
        clickMeButton.setStyle("-fx-font-family: Arial");


        FileInputStream appleImagePath = new FileInputStream("src/main/apple.jpg");

        // step 1 for images - is load the image
        Image apple = new Image(appleImagePath);

        // step 2 for images - is setup a ImageView to "contain it"
        ImageView consoleImageView = new ImageView(apple);
        consoleImageView.setFitWidth(400);
        consoleImageView.setPreserveRatio(true);

        FileInputStream orangeImagePath = new FileInputStream("src/main/orange.jpg");
        Image orange = new Image(orangeImagePath);


        // Step 1.1 - Configure your control
        class ButtonClickHandler implements EventHandler<ActionEvent>
        {
            @Override
            public void handle(ActionEvent event)
            {
                imageLabel.setText("Orange!");
                consoleImageView.setImage(orange);
            }
        }

        clickMeButton.setOnAction(new ButtonClickHandler());

        // Step 1.2 - For button controls (or other event-type controls) - set the event

        // Step 2 - create a container
        HBox hbox = new HBox(10, imageLabel);
        hbox.setStyle("-fx-alignment: center; ");

        HBox hbox2 = new HBox(10, consoleImageView);

        GridPane gridPane = new GridPane();

        gridPane.setMinSize(6, 8);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        gridPane.add(hbox, 0, 0);
        gridPane.add(hbox2, 0, 1);
        gridPane.add(consoleImageView, 0, 2);
        gridPane.add(clickMeButton, 2, 2);


        gridPane.setStyle("-fx-border-color: black; -fx-font-size: 20; -fx-font-family: Consolas;");

        // Step 3 - add layout container to scene
        Scene scene = new Scene(gridPane, WIDTH, HEIGHT);

        // Step 4 - add scene to stage
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}