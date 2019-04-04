package com.example.manreet.test_login_dep;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.LinearLayout;
import com.example.signup_login_library.EditTextModel;
import com.example.signup_login_library.LoginTemplate;

import java.util.ArrayList;

public class Main extends AppCompatActivity {
    ArrayList<EditTextModel> edittextArrayList = new ArrayList<>();
    String[] editTexthint = {"email", "password", "confirm password"};
    String[] buttonName = {"ok"};
    String text, hint, password;
    private static Context mContext;
    LinearLayout background;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        background = (LinearLayout) findViewById(com.example.signup_login_library.R.id.background);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        ActionBar m_myActionBar = getSupportActionBar(); // to get activity actionbar
        //For hiding actionbar
        m_myActionBar.hide();
        for (String name : editTexthint) {
            EditTextModel model = new EditTextModel();
            model.setName(name);
            edittextArrayList.add(model);
        }
        LoginTemplate.addLayout(this, true, edittextArrayList, true, "Login", background, com.example.signup_login_library.R.color.black, com.example.signup_login_library.R.drawable.edittext_background, "Gotham-Font/GothamMedium.ttf");
        LoginTemplate.set_Logo_design(com.example.signup_login_library.R.drawable.eten_logo, 250, 250);
        LoginTemplate.change_button(com.example.signup_login_library.R.color.white, com.example.signup_login_library.R.drawable.button_shape, "Gotham-Font/GothamMedium.ttf");
        LoginTemplate.setforgot_design(this,R.color.white);
        LoginTemplate.Background(this, true, background, com.example.signup_login_library.R.color.colorAccent, R.drawable.back_image);
    }
}
