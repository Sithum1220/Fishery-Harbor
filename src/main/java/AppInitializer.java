import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AppInitializer extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/dashboardForm.fxml"));
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}
