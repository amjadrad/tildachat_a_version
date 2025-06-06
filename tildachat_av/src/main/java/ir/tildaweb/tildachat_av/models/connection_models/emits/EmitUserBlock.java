package ir.tildaweb.tildachat_av.models.connection_models.emits;

import com.google.gson.annotations.SerializedName;

public class EmitUserBlock {

    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("blocked_user_id")
    private Integer blockedUserId;
    @SerializedName("room_id")
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getBlockedUserId() {
        return blockedUserId;
    }

    public void setBlockedUserId(Integer blockedUserId) {
        this.blockedUserId = blockedUserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
