module com.example.airvivacw {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires mysql.connector.j;

    opens com.example.airvivacw to javafx.fxml;
    exports com.example.airvivacw;
    exports com.example.airvivacw.database;
    opens com.example.airvivacw.database to javafx.fxml;
    exports com.example.airvivacw.ticket;
    opens com.example.airvivacw.ticket to javafx.fxml;
}