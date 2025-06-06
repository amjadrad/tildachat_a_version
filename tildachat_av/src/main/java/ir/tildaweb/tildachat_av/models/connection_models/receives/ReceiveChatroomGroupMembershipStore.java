package ir.tildaweb.tildachat_av.models.connection_models.receives;

import com.google.gson.annotations.SerializedName;

public class ReceiveChatroomGroupMembershipStore {

    @SerializedName("status")
    private Integer status;
    @SerializedName("room_id")
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
