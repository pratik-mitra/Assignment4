package com.gl.employee.validation;

public class FieldValidation {

    public static boolean isValidatePasswordEntry(String newPassword, String reNewPassword) {

        if(newPassword.equals(reNewPassword))
            return true;
        else
            return false;
    }
}
