package Controller.containerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

import Controller.ReportDetailsController;
import Controller.ReportsController;

public class reportPaneController {

    @FXML
    private Text numberTicket;

    @FXML
    private Text nameItem;

    @FXML
    private Text typeTicket;

    @FXML
    private Text dateTicket;

    private String reportKey; // This will store the key associated with the report

    public void initialize() {
        // Initialize if needed
    }

    public void setNumberTicket(String numberTicketInput) {
        this.numberTicket.setText(numberTicketInput);
    }

    public void setNameItem(String nameItemInput) {
        this.nameItem.setText(nameItemInput);
    }

    public void setTypeTicket(String typeTicketInput) {
        this.typeTicket.setText(typeTicketInput);
    }

    public void setDateTicket(String dateTicketInput) {
        this.dateTicket.setText(dateTicketInput);
    }

    public void setReportKey(String key) {
        this.reportKey = key;
    }

    public String getReportKey() {
        return reportKey;
    }

    @FXML
    public void showDetails(MouseEvent event) {
        // Access the key associated with this report pane
        System.out.println("Clicked on report with key: " + reportKey);

        // Print all values associated with the reportKey
        if (ReportsController.reportValues.containsKey(reportKey)) {
            String[] reportData = ReportsController.reportValues.get(reportKey);
            System.out.println("Report Details:");
            System.out.println("Number Ticket: " + reportData[0]);
            System.out.println("Name Item: " + reportData[1]);
            System.out.println("Type Ticket: " + reportData[2]);
            System.out.println("Date Ticket: " + reportData[3]);
            System.out.println("Brand Model: " + reportData[4]);
            System.out.println("Condition: " + reportData[5]);
            System.out.println("Additional Comment: " + reportData[6]);

            ReportDetailsController.reportTitle = reportData[0];
            ReportDetailsController.equipmentType = reportData[1];
            ReportDetailsController.brandModel = reportData[4];
            ReportDetailsController.condition = reportData[5];
            ReportDetailsController.date = reportData[3];
            ReportDetailsController.additional_comment = reportData[6];

            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/ReportDetails.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            



        } else {
            System.out.println("Report data not found for key: " + reportKey);
        }

        
    }

}
