package com.example.marto.my_school_revierwer_4;

import android.content.SharedPreferences;

/**
 * Created by marto on 04-Apr-17.
 */

public class SessionManager {

 public static final String HTTP = "http://192.168.43.102/";
    // Below are parts for the reviewer login and reviewer signin
   public static  SharedPreferences pref;
    public static final String preferences = "rev_pref";
    public static final String rev_email = "email_key";
    public  static final String rev_pass = "pass_key";

    // BELOW ARE KEYS USED FOR INSTITUTION LOGIN  AND INSTITUTION SIGNUP
    public static  SharedPreferences PREF_INSTI;
    public static final String pref_insti = "insti_pref";
    public static final String INSTI_INDEX = "index_key";
    public static final String INSTI_EMAIL = "insti_email";
    public static final String INSTI_PASS = "pass_key";


}
