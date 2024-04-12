package tamanini.ferreira.email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtendo o botao enviar
        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        //Definicao da acao do click do botao

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtendo dados digitados pelo usuario
                EditText etEmail = findViewById(R.id.etEmail);
                String email = etEmail.getText().toString(); //Obtendo o valor digitado

                //Obtendo o campo EditText de id Assunto
                EditText etAssunto = findViewById(R.id.etAssunto);
                String assunto = etAssunto.getText().toString();

                //Obtendo o campo EditText de id Texto
                EditText etTexto = findViewById(R.id.etTexto);
                String texto = etTexto.getText().toString();

                //criando a intencao
                Intent i = new Intent(Intent.ACTION_SENDTO);


                i.setData(Uri.parse("mailto:"));

                //colocando as strings dentro da intecao
                String[] emails = new String[]{email};
                i.putExtra(Intent.EXTRA_EMAIL, emails);
                i.putExtra(Intent.EXTRA_SUBJECT, assunto);
                i.putExtra(Intent.EXTRA_TEXT, texto);

                //executando o intent
                try {
                    startActivity(Intent.createChooser(i, "Escolha o APP"));
                }
                catch (ActivityNotFoundException e) {
                    Toast.makeText(MainActivity.this, "Não há nenhum app que posso realizar essa operação",Toast.LENGTH_LONG).show();
                }


            }
        });

    }
}