package lk.ijse.fisheryharbour.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.net.URL;
import java.util.ResourceBundle;

public class PaidPopupFormController implements Initializable {
    public Text txtBoatId;
    public Text txtBoatName;
    public Text txtOwnerName;
    public Text txtDate;

    public void closeOnMouseClicked(MouseEvent mouseEvent) {
        Navigation.adminClosePane();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("qqqqqqq");
    }
}
