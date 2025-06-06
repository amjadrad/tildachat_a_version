package ir.tildaweb.tildachat_av.models.base_models;

import com.google.gson.annotations.SerializedName;

public class Message {

    //Base
    @SerializedName("id")
    private Integer id;
    @SerializedName("user_id")
    private Integer userId;
    @SerializedName("chatroom_id")
    private Integer chatroom_id;
    @SerializedName("reply_message_id")
    private Integer replyMessageId;
    @SerializedName("message_type")
    private String messageType;
    @SerializedName("message")
    private String message;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    //Inject
    @SerializedName("user")
    private User user;
    @SerializedName("reply")
    private Message reply;
    @SerializedName("seen_count")
    private Integer seenCount;
    //Local
    @SerializedName("progress")
    private Integer progress;
    //Additional
    @SerializedName("price")
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public Message getReply() {
        return reply;
    }

    public void setReply(Message reply) {
        this.reply = reply;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getSeenCount() {
        return seenCount;
    }

    public void setSeenCount(Integer seenCount) {
        this.seenCount = seenCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getChatroom_id() {
        return chatroom_id;
    }

    public void setChatroom_id(Integer chatroom_id) {
        this.chatroom_id = chatroom_id;
    }

    public Integer getReplyMessageId() {
        return replyMessageId;
    }

    public void setReplyMessageId(Integer replyMessageId) {
        this.replyMessageId = replyMessageId;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }


}
