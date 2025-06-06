package ir.tildaweb.tildachat_av.enums;

public enum MessageType {

    TEXT("text"),
    PICTURE("picture"),
    VOICE("voice"),
    FILE("file");

    public final String label;

    MessageType(String label) {
        this.label = label;
    }
}
