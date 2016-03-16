package com.gookkis.latihanfloatinglabeledittext;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //TextInputLayout variables
    private TextInputLayout textInputLayoutNama;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutUmur;
    private TextInputLayout textInputLayoutPassword;

    //EditText variables
    private EditText editTextNama;
    private EditText editTextEmail;
    private EditText editTextUmur;
    private EditText editTextPassword;

    //Button
    private Button buttonDaftar;

    private ValidationHelper validation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initViews();
        initListeners();
    }


    /**
     * method untuk inisialisasi views objects
     */
    private void initViews() {
        textInputLayoutNama = (TextInputLayout) findViewById(R.id.text_input_layout_nama);
        textInputLayoutEmail = (TextInputLayout) findViewById(R.id.text_input_layout_email);
        textInputLayoutUmur = (TextInputLayout) findViewById(R.id.text_input_layout_umur);
        textInputLayoutPassword = (TextInputLayout) findViewById(R.id.text_input_layout_password);

        editTextNama = (EditText) findViewById(R.id.edit_text_nama);
        editTextEmail = (EditText) findViewById(R.id.edit_text_email);
        editTextUmur = (EditText) findViewById(R.id.edit_text_umur);
        editTextPassword = (EditText) findViewById(R.id.edit_text_password);

        buttonDaftar = (Button) findViewById(R.id.button_daftar);

        validation = new ValidationHelper(this);


    }

    /**
     * method untuk inisialisasi listeners
     */
    private void initListeners() {
        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkValidation();
            }
        });
    }

    /**
     * method untuk validasi form saat button daftar diklik
     */
    private void checkValidation() {
        if (!validation.isEditTextFilled(editTextNama, textInputLayoutNama, getString(R.string.error_pesan_nama))) {
            return;
        }

        if (!validation.isEditTextEmail(editTextEmail, textInputLayoutEmail, getString(R.string.error_pesan_email))) {
            return;
        }

        if (!validation.isEditTextFilled(editTextUmur, textInputLayoutUmur, getString(R.string.error_pesan_umur))) {
            return;
        }
        if (!validation.isEditTextFilled(editTextPassword, textInputLayoutPassword, getString(R.string.error_pesan_password))) {
            return;
        }

        Toast.makeText(getApplicationContext(), getString(R.string.pesan_sukses), Toast.LENGTH_LONG).show();


    }


}

