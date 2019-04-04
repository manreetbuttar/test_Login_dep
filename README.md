# test_Login_dependency
Upload login & SignUp screen library.
This library is created with the purpose to design of Login Screen and Sign Up Screen .
It has following features:
Create Login Screen and with the same code we can create a Sign Up screen also.
Change Background of Login & SignUp screen .
Change logo icon.
Change design of Buttons and EditTexts.
Change Font,color of text of button andEdittexts.
Perform any action on the click of Button.

# Setup


Step 1. Add the maven repository to your project-level build.gradle file

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.manreetbuttar:login_signUp_dep:1.0'
	}

# Usage

Step 1: Add LinearLayout in your XML file.

    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"

    xmlns:app="http://schemas.android.com/apk/res-auto"
    
    xmlns:tools="http://schemas.android.com/tools"
    
    android:id="@+id/background"
    
    android:orientation="vertical"
    
    android:layout_width="match_parent"
    
    android:layout_height="match_parent"
    
    tools:context=".Main">
    
    </LinearLayout>
    

Step 2: call addLayout method to add Screen design.

        LoginTemplate.addLayout(this, true, edittextArrayList, true, "Login", background, R.color.black, com.example.signup_login_library.R.drawable.edittext_background, "Gotham-Font/GothamMedium.ttf");

Parameters of addLayout method:

* this-> context

* true-> It set true if we want to set logo in screen .otherwise it set false.

* edittextArrayList-> List of Edittext .

* true-> It set true ,if we want to display Forgot Password,Otherwise set false.

* "Login"-> pass"Login" if We have login screen,If we have Sign Up screen then pass"SignUp".

* background-> pass Layout which place in XML file.

* R.color.black-> Edittext color

* R.drawable.edittext_background-> Edittext background

* "Gotham-Font/GothamMedium.ttf" -> Edittext font

Step 3: call Background method to set background of screen. we can set color or image as a background.

        LoginTemplate.Background(this, true, background, R.color.colorAccent, R.drawable.back_image);

Parameters of Background method:

* this -> context

* true -> It set true if we want to set Background ,otherwise set it false.

* R.color.colorAccent -> color of background screen.

*  R.drawable.back_image -> background Image.

Step 4: call set_logo_design method to set logo on screen.

      LoginTemplate.set_Logo_design(com.example.signup_login_library.R.drawable.eten_logo, 250, 250);
      
Parameters of set_Logo_design method:

* R.drawable.eten_logo-> pass logo icon.

* 250 -> height

* 250 -> width

Step 5: call change_button method to change design of button.

        LoginTemplate.change_button(R.color.white,R.drawable.button_shape, "Gotham-Font/GothamMedium.ttf");

Parameters of change_button method:

* R.color.white ->  Text color

* R.drawable.button_shape-> button background

* "Gotham-Font/GothamMedium.ttf" -> font of button's text

Step 6: call setforgot_design method to change forgot color.

       LoginTemplate.setforgot_design(this,R.color.white);
       
 Parameters of setforgot_design method:
 
 * this -> context
 
 * R.color.white -> color of text
 
 Step 7: we can perform any action on Button Click :
 
        private BroadcastReceiver buttonClick = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void onReceive(Context context, Intent intent) {

            // Get extra data included in the Intent
            String text1 = intent.getStringExtra("BUTTON");
            if(text1.equals("Login")){
                for (int i = 0; i < LoginTemplate.allEds.size(); i++) {
                    text =  LoginTemplate.allEds.get(i).getText().toString();
                    hint = edittextArrayList.get(i).getName();
                    if(hint.equals("password")){
                        if(!text.equals("")) {
                            password= LoginTemplate.allEds.get(i).getText().toString();
                            if(password.length()<5){
                                Dailog.showDialog(Main.this, "Weak password", "Please fill Strong Password ", temp);
                                break;
                            }
                        }
                    }
                    if (hint.equals("email")) {
                        if(!text.equals("")) {
                            Boolean check = isEmailValid( LoginTemplate.allEds.get(i).getText().toString());
                            if (!check) {
                                Dailog.showDialog(Main.this, "Wrong Email", "Please fill correct Email ", temp);
                                break;
                            }
                        }
                    }
                    if(hint.equals("confirm password")){
                        if(!text.equals("")) {
                            if(! LoginTemplate.allEds.get(i).getText().toString().equals(password)){
                                Dailog.showDialog(Main.this, "Password not match", "Please fill it correct ", temp);
                                break;
                            }

                        }
                    }
                    if (text.equals("")) {
                        Dailog.showDialog(Main.this, "Please fill it", "Empty " + edittextArrayList.get(i).getName(), temp);
                        break;
                    }

                }
            }
        }
    };
 

