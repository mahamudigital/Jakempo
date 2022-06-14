package com.mahamudigitallab.jakempo;

import androidx.appcompat.app.AppCompatActivity;

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

    //cria metodo que seleciona pedra pela imagem de pedra
    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    //cria metodo que seleciona papel pela imagem de papel
    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    //cria metodo que seleciona resoura pela imagem de tesoura
    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        //instanciar o imageview de resultado
        ImageView imageResultado = findViewById(R.id.imageResultado);
        //instanciar o textView de resultado que exibe quem ganhou
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3); //gera numeros randomicos 0, 1 e 2
        //cria um array com as tres possiveis opçoes de escolha
        String[] opcoes = {"pedra", "papel", "tesoura"}; //pedra =0 papel=1 e tesoura =2
        //opçãoApp é gerada quando o app gera numeros randomicos que correspondem a posição do array
        String escolhaDoApp = opcoes[numero];
        // nesse swich case é setado a imagemResultado de acordo com a escolha do app
        switch (escolhaDoApp) {
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        //configuração da regra de negocios
        if ((escolhaDoApp == "tesoura" && escolhaUsuario == "papel") ||
            (escolhaDoApp == "papel" && escolhaUsuario == "pedra") ||
            (escolhaDoApp == "pedra" && escolhaUsuario == "tesoura")
        ) {// APP ganhador
            textResultado.setText("Você perdeu :("); //exibição de resultado
        } else if ((escolhaUsuario == "tesoura" && escolhaDoApp == "papel") ||
                    (escolhaUsuario == "papel" && escolhaDoApp == "pedra") ||
                    (escolhaUsuario == "pedra" && escolhaDoApp == "tesoura")
        ) { //Usuario Ganhador
            textResultado.setText("Você ganhou :)"); //exibição de resultado
        } else { //empate
            textResultado.setText("Empatamos :|"); //exibição de resultado
        }

    }
}