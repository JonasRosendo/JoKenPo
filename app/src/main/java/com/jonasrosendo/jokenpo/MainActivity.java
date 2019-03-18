package com.jonasrosendo.jokenpo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }

    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){

        ImageView img_resultado = findViewById(R.id.imgv_app);
        TextView txv_resultado = findViewById(R.id.txv_resultado);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolha_do_app = opcoes[numero];

        switch (escolha_do_app){
            case "pedra":
                img_resultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                img_resultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                img_resultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if( (escolha_do_app.equals("pedra") && escolhaUsuario.equals("tesoura")) || (escolha_do_app.equals("papel") && escolhaUsuario.equals("pedra")) || (escolha_do_app.equals("tesoura") && escolhaUsuario.equals("papel")) ){
            txv_resultado.setText("Você perdeu!");
        }else if( (escolhaUsuario.equals("pedra") && escolha_do_app.equals("tesoura")) || (escolhaUsuario.equals("papel") && escolha_do_app.equals("pedra")) || (escolhaUsuario.equals("tesoura") && escolha_do_app.equals("papel"))  ){
            txv_resultado.setText("Você ganhou!");
        }else{
            txv_resultado.setText("Empate!");
        }
    }
}
