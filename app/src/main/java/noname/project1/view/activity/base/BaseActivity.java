package noname.project1.view.activity.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import noname.project1.R;

/**
 * Created by Amit on 9/25/2017.
 */

public class BaseActivity extends AppCompatActivity {


    public void showToast_base(Activity activity, String message, boolean isShort) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View layoutView = inflater.inflate(R.layout.view_base_toast, null);
        TextView textViewMessage = (TextView) layoutView.findViewById(R.id.textViewMessage);
        textViewMessage.setText(message);

        Toast toast = new Toast(activity);
        if (isShort == true) {
            toast.setDuration(Toast.LENGTH_SHORT);
        } else {
            toast.setDuration(Toast.LENGTH_LONG);
        }
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setView(layoutView);
        toast.show();

    }


    public void showAlertMessage_base(Context context, String message) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setPositiveButton(R.string.OK, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();

    }


    ProgressDialog dialog;

    public void showProgressBar_base(Context context, String message) {
        dialog = new ProgressDialog(context);
        dialog.setMessage(message);
        dialog.setCancelable(false);
        dialog.show();

    }

    public void endProgressBar_base(Context context) {

        dialog.dismiss();

    }


}
