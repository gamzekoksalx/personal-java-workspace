package com.gamzekoksalx.simplegui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/** Simple JavaFX app with menu actions. */
public class SimpleGUI extends Application {

    /** Output display field. */
    TextField outputField = new TextField();

    /**
     * Builds the UI and sets event actions.
     * @param stage the main window
     */
    @Override
    public void start(Stage stage) {
        MenuBar topMenuBar = new MenuBar();
        Menu mainMenu = new Menu("Actions");
        MenuItem showTime = new MenuItem("Display Current Date & Time");
        MenuItem saveText = new MenuItem("Save Text Field Content to File");
        MenuItem randomGreen = new MenuItem("Display a Random Hue of Green");
        MenuItem quit = new MenuItem("Close the App");

        mainMenu.getItems().addAll(showTime, saveText, randomGreen, quit);
        topMenuBar.getMenus().add(mainMenu);

        // Show date and time
        showTime.setOnAction(e -> {
            try {
                DateTimeFormatter f = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy h:mm a");
                outputField.setText("Current Date & Time: " + LocalDateTime.now().format(f));
            } catch (Exception ex) {
                outputField.setText("Date error.");
            }
        });

        // Save to file
        saveText.setOnAction(e -> {
            try (FileWriter writer = new FileWriter("log.txt", true)) {
                writer.write(outputField.getText() + "\n");
                outputField.setText("Saved.");
            } catch (IOException ex) {
                outputField.setText("File error.");
            } catch (SecurityException ex) {
                outputField.setText("No write access.");
            }
        });

        // Change background
        randomGreen.setOnAction(e -> {
            try {
                double h = 90 + Math.random() * 60;
                outputField.getScene().getRoot().setStyle("-fx-background-color: hsb(" + h + ", 50%, 90%);");
                randomGreen.setText("Change Hue: " + (int) h);
            } catch (Exception ex) {
                outputField.setText("Color error.");
            }
        });

        // Exit app
        quit.setOnAction(e -> stage.close());

        outputField.setPrefHeight(40);
        Label label = new Label("Output:");
        VBox content = new VBox(10, label, outputField);
        content.setPadding(new Insets(15));
        content.setAlignment(Pos.CENTER_LEFT);

        BorderPane layout = new BorderPane();
        layout.setTop(topMenuBar);
        layout.setCenter(content);

        Scene scene = new Scene(layout, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Simple JavaFX GUI");
        stage.show();
    }

    /**
     * Launches the app.
     * @param args CLI args
     */
    public static void main(String[] args) {
        launch();
    }
}