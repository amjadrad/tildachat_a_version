package ir.tildaweb.tildachat_av.models.connection_models.receives;

import com.google.gson.annotations.SerializedName;

public class ReceiveChatroomUsernameCheck {

    @SerializedName("status")
    private Integer status;
    @SerializedName("is_taken")
    private Boolean isTaken;
    @SerializedName("chatroom_id")
    private Integer chatroomId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getTaken() {
        return isTaken;
    }

    public void setTaken(Boolean taken) {
        isTaken = taken;
    }

    public Integer getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Integer chatroomId) {
        this.chatroomId = chatroomId;
    }
}
