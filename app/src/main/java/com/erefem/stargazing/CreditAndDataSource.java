package com.erefem.stargazing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class CreditAndDataSource extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_and_data_source);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.credit_and_data_source_title);
        }
        clickableHyperlink();
    }

    private void clickableHyperlink() {
        TextView linkTextView = findViewById(R.id.tv_credit_list);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        linkTextView.setLinkTextColor(Color.BLUE);
    }
}