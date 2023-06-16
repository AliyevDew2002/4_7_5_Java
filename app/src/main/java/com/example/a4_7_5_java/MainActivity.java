package com.example.a4_7_5_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.example.a4_7_5_java.databinding.ActivityMainBinding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        initViews();
    }
    void initViews(){

        binding.btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=binding.etHome.getText().toString();

                SpannableString spannable = new SpannableString(text);
                Pattern pattern = Pattern.compile("#\\w+");
                Matcher matcher = pattern.matcher(spannable);

                while (matcher.find()) {
                    int start = matcher.start();
                    int end = matcher.end();
                    spannable.setSpan(new ForegroundColorSpan(Color.GREEN), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                }

                binding.tvClone.setText(spannable);

            }
        });


    }
}