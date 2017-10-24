package noname.project1.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by Amit on 9/25/2017.
 */

public class Validations {

    public static boolean isInternetAvailable(Context context) {
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    //
    public static boolean isFieldEmpty(String field) {
        if (field.trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean stringCompare(String value1, String value2) {
        if (value1.equals(value2)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean emailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
