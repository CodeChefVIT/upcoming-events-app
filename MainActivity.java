package com.example.upcomingevents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String eventname,description,timing;

    EditText eventnameInput;
    EditText descriptionInput;
    EditText timingsInput;

    Button mailbutton;
    Button recipientButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eventnameInput= (EditText) findViewById(R.id.eventnameInput);
        descriptionInput= (EditText) findViewById(R.id.descriptionInput);
        timingsInput= (EditText) findViewById(R.id.timingsInput);

        mailbutton=(Button) findViewById(R.id.mailbutton);
        recipientButton=(Button) findViewById((R.id.recipientButton));

        mailbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventname=eventnameInput.getText().toString();
                description=descriptionInput.getText().toString();
                timing=timingsInput.getText().toString();

                sendMail();
            }
        });

        recipientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getListOfRecipients();
            }
        });


    }
    private void sendMail() {

        String subject="Information regarding upcoming events";

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,subject);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent, "Choose an email client"));
    }

    private void getListOfRecipients() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent,1);

    }




}
