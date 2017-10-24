package noname.project1.utils.fonts;

import android.content.Context;
import android.graphics.Typeface;

/**
 * Created by Amit on 9/25/2017.
 */

public class Fonts {

   public static  Typeface getBoldFont(Context context)
    {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/calibrib.ttf");
        return font;

    }

    public static Typeface getMediumFont(Context context)
    {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/calibri.ttf");
        return font;
    }

    public static  Typeface getLightFont(Context context)
    {
        Typeface font = Typeface.createFromAsset(context.getAssets(), "fonts/calibril.ttf");
        return font;
    }


}
