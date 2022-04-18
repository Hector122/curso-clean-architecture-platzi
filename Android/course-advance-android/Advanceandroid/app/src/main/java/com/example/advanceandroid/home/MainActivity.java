package com.example.advanceandroid.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bluelinelabs.conductor.Controller;
import com.example.advanceandroid.R;
import com.example.advanceandroid.base.BaseActivity;
import com.example.advanceandroid.trending.TrendingRepoController;

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected Controller initController() {
        return new TrendingRepoController();
    }
}