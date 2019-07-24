package com.otema.examiner.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public boolean isValidPassword(final String password) {
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();

    }
}
