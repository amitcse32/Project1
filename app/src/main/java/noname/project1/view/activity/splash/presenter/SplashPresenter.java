package noname.project1.view.activity.splash.presenter;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;

import noname.project1.R;
import noname.project1.utils.Validations;
import noname.project1.view.activity.splash.view.SplashView;

/**
 * Created by Amit on 9/25/2017.
 */

public class SplashPresenter {

    Context context;
    SplashView view;
    boolean isSplashOn = false;

    public final int SPLASH_DURATION = 3000;


    public SplashPresenter(Context context, SplashView view) {
        this.context = context;
        this.view = view;
    }

    public void startSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isSplashOn == true) {
                    if (Validations.isInternetAvailable(context)) {
                        view.onSplashComplete();
                    } else {
                        view.showToastMessage(context.getString(R.string.no_internet_connection));
                    }
                }
            }
        }, SPLASH_DURATION);
    }

    public void setSplashOnOff(boolean onOrOff) {
        isSplashOn = onOrOff;
    }
}
