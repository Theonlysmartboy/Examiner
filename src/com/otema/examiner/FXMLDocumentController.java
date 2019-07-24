package com.otema.examiner;

import com.otema.examiner.resources.animation.FadeTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 *
 * @author TheOnlySmartBoy
 */
public class FXMLDocumentController implements Initializable {

    private Task copyWorker;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private ProgressIndicator progressIndicator;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        progressBar.setProgress(0);
        progressIndicator.setProgress(0);
        copyWorker = createWorker();
        progressBar.progressProperty().unbind();
        progressIndicator.progressProperty().unbind();
        progressBar.progressProperty().bind(copyWorker.progressProperty());
        progressIndicator.progressProperty().bind(copyWorker.progressProperty());
        FadeTransition.applyFadeTransition(rootPane, Duration.seconds(5), (e) -> {

            new Thread(copyWorker).start();
        });

    }

    private Task createWorker() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i <= 10; i++) {
                    Thread.sleep(1000);
                    updateProgress(i + 1, 10);
                    if (progressIndicator.getProgress() == 1.0) {
                        Platform.runLater(() -> {
                            try {
                                Parent root = FXMLLoader.load(getClass().getResource("/com/otema/examiner/auth/Login.fxml"));
                                rootPane.getChildren().removeAll();
                                rootPane.getChildren().setAll(root);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        });
                    }
                }
                return true;
            }
        };
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
