package com.softulp.listadeinmuebles;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

private MutableLiveData<List<Inmueble>> inmuebleMutable;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }
public LiveData<List<Inmueble>> getInmuebleMutable(){
        if(inmuebleMutable==null){
            this.inmuebleMutable=new MutableLiveData<List<Inmueble>>();
        }
        return inmuebleMutable;
}
    public void cargarDatos(){
        ArrayList<Inmueble> lista= new ArrayList<>();
        lista.add(new Inmueble(R.drawable.casa1,"Villa Mercedes",80000));
        lista.add(new Inmueble(R.drawable.casa2,"San Luis",150000));
        lista.add(new Inmueble(R.drawable.casa3,"Potrero",20000));
        inmuebleMutable.setValue(lista);
    }
}
