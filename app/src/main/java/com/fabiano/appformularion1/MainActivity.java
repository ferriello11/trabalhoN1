package com.fabiano.appformularion1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.fabiano.appformularion1.databinding.ActivityMainBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvFormulario;
    private ArrayAdapter adapter;
    private List<Formulario> listaFormulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFormulario = findViewById(R.id.lvFormulario);
        carregaFormulario();
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,FormActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected  void onRestart(){
        super.onRestart();
        carregaFormulario();
    }

    private void carregaFormulario(){
        listaFormulario = FormularioDAO.getFormulario(this);

        if ( listaFormulario.size() == 0 ){
            lvFormulario.setEnabled( false );
            Formulario fake = new Formulario();
            fake.setEmail("");
            fake.setNome("Fabiano Lopes");
            fake.setProfissao("Estudante");
            fake.setEmail("teste@teste.com");
            listaFormulario.add( fake );
        }else {
            lvFormulario.setEnabled( true );
        }

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listaFormulario);
        lvFormulario.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}