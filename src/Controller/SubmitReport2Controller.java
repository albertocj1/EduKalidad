package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SubmitReport2Controller {

    @FXML
    Button backToSubmit1Btn;

    static String reportTitle, equipmentType, brandModel, condition, date;
    String additional_comment;

    @FXML
    TextArea addi_cmnt_ta;

    public void initialize() {
        addi_cmnt_ta.setText("The Device won't turn on. I tried to plug it in but it still won't turn on.");
    }

    public void setReportData(String title, String type, String model, String cond, String dateValue) {
        reportTitle = title;
        equipmentType = type;
        brandModel = model;
        condition = cond;
        date = dateValue;
    }

    public void goBackToSubmit1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SubmitReport1.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void submit_entry(ActionEvent event) {
        additional_comment = addi_cmnt_ta.getText();
        
        // Generate a new key for the report
        String newKey = String.valueOf(ReportsController.reportValues.size() + 1);

        // Save the report in the ReportsController's dictionary
        ReportsController.reportValues.put(newKey, new String[]{
            "#"+newKey, reportTitle, equipmentType, date,brandModel, condition, additional_comment
        }); // equipmentType

        System.out.println("Report Title: " + reportTitle);
        System.out.println("Equipment Type: " + equipmentType);
        System.out.println("Brand Model: " + brandModel);
        System.out.println("Condition: " + condition);
        System.out.println("Date: " + date);
        System.out.println("Additional Comment: " + additional_comment);

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SubmitReport3.fxml"));
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
