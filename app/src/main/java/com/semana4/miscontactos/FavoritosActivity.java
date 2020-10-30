package com.semana4.miscontactos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.semana4.miscontactos.adapter.ContactoAdaptador;
import com.semana4.miscontactos.db.ConstructorContacto;
import com.semana4.miscontactos.pojo.Contacto;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity {

    ArrayList<Contacto> Mascotas;
    RecyclerView listaMascotas;
    ConstructorContacto constructorContacto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);
        //agrega la toolbar
        Toolbar miActionBar=(Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        //agrega la flecha hacia atras.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //muestro el logo
        getSupportActionBar().setLogo(R.drawable.huella);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        TextView bar_title = (TextView) findViewById(R.id.toolbar_title);
        bar_title.setText("Favoritos");

        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritos);
        //muestro los objetos vertical

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //configuro que se muestra asi en el recicleview
        listaMascotas.setLayoutManager(llm);
        //cargo las mascotas
        InicializarListaMascotas();
        //cargo el adaptador
        inicializarAdaptador();

    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    public void InicializarListaMascotas(){
        Mascotas=new ArrayList<Contacto>();
        Mascotas.add(new Contacto(R.drawable.cougar,"Cougar",0));
        Mascotas.add(new Contacto(R.drawable.cheetah,"Cheetah",0));
        Mascotas.add(new Contacto(R.drawable.cat,"Cat",0));
        Mascotas.add(new Contacto(R.drawable.bear, "Bear", 0));
        Mascotas.add(new Contacto(R.drawable.ant,"Ant",0));
    }

    public void inicializarAdaptador(){
        //crea uno objeto y le pasa la lista
        ContactoAdaptador adaptador=new ContactoAdaptador(Mascotas,this);
        //asigno el adaptador.
        listaMascotas.setAdapter(adaptador);
        constructorContacto = new ConstructorContacto(this);
        Mascotas.get(0).setLike(constructorContacto.obtenerLikesContacto(Mascotas.get(0)));
        Mascotas.get(1).setLike(constructorContacto.obtenerLikesContacto(Mascotas.get(1)));
        Mascotas.get(2).setLike(constructorContacto.obtenerLikesContacto(Mascotas.get(2)));
        Mascotas.get(3).setLike(constructorContacto.obtenerLikesContacto(Mascotas.get(3)));
        Mascotas.get(4).setLike(constructorContacto.obtenerLikesContacto(Mascotas.get(4)));
    }



}
