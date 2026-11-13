module vallegrande.edu.pe.productostecnologicos {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens vallegrande.edu.pe.productostecnologicos to javafx.fxml;
    opens vallegrande.edu.pe.productostecnologicos.controller to javafx.fxml;
    opens vallegrande.edu.pe.productostecnologicos.model to javafx.base; // Para el TableView
    exports vallegrande.edu.pe.productostecnologicos;
    exports vallegrande.edu.pe.productostecnologicos.controller;
}