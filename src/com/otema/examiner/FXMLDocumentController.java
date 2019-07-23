/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.otema.examiner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 *
 * @author TheOnlySmartBoy
 */
public class FXMLDocumentController implements Initializable {

    private Label label;
    @FXML
    private AnchorPane root;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void closeApp(MouseEvent event) {
        //Check for and handle accidental opening and clossing for app
        Object[] options = {"Yes", "No"};
        int n = JOptionPane.showOptionDialog(null, "Do you want to Exit the System? ", "Examiner", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {

        }
    }

}
