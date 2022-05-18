package com.lm.calculatriceimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button calculate_button = (Button) findViewById(R.id.calculate_button) ;
        final EditText TAILLE_value = (EditText)  findViewById(R.id.TAILLE)  ;
        final EditText POIDS_value = (EditText)  findViewById(R.id.POIDS)  ;
        final TextView result = (TextView)  findViewById(R.id.result)  ;
        calculate_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TAILLE_value.getText().length()>0 && POIDS_value.getText().length()>0){
                   float TAILLE=Float.parseFloat(TAILLE_value.getText().toString()) ;
                  float  POIDS=Float.parseFloat(POIDS_value.getText().toString()) ;
                     float imc=calculateIMC( POIDS, TAILLE) ;
                    if (imc<16) {
                        result.setText("votre imc est : " + imc + "vous etes trop maigre");
                    }
                     else if (imc<18.5) {
                        result.setText("votre imc est : " + imc + "vous etes  maigre");
                    }
                    else if (imc<25) {
                        result.setText("votre imc est : " + imc + "vous etes  normal");
                    }
                    else if (imc<30) {
                        result.setText("votre imc est : " + imc + "vous etes  gros(se)");
                    }
                    else{
                        result.setText("votre imc est : " + imc + "vous etes  obése ");
                    }
                    }
                }
                public float calculateIMC( float POIDS_value , float TAILLE_value) {
                    return (POIDS_value/TAILLE_value) ;
            }
        });



    }
}