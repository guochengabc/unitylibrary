package com.airlook.citysand;

import android.content.Intent;
import android.os.Bundle;

import com.unity3d.player.UnityPlayerActivity;

public class OverrideUnityActivity extends UnityPlayerActivity {
    public static OverrideUnityActivity instance = null;

    protected void UnitySendMessage(String gameObj, String method, String arg) {
        mUnityPlayer.UnitySendMessage(gameObj, method, arg);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        Intent intent = getIntent();
        if (intent != null) {
            String id = intent.getStringExtra("SetUniqSceneKey");
            UnitySendMessage("GameMain", "SetUniqSceneKey", id);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        instance = null;
    }
}
