module com.example.final_project_programming {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.net.http;

    requires com.google.gson;


    opens com.example.final_project_programming to javafx.fxml, com.google.gson;
    exports com.example.final_project_programming;
}