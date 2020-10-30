package com.semana4.miscontactos.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.semana4.miscontactos.R;
import com.semana4.miscontactos.adapter.ContactoAdaptador;
import com.semana4.miscontactos.db.ConstructorContacto;
import com.semana4.miscontactos.pojo.Contacto;

import java.util.ArrayList;



public class MascotasFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    ConstructorContacto constructorContacto;

    public MascotasFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);


        // esto ya existe en el fragment
        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaContactos.setLayoutManager(llm);

        ///GridLayoutManager glm = new GridLayoutManager(this, 2);
        ///listaContactos.setLayoutManager(glm);

        inicializarListaContactos();
        inicializarAdaptador();



        return v;
    }

    // Manda los datos al adaptador
    public ContactoAdaptador adaptador;
    private void inicializarAdaptador(){
        adaptador = new ContactoAdaptador(contactos, getActivity());

        listaContactos.setAdapter(adaptador);
        constructorContacto = new ConstructorContacto(this.getContext());

        contactos.get(0).setLike(constructorContacto.obtenerLikesContacto(contactos.get(0)));
        contactos.get(1).setLike(constructorContacto.obtenerLikesContacto(contactos.get(1)));
        contactos.get(2).setLike(constructorContacto.obtenerLikesContacto(contactos.get(2)));
        contactos.get(3).setLike(constructorContacto.obtenerLikesContacto(contactos.get(3)));
        contactos.get(4).setLike(constructorContacto.obtenerLikesContacto(contactos.get(4)));

    }

    // Llena los datos
    public void inicializarListaContactos(){
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.cougar,"Cougar",0));
        contactos.add(new Contacto(R.drawable.cheetah,"Cheetah",0));
        contactos.add(new Contacto(R.drawable.cat,"Cat",0));
        contactos.add(new Contacto(R.drawable.bear, "Bear", 0));
        contactos.add(new Contacto(R.drawable.ant,"Ant",0));
    }

}
