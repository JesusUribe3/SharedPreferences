package jesus.uribe.dispositivos.clase_5;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    private EditText Usuario;
    Button Guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario = (EditText) findViewById(R.id.Usuario);
        Guardar = (Button) findViewById(R.id.Save) ;

        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        Usuario.setText(preferences.getString("Usuarios" , ""));
    }
    @Override
    protected void onStart () {
        super.onStart();

        Guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                save (view);

            }
        });
    }

    public void save (View view)
    {
        SharedPreferences preference =getSharedPreferences("datos" , Context.MODE_PRIVATE);
        SharedPreferences.Editor Objet_Editor = preference.edit();
        Objet_Editor.putString("Usuarios" , Usuario.getText().toString());
        Objet_Editor.commit();
        finish();

    }
}