package com.softulp.listadeinmuebles;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.softulp.listadeinmuebles.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

private ActivityMainBinding binding;
private MainActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

mv= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
mv.getInmuebleMutable().observe(this, new Observer<List<Inmueble>>() {
    @Override
    public void onChanged(List<Inmueble> inmuebles) {
        ListaAdapter ls= new ListaAdapter(MainActivity.this, R.layout.item,inmuebles,getLayoutInflater());
        ListView lv=binding.listAc;
        lv.setAdapter(ls);
    }
});
mv.cargarDatos();
    }

}