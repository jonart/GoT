package ru.skillbranch.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import ru.skillbranch.got.R;

/**
 * Created by root on 20.10.2016.
 */

public class BaseActivity extends AppCompatActivity {

    protected ProgressDialog mProgressDialog;
    private Context sContex;

    public Context getsContex() {
        return sContex;

    }
}
