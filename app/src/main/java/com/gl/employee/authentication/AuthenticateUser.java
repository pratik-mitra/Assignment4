package com.gl.employee.authentication;


import android.util.Log;

import com.gl.employee.model.Admin;

public class AuthenticateUser {

    private static Admin superAdmin = new Admin("Admin", "Admin123");
    public static boolean isValidUser(Admin user) {

        Log.d("Admin password is::::",superAdmin.getPassWord());
        Log.d("Admin username is::::",superAdmin.getUserName());
        if(user.getUserName().equals(superAdmin.getUserName()) && user.getPassWord().equals(superAdmin.getPassWord()))
            return true;
        else
            return false;
    }
    public static void changePassword(String newPassword) {

        Log.i("pass here is:::",newPassword);
        superAdmin.setPassWord(newPassword);
        Log.i("new pass is :::", superAdmin.getPassWord());
    }
}
