package com.otema.examiner.auth;

import com.jfoenix.controls.JFXButton;
import com.otema.examiner.FXMLDocumentController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
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
    @FXML
    private TextField uemail;
    @FXML
    private JFXButton submit;
    private String email;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                email = uemail.getText();
                if ("".equals(uemail.getText())) {
                    Object[] options = {"Try again", "Cancel"};
                    int n = JOptionPane.showOptionDialog(null, "Email required ", "Reset Password", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (n == JOptionPane.YES_OPTION) {
                        
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
        });

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
