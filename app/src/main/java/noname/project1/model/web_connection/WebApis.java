package noname.project1.model.web_connection;

import noname.project1.model.props.loginuser.LoginResponse;
import noname.project1.model.props.registeruser.RegisterResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Amit on 9/25/2017.
 */

public interface WebApis {


    @FormUrlEncoded
    @POST(BaseUrls.REGISTER_STUDENT)
    Call<RegisterResponse> requestRegister(  @Field("userName")String userName,@Field("email")String email,@Field("password")String password,@Field("phone")String phone,@Field("deviceToken")String deviceToken);

    @FormUrlEncoded
    @POST(BaseUrls.LOGIN_STUDENT)
    Call<LoginResponse> requestLoginStudent(@Field("email") String email, @Field("password")String password, @Field("deviceToken") String deviceToken);



}
