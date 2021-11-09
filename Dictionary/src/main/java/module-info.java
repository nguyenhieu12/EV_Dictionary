module com.example.dictionary {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires freetts;
    requires org.controlsfx.controls;
    requires json.simple;


    opens com.example.dictionary to javafx.fxml;
    exports com.example.dictionary;
}