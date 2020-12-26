// IPPO Assignment 2, Version 0.1, 28/11/2020


import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Application GUI class - Starts and initialises the GUI
 *
 * @author Olivier Chaligne &lt;s2137159@ed.ac.uk&gt;
 * @version 0.1, 28/11/2020
 */

public class GuiJavaFx extends Application {

    public static final String INTERFACE_LOCATION = "gui.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {

        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(INTERFACE_LOCATION));
            Parent anchorPane = loader.load();
            stage.setScene(new Scene(anchorPane));
            stage.show();

            Controller controller = (Controller) loader.getController();
            controller.initialisation();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }


}
