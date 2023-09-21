package lk.ijse.fisheryharbour.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.QueryModel;
import lk.ijse.fisheryharbour.model.TaxModel;
import lk.ijse.fisheryharbour.utill.Navigation;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TaxManageFormController implements Initializable {
    public static String innovativeBoatId;
    private static TaxManageFormController controller;
    public VBox vBox;
    public Pane innovativePopupPane;

    public TaxManageFormController() {
        controller = this;
    }

    public static TaxManageFormController getInstance() {
        return controller;
    }

    public void btnTaxAddOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.AdminPopupPane("TaxAddForm.fxml");
    }

    public void btnRentDetailsOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.switchPaging(AdminGlobalFormController.getInstance().pagingPane, "RentDetailsForm.fxml");
    }

    public void allTaxId() throws SQLException, ClassNotFoundException {
        vBox.getChildren().clear();
        TaxModel taxModel = new TaxModel();
        ArrayList<String> list = taxModel.getAllTaxId();

        for (int i = 0; i < list.size(); i++) {
            loadDataTable(list.get(i));
        }
    }

    private void loadDataTable(String id) {
        try {
            FXMLLoader loader = new FXMLLoader(TaxManageFormController.class.getResource("/view/TaxDetailsBarForm.fxml"));
            Parent root = loader.load();
            TaxDetailsBarFormController controller = loader.getController();
            controller.setData(id);
            vBox.getChildren().add(root);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            allTaxId();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInnovativeBoatId(String id) {
        TaxManageFormController.innovativeBoatId = id;
        try {
            innovativePopup();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void innovativePopup() throws SQLException, ClassNotFoundException {
        QueryModel queryModel = new QueryModel();
        boolean isPay = queryModel.checkTaxPay(innovativeBoatId);
        innovativePopupPane.setVisible(true);
        if (isPay) {
            try {
                FXMLLoader loader = new FXMLLoader(EmployeeManageFormController.class.getResource("/view/PaidPopupForm.fxml"));
                Parent root = loader.load();
                innovativePopupPane.getChildren().add(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(EmployeeManageFormController.class.getResource("/view/NotPaidPopupForm.fxml"));
                Parent root = loader.load();
                innovativePopupPane.getChildren().add(root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
