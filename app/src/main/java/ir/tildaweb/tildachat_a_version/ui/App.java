package ir.tildaweb.tildachat_a_version.ui;

import android.app.Application;

import ir.tildaweb.tildachat_av.app.TildaChatApp;


public class App extends Application {

    public static int userId = 2;

    @Override
    public void onCreate() {
        super.onCreate();

        String query = "user_id=" + userId;
//        TildaChatApp.setUp("https://ipomchat.nazmenovin.com", query, userId, true);
        TildaChatApp.setUp("https://chat.nazmenovin.com", query, userId, true);
//        TildaChatApp.setConstantsUp("https://ipom.nazmenovin.com/upload/", "ipomchat", "https://ipom.nazmenovin.com/api/v1_3_0/chat_uploader");
        TildaChatApp.setConstantsUp("https://nazmenovin.com/uploaded_files/", "nazmenovin", "https://nazmenovin.com/api/v1_6/chat_uploader");
        TildaChatApp.setUpEmojis(this);
    }
}
