package com.softulp.listadeinmuebles;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.softulp.listadeinmuebles.databinding.ItemBinding;

import java.util.List;

public class ListaAdapter extends ArrayAdapter<Inmueble> {
    private List<Inmueble> listadoDeInmuebles;
    private Context context;
    private LayoutInflater li;

    private int itemAMostrar;
    public ListaAdapter(@NonNull Context context, int item, @NonNull List<Inmueble> listaInmueble,LayoutInflater li){
        super(context,item,listaInmueble);
        this.listadoDeInmuebles=listaInmueble;
        this.context=context;
        this.li=li;
        this.itemAMostrar=item;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View itemView, @NonNull ViewGroup parent) {
        View view=itemView;

        if(view==null) {
            view = li.inflate(itemAMostrar, parent, false);
            Log.d("salida if",view.toString());
        }

        //Accedo a los componentes del item
        TextView direccion=view.findViewById(R.id.direccion);
        TextView precio=view.findViewById(R.id.precio);
        ImageView foto=view.findViewById(R.id.foto);


        //Asignarle los datos a cada componente.
        Inmueble inmueble=listadoDeInmuebles.get(position);
        direccion.setText(inmueble.getDireccion());
        precio.setText(inmueble.getPrecio()+"");
        foto.setImageResource(inmueble.getFoto());


        return view;
    }

    public int getCount(){
        return listadoDeInmuebles.size();
    }
}

