package Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Controller.containerController.reportPaneController;

public class ReportsController {

    @FXML
    private Pane addReportPane;

    @FXML
    private ScrollPane scrollPaneHistory;

    @FXML
    private VBox scrollContent; // This matches the fx:id in Reports.fxml

    public static Map<String, String[]> reportValues = new HashMap<>();

    @FXML
    void initialize() {
        // Initialize the dictionary with report values
        reportValues.put("1", new String[]{"#01", "Broken Tablet Unit", "Equipment", "July 27, 2019", "Samsung Galaxy Tab S6", "Cracked screen", "This tablet was dropped during use."});
        reportValues.put("2", new String[]{"#02", "Leaking Pipe", "Infrastructure", "August 14, 2021", "Generic Pipe", "Leaking at the joint", "The pipe has been leaking for two days."});
        reportValues.put("3", new String[]{"#03", "Power Outage", "Utilities", "December 05, 2022", "N/A", "Complete outage", "There was a power outage in the entire building."});
        reportValues.put("4", new String[]{"#04", "Broken Window", "Infrastructure", "January 12, 2023", "Double-pane glass", "Shattered", "A tree branch broke the window during a storm."});
        reportValues.put("5", new String[]{"#05", "Broken Chair", "Equipment", "February 20, 2023", "Office Chair", "Leg broken", "The leg of the chair broke off."});
        reportValues.put("6", new String[]{"#06", "Broken Door", "Infrastructure", "March 30, 2023", "Wooden door", "Hinges damaged", "The door does not close properly."});
        reportValues.put("7", new String[]{"#07", "Broken Computer", "Equipment", "April 10, 2023", "Dell Inspiron", "Not turning on", "The computer won't power on."});
        reportValues.put("8", new String[]{"#08", "Broken Light Bulb", "Utilities", "May 15, 2023", "LED Bulb", "Burned out", "The light bulb in room 101 is not working."});
        reportValues.put("9", new String[]{"#09", "Broken Printer", "Equipment", "June 20, 2023", "HP LaserJet", "Paper jam", "The printer keeps jamming paper."});
        reportValues.put("10", new String[]{"#10", "Broken Chair", "Equipment", "July 25, 2023", "Conference Chair", "Seat cushion torn", "The seat cushion is ripped."});
        reportValues.put("11", new String[]{"#11", "Broken Window", "Infrastructure", "August 30, 2023", "Single-pane glass", "Cracked", "A baseball cracked the window."});
        reportValues.put("12", new String[]{"#12", "Broken Computer", "Equipment", "September 05, 2023", "MacBook Pro", "Battery not charging", "The battery does not hold a charge."});

        // Load the reports into the scroll pane
        loadReports();
    }

    @FXML
    void gotoAddReport(ActionEvent event) {
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

    @FXML
    void gotoHomepage(ActionEvent event) {
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

    private void loadReports() {
        scrollContent.getChildren().clear();
        // Set spacing between items in the VBox
        scrollContent.setSpacing(10);

        // Sort the report values by key numerically
        Map<String, String[]> sortedReportValues = reportValues.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        HashMap::new
                ));

        try {
            for (String key : sortedReportValues.keySet()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/container/reportPane.fxml"));
                Parent reportPane = loader.load();

                reportPaneController controller = loader.getController();
                String[] values = sortedReportValues.get(key);
                controller.setNumberTicket(values[0]);
                controller.setNameItem(values[1]);
                controller.setTypeTicket(values[2]);
                controller.setDateTicket(values[3]);

                // Set the key for this report pane
                controller.setReportKey(key);

                scrollContent.getChildren().add(reportPane);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
