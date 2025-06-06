package ir.tildaweb.tildachat_av.models.connection_models.receives;

import com.google.gson.annotations.SerializedName;

import ir.tildaweb.tildachat_av.models.base_models.Chatroom;
import ir.tildaweb.tildachat_av.models.base_models.User;

public class ReceiveChatroomCheck {

    @SerializedName("status")
    private Integer status;
    @SerializedName("code")
    private Integer code;
    @SerializedName("room_id")
    private String roomId;
    @SerializedName("chatroom")
    private Chatroom chatroom;
    @SerializedName("second_user")
    private User secondUser;
    @SerializedName("member_count")
    private Integer memberCount;
    @SerializedName("is_join")
    private Boolean isJoin;
    @SerializedName("is_admin")
    private Boolean isAdmin;
    @SerializedName("is_it_blocked")
    private Boolean isItBlocked;
    @SerializedName("am_i_blocked")
    private Boolean amIBlocked;

    public Boolean getItBlocked() {
        return isItBlocked;
    }

    public void setItBlocked(Boolean itBlocked) {
        isItBlocked = itBlocked;
    }

    public Boolean getAmIBlocked() {
        return amIBlocked;
    }

    public void setAmIBlocked(Boolean amIBlocked) {
        this.amIBlocked = amIBlocked;
    }

    public Boolean getJoin() {
        return isJoin;
    }

    public void setJoin(Boolean join) {
        isJoin = join;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

    public User getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(User secondUser) {
        this.secondUser = secondUser;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
