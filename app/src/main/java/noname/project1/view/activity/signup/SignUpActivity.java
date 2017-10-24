package noname.project1.view.activity.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import noname.project1.R;
import noname.project1.utils.controls.EditTextMedium;
import noname.project1.view.activity.base.BaseActivity;
import noname.project1.view.activity.signup.presenter.SignUpPresenter;
import noname.project1.view.activity.signup.presenter.StudentForm;
import noname.project1.view.activity.signup.view.SignUpView;
import noname.project1.view.activity.splash.SplashActivity;

public class SignUpActivity extends BaseActivity implements SignUpView {


    @BindView(R.id.editTextFirstName)
    EditTextMedium editTextFirstName;

    @BindView(R.id.editTextLastName)
    EditTextMedium editTextLastName;

    @BindView(R.id.editTextEmail)
    EditTextMedium editTextEmail;

    @BindView(R.id.editTextPassword)
    EditTextMedium editTextPassword;

    @BindView(R.id.editTextConfirmPassword)
    EditTextMedium editTextConfirmPassword;

    @BindView(R.id.editTextMobileNumber)
    EditTextMedium editTextMobileNumber;


    SignUpPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        presenter = new SignUpPresenter(this, this);


    }


    @OnClick(R.id.buttonSignUp)
    public void signUpButtonClick() {
        StudentForm form = new StudentForm();
        form.firstName = editTextFirstName.getText().toString();
        form.lastName = editTextLastName.getText().toString();
        form.mobileNumber = editTextMobileNumber.getText().toString();
        form.email = editTextEmail.getText().toString();
        form.password = editTextPassword.getText().toString();
        form.confirmPassword = editTextConfirmPassword.getText().toString();
        presenter.validateForm(form);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToastMessage(String message) {
        showToast_base(this, message, true);
    }

    @Override
    public void startProgressBar(String message) {
        showProgressBar_base(this, message);
    }

    @Override
    public void endProgressBar() {
        endProgressBar_base(this);
    }

    @Override
    public void setFocus(String flag) {
        if (flag.equals("FNAME")) {
            editTextFirstName.requestFocus();
        }
        if (flag.equals("LNAME")) {
            editTextLastName.requestFocus();
        }
        if (flag.equals("MOB")) {
            editTextMobileNumber.requestFocus();
        }
        if (flag.equals("EMAIL")) {
            editTextEmail.requestFocus();
        }
        if (flag.equals("PASS")) {
            editTextPassword.requestFocus();
        }
        if (flag.equals("CPASS")) {
            editTextConfirmPassword.requestFocus();
        }

    }

    @Override
    public void registrationComplete() {
        startActivity(new Intent(this, SplashActivity.class));
        finish();
    }
}
