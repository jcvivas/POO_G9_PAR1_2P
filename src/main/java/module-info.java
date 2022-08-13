module proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens proyecto to javafx.fxml;
    exports controladores;
}
