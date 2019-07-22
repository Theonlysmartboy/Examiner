package com.otema.examiner.resources.db;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheOnlySmartBoy
 */
public class RestoreDb {

    public void restore() {
        try {
            /**
             * ***************************************************
             */
//Database Properties
            /**
             * ***************************************************
             */
            String dbName = "dbName";
            String dbUser = "dbUser";
            String dbPass = "dbPass";

            /**
             * ********************************************************
             */
// Execute Shell Command
            /**
             * ********************************************************
             */
            String executeCmd = "";

            executeCmd = "/bin/sh" + "-c" + "mysql -u" + dbUser + " -p" + dbPass + " " + dbName + " < backup.sql";

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0) {

                System.out.println("success");

            } else {

                System.out.println("restore failure");

            }
        } catch (IOException ex) {
            Logger.getLogger(RestoreDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RestoreDb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
