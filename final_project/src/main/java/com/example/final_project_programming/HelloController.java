package com.example.final_project_programming;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class HelloController {
    @FXML
    private Label countryLabel;

    @FXML
    private Label messageLabel;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button btn1, btn2, btn3, btn4;

    @FXML
    private Button restartButton;

    private ArrayList<Country> allCountries;
    private Country currentQuestion;
    private int score = 0;
    private int questionCount = 0;
    private final int max_questions = 10;

    public void initialize() {
        ApiClient client = new ApiClient();
        allCountries = client.fetchCountries();
        nextQuestion();
    }

    @FXML
    private void handleAnswer(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String selectedAnswer = clickedButton.getText();
        questionCount++;

        if (currentQuestion != null && selectedAnswer.equals(currentQuestion.getCapital())) {
            score++;
            scoreLabel.setText("Score: " + score);
            messageLabel.setText("Correct!");
            messageLabel.setStyle("-fx-text-fill: green;");
        } else {
            messageLabel.setText("Wrong! Correct answer was: " + currentQuestion.getCapital());
            messageLabel.setStyle("-fx-text-fill: red;");
        }

        if (questionCount >= max_questions) {
            finishGame();
        } else {
            nextQuestion();
        }
    }

    private void finishGame() {
        messageLabel.setText("Game Over! Final Score: " + score + " / " + max_questions);
        messageLabel.setStyle("-fx-text-fill: #2c3e50; -fx-font-weight: bold;");

        btn1.setDisable(true);
        btn2.setDisable(true);
        btn3.setDisable(true);
        btn4.setDisable(true);

        restartButton.setVisible(true);
        restartButton.setManaged(true);
    }

    @FXML
    private void handleRestart(ActionEvent event) {
        score = 0;
        questionCount = 0;
        scoreLabel.setText("Score: 0");
        messageLabel.setText("Game Restarted!");
        messageLabel.setStyle("-fx-text-fill: blue;");

        btn1.setDisable(false);
        btn2.setDisable(false);
        btn3.setDisable(false);
        btn4.setDisable(false);

        restartButton.setVisible(false);
        restartButton.setManaged(false);

        nextQuestion();
    }

    @FXML
    private void handleExit(ActionEvent event) {
        System.exit(0);
    }

    public void nextQuestion() {
        if (allCountries == null || allCountries.isEmpty())
            return;

        Random rand = new Random();
        currentQuestion = allCountries.get(rand.nextInt(allCountries.size()));
        countryLabel.setText("What is the capital of " + currentQuestion.getName() + "?");

        ArrayList<String> options = new ArrayList<>();
        options.add(currentQuestion.getCapital());

        while (options.size() < 4) {
            String randomCapital = allCountries.get(rand.nextInt(allCountries.size())).getCapital();
            if (!options.contains(randomCapital)) {
                options.add(randomCapital);
            }
        }

        Collections.shuffle(options);

        btn1.setText(options.get(0));
        btn2.setText(options.get(1));
        btn3.setText(options.get(2));
        btn4.setText(options.get(3));
    }
}