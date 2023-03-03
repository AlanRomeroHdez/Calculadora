package mx.itson.calculadora;
import static android.app.ProgressDialog.show;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import mx.itson.calculadora12.R;

public class MainActivity extends AppCompatActivity {

    private Button button_suma;
    private Button button_resta;
    private Button button_multiplicacion;
    private Button button_division;

    private TextView text_Resultado;
    private EditText edit_numero_uno;
    private EditText edit_numero_dos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vibrator vibrador = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        setContentView(R.layout.activity_main);
        text_Resultado = findViewById(R.id.resultado);
        edit_numero_uno = findViewById(R.id.numero);
        edit_numero_dos = findViewById(R.id.numero2);


        button_suma = findViewById(R.id.button_suma);
        button_suma.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text_Resultado.setText
                        (suma(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString())) + "");
                long[] patronVibracion = new long[]{0, 150, 100, 150, 100, 150, 100};
                vibrador.vibrate(VibrationEffect.createWaveform(patronVibracion, -1));
                Toast.makeText(getApplicationContext(), text_Resultado.getText().toString(), Toast.LENGTH_SHORT).show();
            }

        });
        button_resta = findViewById(R.id.button_resta);
        button_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_Resultado.setText(resta(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString())) + "");
                long[] patronVibracion = new long[]{0, 150, 100, 150, 100, 150, 100};
                vibrador.vibrate(VibrationEffect.createWaveform(patronVibracion, -1));
                Toast.makeText(getApplicationContext(), text_Resultado.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        button_multiplicacion = findViewById(R.id.button_multiplicacion);
        button_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text_Resultado.setText(multiplicacion(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString())) + "");
                long[] patronVibracion = new long[]{0, 150, 100, 150, 100, 150, 100};
                vibrador.vibrate(VibrationEffect.createWaveform(patronVibracion, -1));
                Toast.makeText(getApplicationContext(), text_Resultado.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
        button_division = findViewById(R.id.button_division);
        button_division.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                text_Resultado.setText(division(Double.parseDouble(edit_numero_uno.getText().toString()), Double.parseDouble(edit_numero_dos.getText().toString())) + "");
                long[] patronVibracion = new long[]{0, 150, 100, 150, 100, 150, 100};
                vibrador.vibrate(VibrationEffect.createWaveform(patronVibracion, -1));
                Toast.makeText(getApplicationContext(), text_Resultado.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    public double suma (double a, double b) {
        return a+b;
    }
    public double resta (double a, double b) {
        return a-b;
    }
    public double multiplicacion (double a, double b) {
        return a*b;
    }
    public double division (double a, double b) {
        double resultado = 0;
        if(b!=0){resultado=a/b;
        }
        return resultado;
    }

}