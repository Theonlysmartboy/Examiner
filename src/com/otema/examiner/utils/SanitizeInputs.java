package com.otema.examiner.utils;

/**
 *
 * @author TheOnlySmartBoy
 */
public class SanitizeInputs {

    public static boolean isValidEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        boolean valid = false;
        if (email.matches(regex)) {
            valid = true;
        }
        return valid;
    }

}
