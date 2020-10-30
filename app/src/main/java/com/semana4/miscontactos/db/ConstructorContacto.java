
package com.semana4.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;

import com.semana4.miscontactos.R;
import com.semana4.miscontactos.pojo.Contacto;
import java.util.ArrayList;



public class ConstructorContacto {

    private static final int LIKE = 1;

    private Context context;
    public ConstructorContacto(Context context) {
        this.context = context;
    }

    public ArrayList<Contacto> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarSeisContactos(db);
        return db.obtenerTodosLosContactos();
    }

    public void insertarSeisContactos (BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Cougar");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.cougar);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Cat");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.cat);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Bear");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.bear);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Artic fox");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.artic_fox);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Ant");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.ant);
        db.insertarContacto(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PETS_NOMBRE, "Cheetah");
        contentValues.put(ConstantesBD.TABLE_PETS_FOTO, R.drawable.cheetah);
        db.insertarContacto(contentValues);
    }


    public int darLikeContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_ID_PET, contacto.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertarLikeContacto(contentValues);

        return contacto.getId();
        
    }


    public int obtenerLikesContacto(Contacto contacto){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }



}
