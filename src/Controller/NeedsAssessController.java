package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NeedsAssessController {

    @FXML
    private Pane addAssess, genInfo, step2, step3, step4, submit, history;

    @FXML
    void gotoGenInfo(ActionEvent event) {
        genInfo.setVisible(true);
        addAssess.setVisible(false);
        step2.setVisible(false);
        step3.setVisible(false);
        step4.setVisible(false);
        submit.setVisible(false);
        history.setVisible(false);
    }

    @FXML
    void gotoStep2(ActionEvent event) {
        genInfo.setVisible(false);
        addAssess.setVisible(false);
        step2.setVisible(true);
        step3.setVisible(false);
        step4.setVisible(false);
        submit.setVisible(false);
        history.setVisible(false);
    }

    @FXML
    void gotoStep3(ActionEvent event) {
        genInfo.setVisible(false);
        addAssess.setVisible(false);
        step2.setVisible(false);
        step3.setVisible(true);
        step4.setVisible(false);
        submit.setVisible(false);
        history.setVisible(false);
    }

    @FXML
    void gotoStep4(ActionEvent event) {
        genInfo.setVisible(false);
        addAssess.setVisible(false);
        step2.setVisible(false);
        step3.setVisible(false);
        step4.setVisible(true);
        submit.setVisible(false);
        history.setVisible(false);
    }

    @FXML
    void gotoSubmit(ActionEvent event) {
        genInfo.setVisible(false);
        addAssess.setVisible(false);
        step2.setVisible(false);
        step3.setVisible(false);
        step4.setVisible(false);
        submit.setVisible(true);
        history.setVisible(false);
    }

    @FXML
    void gotoHistory(ActionEvent event) {
        genInfo.setVisible(false);
        addAssess.setVisible(false);
        step2.setVisible(false);
        step3.setVisible(false);
        step4.setVisible(false);
        submit.setVisible(false);
        history.setVisible(true);
    }

    @FXML
    public void gotoHomepage(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Homepage.fxml"));
        Parent root = loader.load();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    
}
