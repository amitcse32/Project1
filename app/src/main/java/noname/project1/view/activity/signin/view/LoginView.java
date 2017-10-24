package noname.project1.view.activity.signin.view;

import noname.project1.model.props.loginuser.LoginResponse;

/**
 * Created by Amit on 10/12/2017.
 */

public interface LoginView {


    void showToastMessage(String message);

    void onLoginSuccess(LoginResponse loginResponse);

    void showProgressBar(String message);

    void endProgressBar();


}
