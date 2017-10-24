package noname.project1.view.activity.signup.presenter;

import noname.project1.model.props.registeruser.RegisterResponse;

/**
 * Created by Amit on 10/10/2017.
 */

public interface SignUpHandler {
    void success(RegisterResponse response);
    void fail(String message);
}
