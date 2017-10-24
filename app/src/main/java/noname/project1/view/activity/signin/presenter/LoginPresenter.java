package noname.project1.view.activity.signin.presenter;

import android.content.Context;

import noname.project1.model.props.loginuser.LoginResponse;
import noname.project1.model.web_connection.WebConnection;
import noname.project1.utils.Validations;
import noname.project1.view.activity.signin.view.LoginView;

/**
 * Created by Amit on 10/12/2017.
 */

public class LoginPresenter implements LoginHandler {

    LoginView loginView;
    Context context;

    public LoginPresenter(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
    }

    public void doLoginRequest(String email, String password, String deviceToken) {

        if (Validations.isFieldEmpty(email)) {
            loginView.showToastMessage("Please enter email");
        } else if (!Validations.emailValid(email)) {
            loginView.showToastMessage("Please enter valid email");
        } else if (Validations.isFieldEmpty(password)) {
            loginView.showToastMessage("Please enter password");
        } else {
            loginView.showProgressBar("Authenticating....");
            WebConnection.loginStudent(email, password, deviceToken, this);
        }

    }

    @Override
    public void success(LoginResponse response) {
        loginView.endProgressBar();
        if (response != null) {
            if (response.getResult().getStatus().equals("1")) {
                loginView.onLoginSuccess(response);
            } else {
                loginView.showToastMessage("Wrong username or password!");

            }
        } else {
            loginView.showToastMessage("Wrong username or password!");
        }
    }

    @Override
    public void fail(String message) {
        loginView.endProgressBar();
        loginView.showToastMessage("Unable to authenticate this user");
    }
}
