package noname.project1.view.activity.signup.presenter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import noname.project1.R;
import noname.project1.model.props.registeruser.RegisterResponse;
import noname.project1.model.web_connection.WebConnection;
import noname.project1.utils.Validations;
import noname.project1.view.activity.signup.SignUpActivity;
import noname.project1.view.activity.signup.view.SignUpView;

/**
 * Created by Amit on 9/26/2017.
 */

public class SignUpPresenter implements SignUpHandler {

    Context context;
    SignUpView view;

    public SignUpPresenter(Context context, SignUpView signUpView) {
        this.context = context;
        this.view = signUpView;
    }

    public void validateForm(StudentForm form) {


        if (Validations.isFieldEmpty(form.firstName)) {
            view.showToastMessage(context.getString(R.string.enter_first_name));
            view.setFocus("FNAME");
        } else if (Validations.isFieldEmpty(form.lastName)) {
            view.showToastMessage(context.getString(R.string.enter_last_name));
            view.setFocus("LNAME");
        } else if (Validations.isFieldEmpty(form.mobileNumber)) {
            view.showToastMessage(context.getString(R.string.enter_mobile_number));
            view.setFocus("MOB");
        } else if (Validations.isFieldEmpty(form.email)) {
            view.showToastMessage(context.getString(R.string.enter_email));
            view.setFocus("EMAIL");
        } else if (!Validations.emailValid(form.email)) {
            view.showToastMessage(context.getString(R.string.enter_valid_email));
            view.setFocus("EMAIL");
        } else if (Validations.isFieldEmpty(form.password)) {
            view.showToastMessage(context.getString(R.string.enter_password));
            view.setFocus("PASS");
        } else if (Validations.isFieldEmpty(form.confirmPassword)) {
            view.showToastMessage(context.getString(R.string.enter_confirm_password));
            view.setFocus("CPASS");
        } else if (!Validations.stringCompare(form.password, form.confirmPassword)) {
            view.showToastMessage(context.getString(R.string.enter_confirm_password));
            view.setFocus("CPASS");

        } else {
            view.startProgressBar(context.getString(R.string.loading));
            WebConnection.registerStudent(form, this);
        }
    }

    @Override
    public void success(RegisterResponse response) {
        view.endProgressBar();
        if (response != null) {

            if (response.getResult().getStatus().equals("1")) {
                view.showToastMessage("Welcome to portal!");
                view.registrationComplete();
            } else if (response.getResult().getStatus().equals("-1")) {
                view.showToastMessage("Unable to connect with portal server!");
            } else if (response.getResult().getStatus().equals("-2")) {
                view.showToastMessage("Please check you email \n This email already exist!");
            }

        } else {
            view.showToastMessage("Unable to register!\nPlease try again");
        }
    }

    @Override
    public void fail(String message) {
        view.endProgressBar();
        view.showToastMessage("Unable to register!\nPlease try again");
    }
}
