package noname.project1.model.props.loginuser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Amit on 10/12/2017.
 */
public class Result {

@SerializedName("status")
@Expose
private String status;
@SerializedName("id")
@Expose
private String id;
@SerializedName("message")
@Expose
private String message;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

}
