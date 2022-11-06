package com.example.reviewphim;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.transition.ChangeBounds;
import android.transition.ChangeImageTransform;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;


public class profile extends AppCompatActivity {

    Button btn_logOut;
    TextView tv_fl_fb, tv_fl_ins, tv_email, tv_rules, tv_name, tv_account;
    ImageView img_pen, logoImageView;
    protected int _splashTime = 1000;
    Animation zoom_in, zoom_out;

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getSupportActionBar().hide();
        overridePendingTransition(R.anim.zoom_in_fade_in, android.R.anim.fade_out);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        //chua fix
        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
            tv_name.setText(personName);
            tv_email.setText(personEmail);
        }
        //-----------------
        btn_logOut = findViewById(R.id.btn_back);
        btn_logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signOut();
            }
        });

        tv_fl_fb = findViewById(R.id.tv_fl_fb);
        tv_fl_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "http://www.facebook.com/charlestuan1214";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_fl_ins = findViewById(R.id.tv_fullName_infor);
        tv_fl_ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "https://www.instagram.com/charles.tuna/";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_email = findViewById(R.id.tv_email);
        tv_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "mailto:caphuutuan1@gmail.com";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_rules = findViewById(R.id.tv_rules);
        tv_rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO Auto-generated method stub
                String url = "tel:0398272747";

                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

        tv_account = findViewById(R.id.tv_account);
        tv_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                account();
            }
        });

        img_pen = findViewById(R.id.img_pen);
        img_pen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeName();
            }
        });

        logoImageView = findViewById(R.id.logoImageView);
        logoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//               zoom_out= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
//               logoImageView.setVisibility(View.VISIBLE);
//               logoImageView.startAnimation(zoom_out);
            }
        });
//    }
    }

    public void logOut() {
        Intent logOut = new Intent(profile.this, MainActivity.class);
        startActivity(logOut);
    }

    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(Task<Void> task) {
                finish();
                startActivity(new Intent(profile.this, HomeActivity.class));
            }
        });
    }

    public void account() {
        Intent account = new Intent(profile.this, account.class);
        startActivity(account);
    }

    public void changeName() {
        Intent changeName = new Intent(getApplicationContext(), profile.class);
        startActivity(changeName);
    }
}