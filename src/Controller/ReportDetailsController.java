package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ReportDetailsController {
    
    @FXML
    ImageView imageHolder;

    public static String reportTitle;

    public static String equipmentType;

    public static String brandModel;

    public static String condition;

    public static String date;

    public static String additional_comment;

    @FXML
    Button exitBtn;

    @FXML
    Text reportIDTxt, itemTypeTxt, statusTxt, equipmentTypeTxt, brandModelTxt, dateTxt, dateReportedTxt, conditionTxt, additionalCommentTxt;
    
    public void initialize() {
        // Set the text
        reportIDTxt.setText(reportTitle);
        itemTypeTxt.setText(equipmentType);
        statusTxt.setText("Assessing");
        equipmentTypeTxt.setText(equipmentType);
        brandModelTxt.setText(brandModel);
        dateTxt.setText(date);
        dateReportedTxt.setText(date);
        conditionTxt.setText(condition);
        additionalCommentTxt.setText(additional_comment);
        
        // Set the image
        if (equipmentType.equals("Tech Equipment")) {
            imageHolder.setImage(new Image(getClass().getResourceAsStream("/Icons/3 - Report Details (Equipment).png")));
        } else {
            imageHolder.setImage(new Image(getClass().getResourceAsStream("/Icons/3 - Report Details (Learning Resource).png")));
        }
    }

    public void goToExit(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Homepage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
