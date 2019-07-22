package com.otema.examiner.resources.db;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TheOnlySmartBoy
 */
public class BackupDb {

    public static void backup() {
        String dbName = "dbName";
        String dbUser = "dbUser";
        String dbPass = "dbPass";
        try {
            String executeCmd = "";
            executeCmd = "mysqldump -u" + dbUser + "-p" + dbPass + "" + dbName + " -r backup.sql";

            Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
            int processComplete = 0;
            try {
                processComplete = runtimeProcess.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(RestoreDb.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (processComplete == 0) {

                System.out.println(
                        "Backup taken successfully");

            } else {

                System.out.println(
                        "Could not take mysql backup");

            }

        } catch (IOException ex) {
            Logger.getLogger(RestoreDb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
