package ir.tildaweb.tildachat_av.models.connection_models.emits;

import com.google.gson.annotations.SerializedName;

public class EmitChatroomJoin {

    @SerializedName("room_id")
    private String roomId;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
