package noname.project1.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Amit on 10/25/2017.
 */

public class AppPrefrence {

     static String PREF_NAME="test_amit_project";


    public static String USER_ID="USER_ID";



    public static void setString(String key,String value, Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_NAME,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }

    public static String getString(String key, Context context)
    {
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_NAME,0);
        String value=sharedPreferences.getString(key,"");
        return value;

    }

}
