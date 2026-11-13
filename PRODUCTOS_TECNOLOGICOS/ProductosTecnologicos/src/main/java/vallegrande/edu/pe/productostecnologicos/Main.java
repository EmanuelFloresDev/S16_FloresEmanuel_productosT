package vallegrande.edu.pe.productostecnologicos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import vallegrande.edu.pe.productostecnologicos.controller.ProductoController;
import vallegrande.edu.pe.productostecnologicos.model.ProductoDAO;
import vallegrande.edu.pe.productostecnologicos.view.ProductoView;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        // Instanciar los componentes del MVC
        ProductoView view = new ProductoView();
        ProductoDAO dao = new ProductoDAO();
        new ProductoController(view, dao);

        // Cargar la vista pura en la escena
        Scene scene = new Scene(view.getRoot(), 850, 650);
        stage.setTitle("Gestión de Productos Tecnológicos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}