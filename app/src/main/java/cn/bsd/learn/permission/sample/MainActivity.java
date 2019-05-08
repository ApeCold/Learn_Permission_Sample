package cn.bsd.learn.permission.sample;

import android.Manifest;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import cn.bsd.learn.permission.annotation.NeedsPermission;
import cn.bsd.learn.permission.annotation.OnNeverAskAgain;
import cn.bsd.learn.permission.annotation.OnPermissionDenied;
import cn.bsd.learn.permission.annotation.OnShowRationale;
import cn.bsd.learn.permission.library.PermissionManager;
import cn.bsd.learn.permission.library.listener.PermissionRequest;
import cn.bsd.learn.permission.library.listener.PermissionSetting;

public class MainActivity extends AppCompatActivity {

    private static final int SETTING_REQUEST_CODE = 668;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void camera(View view) {
        PermissionManager.request(this, new String[]{Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_CONTACTS});
    }

    //在需要获取权限的地方注释
    @NeedsPermission()
    void showCamera(){
        Log.e("neteast >>>","showCamera()");
    }

    //提示用户为何要开启权限
    @OnShowRationale()
    void showRationaleForCamera(final PermissionRequest request){
        Log.e("neteast >>>","showRationaleForCamera()");
        new AlertDialog.Builder(this)
                .setMessage("提示用户为何要开启权限")
                .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //再次执行权限请求
                        request.proceed();
                    }
                })
                .show();
    }

    //用户选择拒绝是的提示
    @OnPermissionDenied()
    void showDeniedForCamera(){
        Log.e("netease >>>","showDeniedForCamera()");
    }

    //用户选择不再询问后的提示
    @OnNeverAskAgain()
    void showNeverAskForCamera(final PermissionSetting setting){
        Log.e("netease >>>" ,"showNeverAskForCamera()");
        new AlertDialog.Builder(this)
                .setMessage("用户选择不再询问后的提示")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        setting.setting(SETTING_REQUEST_CODE);
                    }
                })
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.e("netease >>>","onRequestPermissionsResult()");
        PermissionManager.onRequestPermissionsResult(this,requestCode,grantResults);
    }
}
