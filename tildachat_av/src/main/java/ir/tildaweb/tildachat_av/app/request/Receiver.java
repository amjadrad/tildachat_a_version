package ir.tildaweb.tildachat_av.app.request;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.Nullable;

import ir.tildaweb.tildachat_av.app.DataParser;
import ir.tildaweb.tildachat_av.app.SocketEndpoints;
import ir.tildaweb.tildachat_av.app.TildaChatApp;
import ir.tildaweb.tildachat_av.app.request.interfaces.OnReceiveListener;
import ir.tildaweb.tildachat_av.app.request.interfaces.SocketReceiverInterface;

public class Receiver implements SocketReceiverInterface {

    public String TAG = this.getClass().getName();

    public Receiver() {

    }

    @Override
    public <T> void receiveCustomString(@Nullable Activity activityForRunOnUI, String endpoint, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(endpoint, args -> {
            Log.d(TAG, "receiveCustomString: " + args[0]);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(DataParser.fromJson(String.valueOf(args[0]), receiveModel)));
            } else {
                onReceiveListener.onReceive(DataParser.fromJson(String.valueOf(args[0]), receiveModel));
            }
        });
    }

    @Override
    public <T> void receiveCustomModel(@Nullable Activity activityForRunOnUI, String endpoint, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(endpoint, args -> {
            Log.d(TAG, "receiveCustomModel: " + args[0]);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(DataParser.fromJson(String.valueOf(args[0]), receiveModel)));
            } else {
                onReceiveListener.onReceive(DataParser.fromJson(String.valueOf(args[0]), receiveModel));
            }
        });
    }

    @Override
    public <T> void receiveMessageStore(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_MESSAGE_STORE, args -> {
//            Log.d(TAG, "receiveMessageStore: " + args[0]);
            try {
                T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
                if (activityForRunOnUI != null) {
                    activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
                } else {
                    onReceiveListener.onReceive(t);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public <T> void receiveMessageUpdate(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_MESSAGE_UPDATE, args -> {
            Log.d(TAG, "receiveMessageUpdate: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveMessageDelete(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_MESSAGE_DELETE, args -> {
            Log.d(TAG, "receiveMessageDelete: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveMessageSeen(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_MESSAGE_SEEN, args -> {
//            Log.d(TAG, "receiveMessageSeen: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

//    @Override
//    public <T> void receiveUserChatrooms(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
//
//        disposableObserverUserChatrooms = new DisposableObserver<String>() {
//            @Override
//            public void onNext(String s) {
//                T t = (T) DataParser.fromJson(String.valueOf(s), receiveModel);
//                if (activityForRunOnUI != null) {
//                    activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
//                } else {
//                    onReceiveListener.onReceive(t);
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "onComplete: Finish");
//            }
//        };
//        TildaChatApp.getPublishSubject().subscribe(disposableObserverUserChatrooms);
//    }

    @Override
    public <T> void receiveUserChatrooms(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_USER_CHATROOMS, args -> {
            Log.d(TAG, "receiveUserChatrooms: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomUserNameCheck(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_USERNAME_CHECK, args -> {
            Log.d(TAG, "receiveChatroomUserNameCheck: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomCheck(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        if (!TildaChatApp.getSocket().hasListeners(SocketEndpoints.TAG_RECEIVE_CHATROOM_CHECK)) {
            TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_CHECK, args -> {
                Log.d(TAG, "receiveChatroomCheck: " + args[0]);
                T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
                if (activityForRunOnUI != null) {
                    activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
                } else {
                    onReceiveListener.onReceive(t);
                }
            });
        }
    }

    @Override
    public <T> void receiveChatroomJoin(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_JOIN, args -> {
            Log.d(TAG, "receiveChatroomJoin: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomMessages(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_MESSAGES, args -> {
            Log.d(TAG, "setSocketListeners: messages " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomMembers(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_MEMBERS, args -> {
            Log.d(TAG, "receiveChatroomMembers: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomSearch(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_SEARCH, args -> {
            Log.d(TAG, "receiveChatroomSearch: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveUserOnlineStatus(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_USER_ONLINE_STATUS, args -> {
            Log.d(TAG, "receiveUserOnlineStatus: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveUserBlock(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_USER_BLOCK, args -> {
            Log.d(TAG, "receiveUserBlock: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveUserTotalUnSeenMessagesCount(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_USER_TOTAL_UNSEEN_MESSAGES_COUNT, args -> {
            Log.d(TAG, "receiveUserTotalUnSeenMessagesCount: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomDeleteHistory(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_DELETE_HISTORY, args -> {
            Log.d(TAG, "receiveChatroomDeleteHistory: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomDelete(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_DELETE, args -> {
            Log.d(TAG, "receiveChatroomDelete: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomGroupLeft(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_GROUP_LEFT, args -> {
            Log.d(TAG, "receiveChatroomGroupLeft: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });

    }

    @Override
    public <T> void receiveChatroomGroupMembershipStore(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_GROUP_MEMBERSHIP_STORE, args -> {
            Log.d(TAG, "receiveChatroomGroupMembershipStore: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomUserWriting(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_USER_WRITING, args -> {
//            Log.d(TAG, "receiveChatroomUserWriting: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

    @Override
    public <T> void receiveChatroomPinMessages(@Nullable Activity activityForRunOnUI, Class<T> receiveModel, OnReceiveListener<T> onReceiveListener) {
        TildaChatApp.getSocket().on(SocketEndpoints.TAG_RECEIVE_CHATROOM_PIN_MESSAGES, args -> {
            Log.d(TAG, "receiveChatroomPinMessages: " + args[0]);
            T t = (T) DataParser.fromJson(String.valueOf(args[0]), receiveModel);
            if (activityForRunOnUI != null) {
                activityForRunOnUI.runOnUiThread(() -> onReceiveListener.onReceive(t));
            } else {
                onReceiveListener.onReceive(t);
            }
        });
    }

}
