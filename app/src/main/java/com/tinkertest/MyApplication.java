package com.tinkertest;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.tencent.tinker.lib.service.PatchResult;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;
import com.tinkerpatch.sdk.tinker.callback.ResultCallBack;

import comtinkertest.BuildConfig;

/**
 * Created by gavin
 * Created date 17/7/3
 * Created log
 */

public class MyApplication extends Application {
    ApplicationLike tinkerAppLike;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.TINKER_ENABLE){
            tinkerAppLike = TinkerPatchApplicationLike.getTinkerPatchApplicationLike();
            TinkerPatch.init(tinkerAppLike)
                    //是否自动反射Library路径,无须手动加载补丁中的So文件 注意,调用在反射接口之后才能生效,你也可以使用Tinker的方式加载Library
                    .reflectPatchLibrary()
                    //向后台获取是否有补丁包更新,默认的访问间隔为3个小时，若参数为true,即每次调用都会真正的访问后台配置
                    //你也可以在用户登录或者APP启动等一些关键路径，使用fetchPatchUpdate(true)强制检查更新
                    .fetchPatchUpdate(true)
                    //设置收到后台回退要求时,锁屏清除补丁 默认是等主进程重启时自动清除
                    .setPatchRollbackOnScreenOff(true)
                    //设置补丁合成成功后,锁屏重启程序 默认是等应用自然重启
                    .setPatchRestartOnSrceenOff(true)
                    .setPatchResultCallback(new ResultCallBack() {
                        @Override
                        public void onPatchResult(PatchResult patchResult) {
//                            new AlertDialog.Builder(getApplicationContext()).create()
//                                    .setTitle("升级成功");
                            Toast.makeText(getApplicationContext(),"成功！",Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        new FetchPatchHandler().fetchPatchWithInterval(1);
    }
}