package com.example.reviewphim;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.regex.Pattern;

public class register extends MainActivity {

    private EditText et_fullname, et_username, et_password, et_confirmPassword, et_email;
    private Button btn_signUp, btn_signUp_fb, btn_signUp_gg;
    private ImageButton imbBack;
    private TextView tv_loginNow;
    protected int _splashTime = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.zoom_in_fade_in, R.anim.fade_out);

        et_fullname = findViewById(R.id.et_fullname);
        et_username = findViewById(R.id.et_username);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        et_confirmPassword = findViewById(R.id.et_confirmPassword);
        btn_signUp = findViewById(R.id.btn_signUp);

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validateDate()) {
                    Toast.makeText(register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            finish();
                            Intent i = new Intent(register.this, MainActivity.class);
                            startActivity(i);
                        }
                    }, _splashTime);
                }
                else {
                    Toast.makeText(register.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });


        tv_loginNow = findViewById(R.id.tv_loginNow);
        tv_loginNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        btn_signUp_fb = findViewById(R.id.btn_signUp_fb);
        btn_signUp_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                        Intent i = new Intent(register.this, HomeActivity.class);
                        startActivity(i);
                    }
                }, _splashTime);
            }
        });

        btn_signUp_gg = findViewById(R.id.btn_signUp_gg);
        btn_signUp_gg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        finish();
                        Intent i = new Intent(register.this, HomeActivity.class);
                        startActivity(i);
                    }
                }, _splashTime);
            }
        });
    }

    public void login() {
        Intent login = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(login);
    }

    public void profile() {
        Intent profile = new Intent(this, profile.class);
        startActivity(profile);
    }

//    private String fullname="", username="", email="", password="", Cpassword="";
    private boolean validateDate() {
        String fullname = et_fullname.getText().toString().trim();
        String usename = et_username.getText().toString().trim();
        String email = et_email.getText().toString().trim();
        String password = et_password.getText().toString().trim();
        String cPassword = et_confirmPassword.getText().toString().trim();

        if (TextUtils.isEmpty(fullname)) {
            et_fullname.setError("Nhập tên của bạn");
            et_fullname.setFocusable(true);
            return false;
        }
        else if (TextUtils.isEmpty(usename)) {
            et_username.setError("Không được để trống");
            et_username.setFocusable(true);
            return false;
        }
        else  if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.setError("Email không đúng");
            et_email.setFocusable(true);
            return false;
        }
        else  if (TextUtils.isEmpty(password)) {
            et_password.setError("Không được để trống");
            et_password.setFocusable(true);
            return false;
        }
        else  if (TextUtils.isEmpty(cPassword)) {
            et_confirmPassword.setError("Không được để trống");
            et_confirmPassword.setFocusable(true);
            return false;
        }
        else  if (!password.equals(cPassword)) {
            et_confirmPassword.setError("Mật khẩu không trùng nhau");
            et_confirmPassword.setFocusable(true);
            return false;
        }
         else {
            return true;
         }

    }

/*
        private boolean validatePassword() {
            String val = et_password.getText().toString().trim();
            String checkPassword = "^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$";
            if (val.isEmpty()) {
                et_password.setError("Field can not be empty");
                return false;
            } else if (!val.matches(checkPassword)) {
                et_password.setError("Password should contain 4 characters!");
                return false;
            } else {
    //            et_password.setError(null);
    //            et_password.setErrorEnabled(false);
    //            return true;
            }
            return true;
        }
        */
    // defining our own password pattern
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{4,}" +                // at least 4 characters
                    "$");

    private boolean validateUsername() {
        String val = et_username.getText().toString().trim();
        String checkspaces = "Aw{1,20}z";
        if (val.isEmpty()) {
            et_username.setError("Field can not be empty");
            return false;
        } else if (val.length() > 25) {
            et_username.setError("Username is too large!");
            return false;
        } else if (!val.matches(checkspaces)) {
            et_username.setError("No White spaces are allowed!");
            return false;
        } else {
//            et_username.setError(null);
//            et_username.setErrorEnabled(false);
//            return true;
        }
        return true;
    }

    private boolean CheckAllFields() {
    String nhapHoten = et_fullname.getText().toString();
    String nhapUsername = et_username.getText().toString();
    String nhapEmail = et_email.getText().toString();
    String nhapPwr = et_password.getText().toString();
    String nhapCPwr = et_confirmPassword.getText().toString();

    if (nhapHoten.equals("")) {
        et_fullname.setError("Required!");
        et_fullname.setFocusable(true);
        return false;
    } else if (nhapUsername.equals("")) {
        et_username.setError("Required!");
        et_username.setFocusable(true);
        return false;
    } else if (nhapEmail.equals("")) {
        et_email.setError("Required!");
        et_email.setFocusable(true);
        return false;
    } else if (nhapPwr.equals("")) {
        et_password.setError("Required!");
        et_password.setFocusable(true);
        return false;
    } else if (nhapCPwr.equals("")) {
        et_confirmPassword.setError("Required!");
        et_confirmPassword.setFocusable(true);
        return false;
    }

    // after all validation return true.
    return true;
}
}
