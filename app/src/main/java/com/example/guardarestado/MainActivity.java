package com.example.guardarestado;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    private int incremento = 0;
    private TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void incrementar(View view) {
        incremento++;

        texto.setText(String.valueOf(incremento));
    }

    @Override
    protected void onSaveInstanceState(Bundle estado){
        super.onSaveInstanceState(estado);

        estado.putInt("posicion", incremento);
    }

    @Override
    protected void onRestoreInstanceState(Bundle estado){
        super.onRestoreInstanceState(estado);

        incremento = estado.getInt("posicion");

        texto.setText(String.valueOf(incremento));
    }
}
