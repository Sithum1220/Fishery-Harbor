package lk.ijse.fisheryharbour.controller;

import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.ijse.fisheryharbour.dto.BoatDTO;
import lk.ijse.fisheryharbour.dto.OwnerDTO;
import lk.ijse.fisheryharbour.model.BoatModel;
import lk.ijse.fisheryharbour.model.OwnerModel;
import lk.ijse.fisheryharbour.utill.DateTimeUtil;
import lk.ijse.fisheryharbour.utill.Navigation;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.net.URL;
import java.sql.SQLException;
import java.util.Properties;
import java.util.ResourceBundle;

public class NotPaidPopupFormController implements Initializable {
    public Text txtBoatId;
    public Text txtBoatName;
    public Text txtOwnerName;
    public Text txtDate;

    public void closeOnMouseClicked(MouseEvent mouseEvent) {
        TaxManageFormController.getInstance().innovativePopupPane.getChildren().clear();
        TaxManageFormController.getInstance().innovativePopupPane.setVisible(false);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BoatModel boatModel = new BoatModel();
        OwnerModel ownerModel = new OwnerModel();
        try {
            BoatDTO boatDTO = boatModel.getData(TaxManageFormController.getInstance().innovativeBoatId);
            OwnerDTO ownerDTO = ownerModel.getData(boatDTO.getOwner_Id());
            txtBoatId.setText(TaxManageFormController.getInstance().innovativeBoatId);
            txtBoatName.setText(boatDTO.getBoat_name());
            txtOwnerName.setText(ownerDTO.getFirst_Name()+" "+ownerDTO.getLast_Name());
            txtDate.setText(DateTimeUtil.dateNow());

            new Thread(()->{
                sendEmail(ownerDTO.getEmail());

            }).start();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sendEmail(String mail) {
        String to = mail;
        System.out.println("Process to Mail");
        String from = "fisheryharbourgalle@gmail.com";
        final String username = "fisheryharbourgalle";//change accordingly
        final String password = "lpgc tsgs amod foob";//change accordingly

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.host", "smtp.gmail.com");


        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Your Monthly Salary Statment");

            // This mail has 2 part, the BODY and the embedded image
            MimeMultipart multipart = new MimeMultipart("related");

            // first part (the html)
            BodyPart messageBodyPart = new MimeBodyPart();
            String htmlText = "<h1 style=\"color: deepskyblue;text-align: center;font-weight: bold\">FISHERY HARBOR GALLE</h1>\n" +
                    "<p style=\"text-align: center\">BDear Boat Owner ; It's noted that you haven't paid this month's Pierrer fee ... So please PAY your pierrer Fee as soon as possible to Galle fishery harbour office.\n" +
                    "<h1 style=\"font-size: 20px;text-align: center\">Thank you for Working with us ! </h1>";
            messageBodyPart.setContent(htmlText, "text/html");
            // add it
//            multipart.addBodyPart(messageBodyPart);

           /* // second part (the image)
            messageBodyPart = new MimeBodyPart();
            System.out.println("1");
            DataSource fds = new FileDataSource(
                    "/Users/sithumimesh/Documents/CustomerBill/CustomerBill" +salaryId+".pdf");

            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<pdf>");*/

//            MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//            String filename = "/Users/sithumimesh/Documents/mobileshopSalary/Salary" + salaryId + ".pdf";//change accordingly
//            DataSource source = new FileDataSource(filename);
//            messageBodyPart2.setDataHandler(new DataHandler(source));
//            messageBodyPart2.setFileName(filename);

            // add image to the multipart
//            multipart.addBodyPart(messageBodyPart);
//            multipart.addBodyPart(messageBodyPart2);

            // put everything together
            message.setContent(multipart);
            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
