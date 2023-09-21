package lk.ijse.fisheryharbour.controller;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lk.ijse.fisheryharbour.model.QueryModel;
import lk.ijse.fisheryharbour.model.TaxModel;
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

public class TaxManageFormController implements Initializable {
    public String innovativeBoatId;
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
            Platform.runLater(() -> {
                while (true){
                    renameImgPhone();
                    imgTranfer();
                    qrDecode();
                    deleteImgPhone();
                    deleteImgLap();
                }
            });
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

//    public void setInnovativeBoatId(String id) {
//        TaxManageFormController.innovativeBoatId = id;
//        try {
//            innovativePopup();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    private void innovativePopup() throws SQLException, ClassNotFoundException, IOException {
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
            System.out.println("Popup");
//            Navigation.switchPaging(innovativePopupPane, "PaidPopupForm.fxml");
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



    public static void renameImgPhone() {
        String folderPath = "/storage/30A6-324B/DCIM/Camera/";

        String adbListCommand = "adb shell ls " + folderPath;

        boolean isImageFound = false;
        while (!isImageFound) {
            try {
                Process process = Runtime.getRuntime().exec(adbListCommand);
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Check if the file is an image (you can use a more specific condition)
                    if (line.endsWith(".jpg") || line.endsWith(".png") || line.endsWith(".jpeg")) {
                        // Rename the image file
                        String oldFilePath = folderPath + line;
                        String newFilePath = folderPath + "B001.jpg"; // Replace with the new file name

                        String adbRenameCommand = "adb shell mv " + oldFilePath + " " + newFilePath;
                        Process renameProcess = Runtime.getRuntime().exec(adbRenameCommand);
                        int exitCode = renameProcess.waitFor();

                        if (exitCode == 0) {
                            System.out.println("Image renamed successfully!");
                            isImageFound = true;
                            break; // Exit the loop after renaming the first image found
                        } else {
                            System.err.println("Image renaming failed. Exit code: " + exitCode);
                        }
                    }
                }

                reader.close();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public  void imgTranfer() {

        String adbCommand = "adb pull /storage/30A6-324B/DCIM/Camera/B001.jpg D:\\Solution99";
        boolean imageFound = false;

        try {
            while (!imageFound) {
                Process process = Runtime.getRuntime().exec(adbCommand);
                int exitCode = process.waitFor();
                if (exitCode == 0) {
                    System.out.println("File transfer successful!");
                    imageFound = true;
                    System.out.println(adbCommand);
                } else {
                    System.err.println("File transfer failed. Exit code: " + exitCode);
                }
                Thread.sleep(2000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  void qrDecode(){
        try {
            File qrCodeImage = new File("D:\\Solution99\\B001.jpg");
            BufferedImage bufferedImage = ImageIO.read(qrCodeImage);

            LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            String decodedText = result.getText();
            System.out.println(decodedText);

            innovativeBoatId = decodedText;
            innovativePopup();

        } catch (IOException | NotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  void deleteImgPhone() {
        String adbCommand = "adb shell rm /storage/30A6-324B/DCIM/Camera/B001.jpg";

        try {
            Process process = Runtime.getRuntime().exec(adbCommand);
            int exitCode = process.waitFor();

            if (exitCode == 0) {
                System.out.println("File deleted successfully!");
            } else {
                System.err.println("File deletion failed. Exit code: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void deleteImgLap() {
        String imagePath = "D:\\Solution99\\B001.jpg"; // Replace with the actual path of your image

        try {
            Path path = Paths.get(imagePath);
            Files.deleteIfExists(path);
            System.out.println("Image deleted successfully.");
        } catch (NoSuchFileException e) {
            System.out.println("The image does not exist.");
        } catch (DirectoryNotEmptyException e) {
            System.out.println("The specified path is a directory.");
        } catch (IOException e) {
            System.out.println("An I/O error occurred.");
            e.printStackTrace();
        }
    }
}
