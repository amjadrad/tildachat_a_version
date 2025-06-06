package ir.tildaweb.tildachat_av.models.connection_models.emits;

import com.google.gson.annotations.SerializedName;

public class EmitChatroomDeleteHistory {

    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("chatroom_id")
    private Integer chatroomId;

    public Integer getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Integer chatroomId) {
        this.chatroomId = chatroomId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
