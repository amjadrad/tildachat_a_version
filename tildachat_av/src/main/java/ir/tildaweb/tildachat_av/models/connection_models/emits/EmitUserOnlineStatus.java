package ir.tildaweb.tildachat_av.models.connection_models.emits;

import com.google.gson.annotations.SerializedName;

public class EmitUserOnlineStatus {

    @SerializedName("user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
