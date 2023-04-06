module com.example.airvivacw {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires mysql.connector.j;
    requires java.desktop;

    opens com.example.airvivacw to javafx.fxml;
    exports com.example.airvivacw;

}