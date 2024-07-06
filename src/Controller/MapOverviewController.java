package Controller;

import java.io.IOException;
import java.util.Map;
import javafx.event.ActionEvent;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MapOverviewController {
    @FXML
    Text school, address, number;

    @FXML
    Pane paneReportLocation, reportLocationPane2;

    @FXML
    Text numberTicket, nameItem, typeTicket, dateTicket, statusTicket, numberTicket1, nameItem1, typeTicket1, dateTicket1, statusTicket1;

    static boolean isClicked = false;

    @FXML
    public void initialize() {
        paneReportLocation.setOnMouseClicked(this::handleReverseAnimations);
        reportLocationPane2.setOnMouseClicked(this::handleReverseAnimations);

        // ReportsController reportsController = new ReportsController();
        // Map<String, String[]> firstTwoReports = reportsController.getFirstTwoReports();

        // int index = 0;
        // for (Map.Entry<String, String[]> entry : firstTwoReports.entrySet()) {
        //     String[] values = entry.getValue();
        //     if (index == 0) {
        //         numberTicket.setText(values[0]);
        //         nameItem.setText(values[1]);
        //         typeTicket.setText(values[2]);
        //         dateTicket.setText(values[3]);
        //         statusTicket.setText(values[4]);
        //     } else if (index == 1) {
        //         numberTicket1.setText(values[0]);
        //         nameItem1.setText(values[1]);
        //         typeTicket1.setText(values[2]);
        //         dateTicket1.setText(values[3]);
        //         statusTicket1.setText(values[4]);
        //     }
        //     index++;
        }
    

    public void showReportLocation() {
        school.setText("Manila Science High School");
        address.setText("Taft Ave, Ermita, Manila, 1000 Metro Manila");
        number.setText("8-525-6197");
        if (!isClicked) {
            isClicked = true;
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));
            transition.setNode(paneReportLocation);
            transition.setByY(-200); // Move up
            transition.play();
            showReportLocation2();
        }
    }

    public void showReportLocation2() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(reportLocationPane2);
        transition.setByY(-400); // Move up
        transition.play();
    }

    public void showReportLocation3() {
        school.setText("Manila High School");
        address.setText("Arroceros St, Ermita, Manila, 1000 Metro Manila");
        number.setText("8-406-1611");
        if (!isClicked) {
            isClicked = true;
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));
            transition.setNode(paneReportLocation);
            transition.setByY(-200); // Move up
            transition.play();
            showReportLocation4();
        }
    }

    public void showReportLocation4() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(reportLocationPane2);
        transition.setByY(-400); // Move up
        transition.play();
    }

    public void showReportLocation5() {
        school.setText("Ramon Magsaysay High School");
        address.setText("E. Rodriguez Sr. Ave, Quezon City, 1112 Metro Manila");
        number.setText("8-716-7832");
        if (!isClicked) {
            isClicked = true;
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));
            transition.setNode(paneReportLocation);
            transition.setByY(-200); // Move up
            transition.play();
            showReportLocation6();
        }
    }

    public void showReportLocation6() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(reportLocationPane2);
        transition.setByY(-400); // Move up
        transition.play();
    }

    public void showReportLocation7() {
        school.setText("Tondo High School");
        address.setText("Juan Luna St, Tondo, Manila, 1012 Metro Manila");
        number.setText("8-251-3371");
        if (!isClicked) {
            isClicked = true;
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));
            transition.setNode(paneReportLocation);
            transition.setByY(-200); // Move up
            transition.play();
            showReportLocation8();
        }
    }

    public void showReportLocation8() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(reportLocationPane2);
        transition.setByY(-400); // Move up
        transition.play();
    }

    private void handleReverseAnimations(MouseEvent event) {
        if (isClicked) {
            TranslateTransition transition = new TranslateTransition();
            transition.setDuration(Duration.seconds(1));
            transition.setNode(paneReportLocation);
            transition.setByY(200); // Move back down to original position
            transition.play();

            TranslateTransition transition2 = new TranslateTransition();
            transition2.setDuration(Duration.seconds(2));
            transition2.setNode(reportLocationPane2);
            transition2.setByY(400); // Move back down to original position
            transition2.play();

            isClicked = false; // Reset flag after reversing animations
        }
    }

    public void gotoHomepage(ActionEvent event) throws IOException {
        isClicked = false;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Homepage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void gotoReports(ActionEvent event) throws IOException {
        isClicked = false;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Reports.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
