package com.xseed.dx.parent.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Manvendra Sah on 15/07/17.
 */

public class Utils {

    private static Float scale;
    private static int deviceWidth;
    private static int deviceHeight;

    public static int dpToPixel(int dp, Context context) {
        if (scale == null)
            scale = context.getResources().getDisplayMetrics().density;
        return (int) ((float) dp * scale);
    }

    public static int dpToPixel(int dimenId, Context context, boolean alwaysTrue) {
        if (scale == null)
            scale = context.getResources().getDisplayMetrics().density;
        float dimen = context.getResources().getDimension(dimenId);
        return (int) (dimen * scale);
    }

    public static int getDeviceWidthInPixel(Context context) {

        if (deviceWidth == 0)
            deviceWidth = context.getResources().getDisplayMetrics().widthPixels;
        return deviceWidth;
    }

    public static int getDeviceHeightInPixel(Context context) {

        if (deviceHeight == 0)
            deviceHeight = context.getResources().getDisplayMetrics().heightPixels;
        return deviceHeight;
    }

    /**
     * @param context - takes context as argument
     *                This method checks is device whether connected to internet or not
     */
    public static boolean isNetworkConnected(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        // should check null because in air plan mode it will be null
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;

    }

    /*
   * validate email
   * */
    public static boolean isValidEmail(String email) {
        boolean isValid = false;

        //String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        String expression = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /*
  * validate phone
  * */
    public static boolean isValidPhone(String phone) {
        if (TextUtils.isEmpty(phone))
            return false;
    /*
    * validate phone number
    * The length of the phone number ranges from 7 to 15  as because different countries may have
    * different length of phone number.
    * */
        String Regex = "[^\\d]";
        String PhoneDigits = phone.replaceAll(Regex, "");
        boolean isLengthValid = PhoneDigits.length() >= 7;
        if (isLengthValid) {
            // check if string consists only of zeroes
            String phoneStr = phone.trim();
            int len = phoneStr.length();
            int zeroes = 0;
            for (int i = 0; i < len; ++i) {
                char c = phoneStr.charAt(i);
                if (c == '0')
                    zeroes++;
            }
            if (zeroes == len)
                return false;
            else return true;
        } else
            return false;
    }
}
