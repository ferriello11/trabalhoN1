package com.fabiano.appformularion1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private EditText txtProfissao, txtEmail, txtNome;
    private Button btEnviar;
    private String acao;
    private  int idForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtNome = (EditText) findViewById(R.id.txtNome);
        txtProfissao =(EditText) findViewById(R.id.txtProfissao);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btEnviar = (Button) findViewById(R.id.btEnviar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               salvar();
            }
        });
    }


        private void salvar() {
        String nome = txtNome.getText().toString();
        String email = txtEmail.getText().toString();
        String profissao = txtProfissao.getText().toString();

        if(nome.isEmpty() || email.isEmpty() || profissao.isEmpty()) {
            Toast.makeText(this,"Alguns campos não foram preenchidos", Toast.LENGTH_LONG).show();
        }else {
            Formulario form = new Formulario();
            form.setNome(nome);
            form.setEmail(email);
            form.setProfissao(profissao);

            FormularioDAO.insert(this, form);

            txtNome.setText("");
            txtEmail.setText("");
            txtProfissao.setText("");
        }
    }
//
//    private void carregarFormulario(int idForm){
//        Formulario form = FormularioDAO.getFormularioById(this, idForm);
//        txtNome.setText( form.getNome() );
//        txtEmail.setText( form.getEmail() );
//        txtProfissao.setText( form.getProfissao() );
//
//    }
}

