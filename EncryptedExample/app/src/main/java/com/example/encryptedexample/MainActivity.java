package com.example.encryptedexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.encryptedexample.databinding.ActivityMainBinding;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setContentView(view);


        binding.btnWrite.setOnClickListener((v -> {
            //encryptOne();
            encryptTwo(binding.textInput.getText().toString(), "blablabla123");

        }));

        binding.btnRead.setOnClickListener(v -> {
            String data = decryptedTwo(binding.textMessage.getText().toString(), "blablabla123");
            binding.textMessage.setText(data);
        });
    }

    private void encryptTwo(String data, String password) {
        try {
            String string = Crypto.encrypt(data, password);
            binding.textMessage.setText(string);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String decryptedTwo(String outputString, String password) {
        try {
            return Crypto.decrypt(outputString, password);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    ///--


    private void encryptOne() {
        SecretKey secretKey = Crypto.generateKey();
        try {
            byte[] bytes = Crypto.encryptMsg(binding.textInput.getText().toString(), secretKey);
            binding.textMessage.setText(new String(bytes));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void decryptOne() {
        SecretKey secretKey = Crypto.generateKey();
        try {
            String message = Crypto.decryptMsg("+UHmDJqdrlT4kp/y".getBytes(), secretKey);
            binding.textMessage.setText(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
