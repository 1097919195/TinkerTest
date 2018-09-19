package com.tinkertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tinkerpatch.sdk.TinkerPatch;

import java.io.File;

import comtinkertest.R;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_END = ".apk";//文件后缀
    private String FILEDIR;//文件路径

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //    /storage/emulated/0/Android/data/com.example.ggxiaozhi.tinker/cache/tpatch/
        FILEDIR = getExternalCacheDir().getAbsolutePath() + "/tpatch/";
        //创建路径对应的文件夹
        File file = new File(FILEDIR);
        if (!file.exists()) {
            file.mkdir();
        }

//        Toast.makeText(this, "I`m patch! version 1  no internet", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "补丁下载成功", Toast.LENGTH_SHORT).show();
    }


    public void loadPatch(View view) {
        TinkerPatch.with().fetchPatchUpdate(true);
    }

    public String getPatchName() {
        return FILEDIR.concat("tinker").concat(FILE_END);
    }
}
