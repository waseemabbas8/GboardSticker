package com.example.gboardsticker;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;

import com.google.firebase.appindexing.FirebaseAppIndex;

public class AppIndexingUpdateService extends JobIntentService {
    // Job-ID must be unique across your whole app.
    private static final int UNIQUE_JOB_ID = 42;

    public static void enqueueWork(Context context) {
        enqueueWork(context, AppIndexingUpdateService.class, UNIQUE_JOB_ID, new Intent());
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        AppIndexingUtil.setStickers(getApplicationContext(), FirebaseAppIndex.getInstance());
    }
}