package lk.ijse.fisheryharbour.controller;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.QueryModel;
import lk.ijse.fisheryharbour.model.RentModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RentDetailsFormController implements Initializable {
    private static RentDetailsFormController controller;
    public VBox vBox;

    public RentDetailsFormController() {
    controller = this;
    }

    public static RentDetailsFormController getInstance() {
        return controller;
    }

    public void btnRentAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.AdminPopupPane("RentAddForm.fxml");
    }

    public void btnTaxDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(AdminGlobalFormController.getInstance().pagingPane, "TaxManageForm.fxml");
    }

    public void allRentId() throws SQLException, ClassNotFoundException {
        vBox.getChildren().clear();
        RentModel rentModel = new RentModel();
        ArrayList<String> list = rentModel.getAllRentId();

        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(RentDetailsFormController.class.getResource("/view/RentDetailsBarForm.fxml"));
            Parent root = loader.load();
            RentDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allRentId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
