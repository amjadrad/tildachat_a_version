package ir.tildaweb.tildachat_av.models.connection_models.receives;

import com.google.gson.annotations.SerializedName;

public class ReceiveMessageSeen {

    @SerializedName("status")
    private Integer status;
    @SerializedName("message_id")
    private Integer messageId;
    @SerializedName("room_id")
    private String roomId;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("is_user_active")
    private boolean isUserActive;
    @SerializedName("error")
    private String error;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isUserActive() {
        return isUserActive;
    }

    public void setUserActive(boolean userActive) {
        isUserActive = userActive;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public void setMessageId(Integer messageId) {
        this.messageId = messageId;
    }
}
