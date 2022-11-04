package com.example.reviewphim;

import android.annotation.SuppressLint;
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

import androidx.appcompat.app.AppCompatActivity;
import com.google.gson.Gson;

import java.util.Calendar;
import java.util.regex.Pattern;

public class register extends MainActivity {

    private EditText et_fullname, et_username, et_password, et_confirmPassword, et_email;
    private Button btn_signUp, btn_signUp_fb, btn_signUp_gg;
    private ImageButton imbBack;
    private TextView tv_loginNow;
    private SharedPreferences.Editor editor;

    private final Gson gson = new Gson();
    boolean isAllFieldsChecked = false;
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
                validateDate();
//                if (CheckAllFields()) {
//                    if (!validateEmail()) {
//                        Toast.makeText(register.this, "sai form email", Toast.LENGTH_SHORT).show();
//                        //...
//                        et_password.setError("Required!");
//
//                    } else if (!CheckPWS()) {
//                        Toast.makeText(register.this, "ko khớp pas", Toast.LENGTH_SHORT).show();
//                        //...
//                        et_confirmPassword.setError("Required!");
//                    } else {
//                        Toast.makeText(register.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
//                        Handler handler = new Handler();
//                        handler.postDelayed(new Runnable() {
//                            public void run() {
//                                finish();
//                                Intent i = new Intent(register.this, MainActivity.class);
//                                startActivity(i);
//                            }
//                        }, _splashTime);
//                    }
//                } else {
//                    Toast.makeText(register.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
//                }
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


    public void login() {
        Intent login = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(login);
    }

    public void profile() {
        Intent profile = new Intent(this, profile.class);
        startActivity(profile);
    }

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

        private String name="", email="", password="";

        private void validateDate() {
            String usename = et_username.getText().toString().trim();
            String  email= et_email.getText().toString().trim();
            String password = et_password.getText().toString().trim();
            String cPassword = et_confirmPassword.getText().toString().trim();

            if(TextUtils.isEmpty(name)) {
                Toast.makeText(this, "Nhập lại tên của bạn...", Toast.LENGTH_SHORT).show();
            }

            else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Email lỗi...", Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(password)) {
                Toast.makeText(this, "Nhập lại mật khẩu...", Toast.LENGTH_SHORT).show();
            }

            else if(TextUtils.isEmpty(cPassword)) {
                Toast.makeText(this, "Nhập lại tên của bạn...", Toast.LENGTH_SHORT).show();
            }

            else if(!password.equals(cPassword)) {
                Toast.makeText(this, "Mật khẩu không trùng...", Toast.LENGTH_SHORT).show();
            }
            else{
                return;
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

    private boolean validateEmail() {
        // Extract input from EditText
        String emailInput = et_email.getText().toString().trim();
        // if the email input field is empty
        if (emailInput.equals("")) {
            et_email.setError("Field can not be empty");
            return false;
        }
        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            et_email.setError("Please enter a valid email address");
            return false;
        } else {
            et_email.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String passwordInput = et_password.getText().toString().trim();
        // if password field is empty
        // it will display error message "Field can not be empty"
        if (passwordInput.equals("")) {
            et_password.setError("Field can not be empty");
            return false;
        }
        // if password does not matches to the pattern
        // it will display an error message "Password is too weak"
        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            et_password.setError("Password is too weak");
            return false;
        } else {
            et_password.setError(null);
            return true;
        }
    }

    public boolean CheckPWS() {
        String pws = et_password.getText().toString();
        String Cpws = et_confirmPassword.getText().toString();
        if (pws.equals(Cpws))
            return true;
        else
            return false;
    }
}
