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

    private ArrayList<Country> allCountries;
    private Country currentQuestion;
    private int score = 0;

    public void initialize() {
        ApiClient client = new ApiClient();
        allCountries = client.fetchCountries();
        nextQuestion();
    }

    @FXML
    private void handleAnswer(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String selectedAnswer = clickedButton.getText();

        if (currentQuestion != null && selectedAnswer.equals(currentQuestion.getCapital())) {
            score++;
            scoreLabel.setText("Score: " + score);
            messageLabel.setText("Correct!");
            messageLabel.setStyle("-fx-text-fill: green;");
        } else {
            messageLabel.setText("Wrong! Correct answer was: " + currentQuestion.getCapital());
            messageLabel.setStyle("-fx-text-fill: red;");
        }

        nextQuestion();
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