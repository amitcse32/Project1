package noname.project1.view.activity.signin.presenter;

import noname.project1.model.props.loginuser.LoginResponse;

/**
 * Created by Amit on 10/12/2017.
 */

public interface LoginHandler {

    void success(LoginResponse response);

    void fail(String message);
}
