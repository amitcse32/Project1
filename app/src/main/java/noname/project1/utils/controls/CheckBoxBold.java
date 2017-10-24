package noname.project1.utils.controls;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.TextView;

import noname.project1.utils.fonts.Fonts;

/**
 * Created by Amit on 9/25/2017.
 */

public class CheckBoxBold extends CheckBox{
    public CheckBoxBold(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setTypeface(Fonts.getBoldFont(context));
    }
}