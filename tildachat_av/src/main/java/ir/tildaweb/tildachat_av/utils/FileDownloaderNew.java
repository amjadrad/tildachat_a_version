package ir.tildaweb.tildachat_av.utils;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;

import androidx.core.content.FileProvider;

import java.io.File;

import ir.tildaweb.tildachat_av.app.TildaChatApp;

public class FileDownloaderNew extends AsyncTask<String, String, String> {

    private static final String TAG = "FileDownloaderNew";
    private String filePath, folderName;
    private Context context;
    private OnFileDownloadListener onFileDownloadListener;
    private DownloadManager downloadManager;


    public FileDownloaderNew(Context context, String folderName) {
        this.context = context;
        this.folderName = folderName;
        this.downloadManager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
    }

    public void setOnFileDownloadListener(OnFileDownloadListener onFileDownloadListener) {
        this.onFileDownloadListener = onFileDownloadListener;
    }

    public interface OnFileDownloadListener {
        void onFileDownloaded(String path);

        void onFileDownloaded(Long downloadId);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected String doInBackground(String... params) {
        filePath = params[0];
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
//            try {
//                URL url = new URL(filePath);
//                InputStream inputStream = url.openStream();
//                String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
//                FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + "/" + folderName + fileName);
//                int length;
//                byte[] buffer = new byte[1024];
//                while ((length = inputStream.read(buffer)) > -1) {
//                    fileOutputStream.write(buffer, 0, length);
//                }
//                fileOutputStream.close();
//                inputStream.close();
//                File file = new File(Environment.getExternalStorageDirectory() + "/" + folderName + fileName);
//                Log.d(TAG, "doInBackground: " + file.getAbsolutePath());
//                Log.d(TAG, "doInBackground: Downloaded.");
//                return file.getAbsolutePath();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } else {
        Uri uri = Uri.parse(filePath);
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle(fileName);
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, folderName + "/chats/" + fileName);
        return "download_manager_" + downloadManager.enqueue(request);
//        }
//        return null;
    }

//    protected void onProgressUpdate(String... progress) {
//        // setting progress percentage
////        pd.setProgress(Integer.parseInt(progress[0]));
//    }

    @Override
    protected void onPostExecute(String downloadedFile) {
        Log.d(TAG, "onPostExecute: " + downloadedFile);
        if (downloadedFile.startsWith("download_manager_")) {
            //DownloadManager

            try {
                long downloadID = Long.parseLong(downloadedFile.substring(17));
                Log.d(TAG, "onPostExecute: " + downloadID);
                Intent intent = new Intent(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
                intent.putExtra("downloadId", downloadID + "");
                context.sendBroadcast(intent);
                onFileDownloadListener.onFileDownloaded(downloadID);

            } catch (Exception exception) {
                exception.printStackTrace();
            }


        } else {
            onFileDownloadListener.onFileDownloaded(downloadedFile);
        }
    }

    public static boolean isFileExists(Context context, String filePath) {
        //        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            pathFolder = context.getExternalFilesDir(null) + "/" + TildaChatApp._downloadFolder + "/";
//        } else {
        try {
            String pathFolder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + TildaChatApp._downloadFolder + "/";
            String fullPath = pathFolder + filePath;
            Log.d(TAG, "isFileExists: " + fullPath);
            File file = new File(fullPath);
            Log.d(TAG, "isFileExists: " + file.exists());
            return file.exists();
        } catch (Exception e) {
            return false;
        }
    }

    public static void openFile(Context context, String filePath) {
        try {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                pathFile = context.getExternalFilesDir(null) +  "/"+ TildaChatApp._downloadFolder +"/" + pathFile;
//            } else {
            filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + TildaChatApp._downloadFolder + "/" + filePath;
//            }
            File file = new File(filePath);
            Log.d(TAG, "openFile: " + filePath);
            String auth = context.getApplicationContext().getPackageName() + ".myprovider";
            Uri fileURI = FileProvider.getUriForFile(context, auth, file);
//            context.grantUriPermission(context.getPackageName(), fileURI, Intent.FLAG_GRANT_READ_URI_PERMISSION);
            final Intent intent = new Intent(Intent.ACTION_VIEW)
                    .setData(fileURI)
                    .addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            Intent intentChooser = Intent.createChooser(intent, "انتخاب برنامه:");
            intentChooser.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intentChooser);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

