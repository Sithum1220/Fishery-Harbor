package lk.ijse.fisheryharbour.controller;

import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.utill.Navigation;

public class PaidPopupFormController {
    public Text txtBoatId;
    public Text txtBoatName;
    public Text txtOwnerName;
    public Text txtDate;

    public void closeOnMouseClicked(MouseEvent mouseEvent) {
        Navigation.adminClosePane();
    }
}
