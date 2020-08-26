package io.flutter.plugins;


/*
 * Author : LiJiqqi
 * Date : 2020/8/26
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import java.lang.ref.WeakReference;

import activity.InputChannelActivity;
import activity.LiveActivity;
import activity.SetRoleActivity;
import constant.MethodOrder;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class AgoraLivePlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {

    public static final String CHANNEL_NAME = "agora_live_plugin";
    private MethodChannel channel;


    private WeakReference<Activity> activity;
    private WeakReference<Context> context;

    public AgoraLivePlugin(Activity activity,Context context){
        this.activity =new WeakReference<Activity>(activity);
        this.context = new WeakReference<Context>(context);
    }


    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull MethodChannel.Result result) {
        switch (call.method){
            case MethodOrder.LIVE_PAGE:
                activity.get().startActivity(new Intent(activity.get(), InputChannelActivity.class));
                break;
        }

    }

    ///新版本的
    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
        channel = new MethodChannel(binding.getBinaryMessenger(),CHANNEL_NAME);
        channel.setMethodCallHandler(this);

    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {

    }

    /////

    @Override
    public void onAttachedToActivity(@NonNull ActivityPluginBinding binding) {

    }

    @Override
    public void onDetachedFromActivityForConfigChanges() {

    }

    @Override
    public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding binding) {

    }

    @Override
    public void onDetachedFromActivity() {

    }

}
