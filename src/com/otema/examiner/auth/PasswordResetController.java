package com.otema.examiner.auth;

import com.otema.examiner.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author TheOnlySmartBoy
 */
public class PasswordResetController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    static boolean isValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    @FXML
    private void closeApp(MouseEvent event) {
        //Check for and handle accidental opening and clossing for app
        Object[] options = {"Yes", "No"};
        int n = JOptionPane.showOptionDialog(null, "Do you want to Exit the System? ", "Reset Password", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                rootPane.getChildren().removeAll();
                rootPane.setMinSize(700.0, 400.0);
                rootPane.getChildren().setAll(root);

            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
