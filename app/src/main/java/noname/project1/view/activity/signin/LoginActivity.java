package noname.project1.view.activity.signin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import noname.project1.R;
import noname.project1.model.props.loginuser.LoginResponse;
import noname.project1.utils.AppPrefrence;
import noname.project1.utils.controls.ButtonMedium;
import noname.project1.utils.controls.EditTextMedium;
import noname.project1.view.activity.base.BaseActivity;
import noname.project1.view.activity.signin.presenter.LoginPresenter;
import noname.project1.view.activity.signin.view.LoginView;
import noname.project1.view.activity.signup.SignUpActivity;
import noname.project1.view.activity.welcome.WelcomeActivity;

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.editTextEmail)
    EditTextMedium editTextEmail;

    @BindView(R.id.editTextPassword)
    EditTextMedium editTextPassword;

    @BindView(R.id.buttonLogin)
    ButtonMedium buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonLogin)
    public void onLoginButtonClick() {
        LoginPresenter presenter = new LoginPresenter(this, this);
        presenter.doLoginRequest(editTextEmail.getText().toString(), editTextPassword.getText().toString(), "DEVICE TOEKEN");
    }


    @OnClick(R.id.textView)
    public void onRegisterButtonClick() {
        startActivity(new Intent(this, SignUpActivity.class));
    }


    @Override
    public void showToastMessage(String message) {
        showToast_base(this, message, false);
    }

    @Override
    public void onLoginSuccess(LoginResponse loginResponse) {
        buttonLogin.setBackgroundResource(R.drawable.button_universal_success);

        //Shared
        AppPrefrence.setString(AppPrefrence.USER_ID, loginResponse.getResult().getId(), this);
        startActivity(new Intent(this, WelcomeActivity.class));
        finish();
    }

    @Override
    public void showProgressBar(String message) {
        showProgressBar_base(this, message);
    }

    @Override
    public void endProgressBar() {
        endProgressBar_base(this);
    }
}
