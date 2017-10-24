package noname.project1.model.web_connection;

import noname.project1.model.props.loginuser.LoginResponse;
import noname.project1.model.props.registeruser.RegisterResponse;
import noname.project1.view.activity.signin.presenter.LoginHandler;
import noname.project1.view.activity.signin.presenter.LoginPresenter;
import noname.project1.view.activity.signup.presenter.SignUpHandler;
import noname.project1.view.activity.signup.presenter.StudentForm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Amit on 9/25/2017.
 */

public class WebConnection {


    public static void registerStudent(StudentForm studentForm, final SignUpHandler handler) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrls.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebApis call1 = retrofit.create(WebApis.class);
        Call<RegisterResponse> call = call1.requestRegister(studentForm.firstName + " " + studentForm.lastName, studentForm.email, studentForm.password, studentForm.mobileNumber, studentForm.deviceToken);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                handler.success(response.body());
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                handler.fail(t.getMessage());
            }
        });
    }


    public static void loginStudent(String email, String password, String deviceToken, final LoginHandler handler) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BaseUrls.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        WebApis call1 = retrofit.create(WebApis.class);
        Call<LoginResponse> call = call1.requestLoginStudent(email,password,deviceToken);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                handler.success(response.body());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                handler.fail(t.getMessage());
            }
        });
    }
}
