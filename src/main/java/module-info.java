module com.example.final_project_programming {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.final_project_programming to javafx.fxml;
    exports com.example.final_project_programming;
}