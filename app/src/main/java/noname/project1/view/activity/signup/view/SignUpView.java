package noname.project1.view.activity.signup.view;

/**
 * Created by Amit on 9/26/2017.
 */

public interface SignUpView {

    void showToastMessage(String message);
    void startProgressBar(String message);
    void endProgressBar();
    void setFocus(String flag);

    void registrationComplete();
}
