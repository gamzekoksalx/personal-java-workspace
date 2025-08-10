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

/** Simple JavaFX app with menu actions, refactored into small methods. */
public class SimpleGUI extends Application {

    private static final String LOG_FILE = "log.txt";
    private static final DateTimeFormatter TIME_FMT =
            DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy h:mm a");

    /** Output display field. */
    private final TextField outputField = new TextField();

    @Override
    public void start(Stage stage) {
        MenuBar menuBar = createMenuBar(stage);
        VBox content = createContent();

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(content);

        Scene scene = new Scene(layout, 400, 200);
        stage.setScene(scene);
        stage.setTitle("Simple JavaFX GUI");
        stage.show();
    }

    /* -------------------- UI builders -------------------- */

    private MenuBar createMenuBar(Stage stage) {
        MenuItem showTime = new MenuItem("Display Current Date & Time");
        MenuItem saveText = new MenuItem("Save Text Field Content to File");
        MenuItem randomGreen = new MenuItem("Display a Random Hue of Green");
        MenuItem quit = new MenuItem("Close the App");

        configureMenuActions(stage, showTime, saveText, randomGreen, quit);

        Menu mainMenu = new Menu("Actions");
        mainMenu.getItems().addAll(showTime, saveText, randomGreen, quit);

        MenuBar bar = new MenuBar();
        bar.getMenus().add(mainMenu);
        return bar;
    }

    private VBox createContent() {
        outputField.setPrefHeight(40);
        Label label = new Label("Output:");
        VBox content = new VBox(10, label, outputField);
        content.setPadding(new Insets(15));
        content.setAlignment(Pos.CENTER_LEFT);
        return content;
    }

    private void configureMenuActions(Stage stage,
                                      MenuItem showTime,
                                      MenuItem saveText,
                                      MenuItem randomGreen,
                                      MenuItem quit) {
        showTime.setOnAction(e -> handleShowTime());
        saveText.setOnAction(e -> handleSaveText());
        randomGreen.setOnAction(e -> handleRandomGreen(randomGreen));
        quit.setOnAction(e -> handleQuit(stage));
    }

    /* -------------------- Handlers -------------------- */

    private void handleShowTime() {
        try {
            outputField.setText("Current Date & Time: " + formatNow());
        } catch (RuntimeException ex) {
            setStatus("Date error.");
        }
    }

    private void handleSaveText() {
        String text = outputField.getText();
        try {
            appendToLog(text);
            setStatus("Saved.");
        } catch (SecurityException se) {
            setStatus("No write access.");
        } catch (IOException ioe) {
            setStatus("File error.");
        }
    }

    private void handleRandomGreen(MenuItem sourceItem) {
        try {
            double hue = getRandomGreenHue();
            applyGreenBackground(hue);
            sourceItem.setText("Change Hue: " + (int) hue);
        } catch (RuntimeException ex) {
            setStatus("Color error.");
        }
    }

    private void handleQuit(Stage stage) {
        stage.close();
    }

    /* -------------------- Helpers (logic) -------------------- */

    private String formatNow() {
        return LocalDateTime.now().format(TIME_FMT);
    }

    private void appendToLog(String line) throws IOException {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(line + System.lineSeparator());
        }
    }

    private double getRandomGreenHue() {
        // Green band ~90–150 degrees in HSB; keep saturation/brightness pleasant.
        return 90 + Math.random() * 60;
    }

    private void applyGreenBackground(double hue) {
        // 50% saturation, 90% brightness for a soft pastel background.
        String style = String.format("-fx-background-color: hsb(%.2f, 50%%, 90%%);", hue);
        outputField.getScene().getRoot().setStyle(style);
    }

    private void setStatus(String message) {
        outputField.setText(message);
    }

    public static void main(String[] args) {
        launch();
    }
}