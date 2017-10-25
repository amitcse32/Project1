package noname.project1.view.activity.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import noname.project1.R;
import noname.project1.utils.AppPrefrence;
import noname.project1.view.activity.base.BaseActivity;
import noname.project1.view.activity.signin.LoginActivity;
import noname.project1.view.activity.signup.SignUpActivity;
import noname.project1.view.activity.splash.presenter.SplashPresenter;
import noname.project1.view.activity.splash.view.SplashView;
import noname.project1.view.activity.welcome.WelcomeActivity;

public class SplashActivity extends BaseActivity implements SplashView {


    SplashPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        presenter = new SplashPresenter(this, this);


    }

    @Override
    protected void onPause() {
        presenter.setSplashOnOff(false);
        super.onPause();
    }

    @Override
    protected void onResume() {
        presenter.setSplashOnOff(true);
        presenter.startSplash();
        super.onResume();
    }

    @Override
    public void onSplashComplete() {

        String value = AppPrefrence.getString(AppPrefrence.USER_ID, this);
        if (value.length() > 0) {
            startActivity(new Intent(this, WelcomeActivity.class));
            finish();
        } else {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }
    }

    @Override
    public void showToastMessage(String message) {
        showAlertMessage_base(this, message);
    }

    @Override
    public void showAlertMessage(String message) {

    }
}
