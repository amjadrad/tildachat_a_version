package ir.tildaweb.tildachat_av.models.connection_models.receives;

import com.google.gson.annotations.SerializedName;

public class ReceiveUserTotalUnSeenMessagesCount {

    @SerializedName("status")
    private Integer status;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("total_unseen_messages_count")
    private Integer totalUnseenMessagesCount;
    @SerializedName("last_message_id")
    private Integer lastMessageId;
    @SerializedName("last_message_chatroom_id")
    private Integer lastMessageChatroomId;

    public Integer getLastMessageChatroomId() {
        return lastMessageChatroomId;
    }

    public void setLastMessageChatroomId(Integer lastMessageChatroomId) {
        this.lastMessageChatroomId = lastMessageChatroomId;
    }

    public Integer getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(Integer lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTotalUnseenMessagesCount() {
        return totalUnseenMessagesCount;
    }

    public void setTotalUnseenMessagesCount(Integer totalUnseenMessagesCount) {
        this.totalUnseenMessagesCount = totalUnseenMessagesCount;
    }
}
