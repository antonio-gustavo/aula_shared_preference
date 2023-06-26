package com.example.chatgpt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText mEditText = findViewById(R.id.editText);
        ImageView mImageView = findViewById(R.id.imageView7);

        SharedPreferences mSharedPreferences = getSharedPreferences("MyPrefsFile", MODE_PRIVATE);
        String savedText = mSharedPreferences.getString("edit_text_preference", "Insira sua chave de API | Open API");
        mEditText.setText(savedText);

        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToSave = mEditText.getText().toString();
                mSharedPreferences.edit().putString("edit_text_preference", textToSave).apply();
                Toast.makeText(MainActivity.this, "Chave API salva com sucesso!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ChatActivity.class);
                startActivity(intent);
            }
        });

    }
}