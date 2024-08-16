package com.vnc.flashscorex.ui.flutter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.google.gson.Gson;

public class CreatePackDemo {
//    private FlutterEngine engine;
//    private MethodChannel methodChannel;
//    public static final String ENTRY_POINT_DIY35 = "diyScreen";
//    public static final String KEY_PACKAGE_DIY_35 = "key_package_diy_35";
//    private String jsonPackage = "";
//    private DIYDataV2 itemPackage;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setStatusBarTransparent();
//        jsonPackage = getIntent().getStringExtra(KEY_PACKAGE_DIY_35);
//        Gson gson = new Gson();
//        itemPackage = gson.fromJson(jsonPackage, DIYDataV2.class);
//        engine = new FlutterEngine(this);
//        engine.getDartExecutor().executeDartEntrypoint(
//                new DartExecutor.DartEntrypoint(FlutterInjector.instance().flutterLoader().findAppBundlePath(),
//                        ENTRY_POINT_DIY35));
//        FlutterView flutterView = new FlutterView(this);
//        flutterView.attachToFlutterEngine(engine);
//        setContentView(flutterView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        methodChannel = new MethodChannel(engine.getDartExecutor().getBinaryMessenger(), DIY_35_METHOD_CHANNEL);
//        methodChannel.setMethodCallHandler((call, result) -> {
//            switch (call.method) {
//                case FlutterConstants.DIY_35_CREATE_PACKAGE:
//                    result.success(jsonPackage);
//                    break;
//                case FlutterConstants.NOT_ENOUGH_MONEY_DIY_35:
//                    Intent topupIntent = new Intent(this, TopupV3Activity.class);
//                    startActivity(topupIntent);
//                    break;
//                case FlutterConstants.OPEN_DIY_URL:
//                    MVUtilitiesWebView.newInstance().openWebBrowser(call.arguments(), this);
//                    break;
//                case FlutterConstants.ON_TAP_BACK_SCREEN_VIEWED:
//                    String resultFlutter = call.arguments();
//                    if (Integer.parseInt(resultFlutter) == 1){
//                        Intent intent = new Intent(this, NMainActivity.class);
//                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        startActivity(intent);
//                        if (NMainActivity.getInstance() != null ) {
//                            NMainActivity.getInstance().switchTab(NMainActivity.getInstance().getPosTabMail());
//                            MethodChannel methodChannel = new MethodChannel(NMainActivity.getInstance().flutterEngine.getDartExecutor().getBinaryMessenger(), SHOP_METHOD_CHANNEL);
//                            methodChannel.invokeMethod("refreshData", null);
//                        }
//                        new Handler().postDelayed(new Runnable() {
//                            @Override
//                            public void run() {
//                                if (NMainActivity.getInstance() != null  && NMainActivity.getInstance().mFragmentPackage != null) {
//                                    NMainActivity.getInstance().switchTab(NMainActivity.getInstance().getPostTabTelecom());
//                                    NMainActivity.getInstance().mFragmentPackage.getDataMobile();
//                                }
//                            }
//                        },50);
//                        break;
//                    }else {
//                        finish();
//                        break;
//                    }
//            }
//        });
//        if (null != NMainActivity.getInstance()){
//            NMainActivity.getInstance().setupAppChannel(engine);
//        }
//    }
//
//    private void setStatusBarTransparent() {
//        if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
//            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
//        }
//        if (Build.VERSION.SDK_INT >= 19) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }
//
//        if (Build.VERSION.SDK_INT >= 21) {
//            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }
//    }
//    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
//        Window win = activity.getWindow();
//        WindowManager.LayoutParams winParams = win.getAttributes();
//        if (on) {
//            winParams.flags |= bits;
//        } else {
//            winParams.flags &= ~bits;
//        }
//        win.setAttributes(winParams);
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        if (null != engine) {
//            engine.getLifecycleChannel().appIsResumed();
//        }
//    }
//    @Override
//    protected void onPause() {
//        super.onPause();
//        if (null != engine) {
//            engine.getLifecycleChannel().appIsPaused();
//        }
//    }
//    @Override
//    protected void onStop() {
//        super.onStop();
//        if (null != engine) {
//            engine.getLifecycleChannel().appIsInactive();
//        }
//    }
}