# Example

    package com.example.manreet.dynamicloginpage;
    import android.annotation.SuppressLint;
    import android.annotation.TargetApi;
    import android.app.Dialog;
    import android.content.BroadcastReceiver;
    import android.content.Context;
    import android.content.Intent;
    import android.content.IntentFilter;
    import android.graphics.Color;
    import android.graphics.drawable.Drawable;
    import android.os.Build;
    import android.support.annotation.RequiresApi;
    import android.support.v4.content.LocalBroadcastManager;
    import android.support.v7.app.ActionBar;
    import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
    import android.text.Editable;
    import android.text.InputType;
    import android.text.TextWatcher;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.view.WindowManager;
    import android.view.inputmethod.InputMethodManager;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.LinearLayout;
    import android.widget.RelativeLayout;
    import android.widget.Switch;
    import android.widget.TextView;
    import android.widget.Toast;

    import com.example.mylibrary.ButtonModel;
    import com.example.mylibrary.Dailog;

    import java.lang.reflect.Field;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Main extends AppCompatActivity {
        RelativeLayout mainLayout;
        LinearLayout editTextField, forgotLayout, buttonLayout;
        ImageView logo;
        ArrayList<EditTextModel> edittextArrayList = new ArrayList<>();
        String[] editTexthint = {"email", "password", "confirm password"};
        ArrayList<ButtonModel> temp = new ArrayList<>();
        String[] buttonName = {"ok"};
        String text, hint,password;
        private static Context mContext;
        LinearLayout background;
        IntentFilter intentFilter;
        @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            background=(LinearLayout) findViewById(R.id.background);
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            ActionBar m_myActionBar=getSupportActionBar(); // to get activity actionbar
            //For hiding actionbar
            m_myActionBar.hide();
            for (String name : editTexthint) {
                EditTextModel model = new EditTextModel();
                model.setName(name);
                edittextArrayList.add(model);
            }
            for (String buttonname : buttonName) {
                ButtonModel buttonModel = new ButtonModel();
                buttonModel.setName(buttonname);
                temp.add(buttonModel);
            }
            LoginTemplate.addLayout(this,true,edittextArrayList,true,"Login",background,R.color.black,R.drawable.edittext_background,"Gotham-Font/GothamMedium.ttf");
            LoginTemplate.set_Logo_design(R.drawable.eten_logo,250,250);
            LoginTemplate.change_button(R.color.white,R.drawable.button_shape,"Gotham-Font/GothamMedium.ttf");
            LoginTemplate.setforgot_design(this,R.color.colorPrimary);
            LoginTemplate.Background(this,true,background,R.color.colorAccent,R.drawable.back_2);
            intentFilter = new IntentFilter("DynamicPage");

        }

    private BroadcastReceiver buttonClick = new BroadcastReceiver() {
        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
        @Override
        public void onReceive(Context context, Intent intent) {

            // Get extra data included in the Intent
            String text1 = intent.getStringExtra("BUTTON");
            if(text1.equals("Login")){
                for (int i = 0; i < LoginTemplate.allEds.size(); i++) {
                    text =  LoginTemplate.allEds.get(i).getText().toString();
                    hint = edittextArrayList.get(i).getName();
                    if(hint.equals("password")){
                        if(!text.equals("")) {
                            password= LoginTemplate.allEds.get(i).getText().toString();
                            if(password.length()<5){
                                Dailog.showDialog(Main.this, "Weak password", "Please fill Strong Password ", temp);
                                break;
                            }
                        }
                    }
                    if (hint.equals("email")) {
                        if(!text.equals("")) {
                            Boolean check = isEmailValid( LoginTemplate.allEds.get(i).getText().toString());
                            if (!check) {
                                Dailog.showDialog(Main.this, "Wrong Email", "Please fill correct Email ", temp);
                                break;
                            }
                        }
                    }
                    if(hint.equals("confirm password")){
                        if(!text.equals("")) {
                            if(! LoginTemplate.allEds.get(i).getText().toString().equals(password)){
                                Dailog.showDialog(Main.this, "Password not match", "Please fill it correct ", temp);
                                break;
                            }

                        }
                    }
                    if (text.equals("")) {
                        Dailog.showDialog(Main.this, "Please fill it", "Empty " + edittextArrayList.get(i).getName(), temp);
                        break;
                    }

                }
            }
        }
    };
    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(buttonClick);
    }


    @Override
    protected void onResume() {
        // Register to receive messages.
        // We are registering an observer (mMessageReceiver) to receive Intents
        // with actions named "custom-event-name".
        LocalBroadcastManager.getInstance(this).registerReceiver(
                buttonClick, new IntentFilter("DynamicPage"));
        super.onResume();
    }

    public static boolean isEmailValid(String email) {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-z]+[\\w-]+\\.)+[a-z]{2,4})$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }
}

 
     
