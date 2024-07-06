package Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

public class LoginController {
    @FXML
    private ImageView image1;

    @FXML
    private MediaView mediaView;

    @FXML
    TextField usernameField;

    @FXML
    PasswordField passwordField;

    @FXML
    public Text errorText;

    public void initialize() {
        usernameField.setText("schooladmin@gmail.com");
        passwordField.setText("admin123!@#");

    }
    public void login(ActionEvent event) throws IOException {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();
;

        if (username.equals("schooladmin@gmail.com") && password.equals("admin123!@#")) {

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/View/Homepage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            errorText.setVisible(true);
        }
    }
}
