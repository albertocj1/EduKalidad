package Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class SubmitReport1Controller {

    @FXML
    TextField reportTitleTF, equipmentTypeTF, brandModelTF, conditionTF;

    @FXML
    Button toSubmit2Btn, backToHomeBtn;    

    @FXML
    DatePicker dateTF;

    @FXML
    ImageView imagebg;

    @FXML
    RadioButton rb1, rb2;

    private Image techEquipmentImage;
    private Image learningResourcesImage;

    String reportTitle, equipmentType, brandModel, condition, date;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM dd, yyyy");

    public void initialize() {
        // Load images
        techEquipmentImage = new Image(getClass().getResourceAsStream("/Icons/3 - Submit Report (Tech Equipment) (2).png"));
        learningResourcesImage = new Image(getClass().getResourceAsStream("/Icons/3 - Submit Report (Learning Resources).png"));
        
        // Set initial selection
        rb1.setSelected(true);
        imagebg.setImage(techEquipmentImage);

        reportTitleTF.setText("Broken Projector");
        equipmentTypeTF.setText("Equipment");
        brandModelTF.setText("LG");
        conditionTF.setText("Not working properly");
        dateTF.setValue(LocalDate.now()); // Set current date as default

        // Add listener to radio buttons
        rb1.setOnAction(event -> selectedRb());
        rb2.setOnAction(event -> selectedRb());
    }

    public void saveMethod() {
        reportTitle = reportTitleTF.getText();
        equipmentType = equipmentTypeTF.getText();
        brandModel = brandModelTF.getText();
        condition = conditionTF.getText();
        LocalDate selectedDate = dateTF.getValue();
        date = selectedDate != null ? selectedDate.format(DATE_FORMATTER) : "";

        SubmitReport2Controller.reportTitle = reportTitle;
        SubmitReport2Controller.equipmentType = equipmentType;
        SubmitReport2Controller.brandModel = brandModel;
        SubmitReport2Controller.condition = condition;
        SubmitReport2Controller.date = date;
    }

    public void selectedRb() {
        if (rb1.isSelected()) {
            rb2.setSelected(false);
            imagebg.setImage(techEquipmentImage);
        } else if (rb2.isSelected()) {
            rb1.setSelected(false);
            imagebg.setImage(learningResourcesImage);
        }
    }

    public void goToSubmit2(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/SubmitReport2.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            saveMethod();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToHome() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/Homepage.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) backToHomeBtn.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
