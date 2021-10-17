package com.fabiano.appformularion1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FormularioDAO {

    public static void insert(Context contexto, Formulario formulario){
        BancoDeDados banco = new BancoDeDados(contexto);

        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put( "nome", formulario.getNome() );
        valores.put( "email", formulario.getEmail() );
        valores.put( "profissao", formulario.getProfissao() );

        db.insert("formularios" , null , valores );
    }

    public static void edt(Context contexto, Formulario formulario){
        BancoDeDados banco = new BancoDeDados(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put( "nome", formulario.getNome() );
        valores.put( "email", formulario.getEmail() );
        valores.put( "profissao", formulario.getProfissao());

        db.update("formularios", valores,
                " id = " + formulario.getId(), null);
    }

    public static void delete(Context contexto, int idFormulario){
        BancoDeDados banco = new BancoDeDados(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("formularios", " id = " + idFormulario,
                null);
    }

    public static List<Formulario> getFormulario(Context contexto){
        List<Formulario> form = new ArrayList<>();
        BancoDeDados banco = new BancoDeDados(contexto);
        SQLiteDatabase db = banco.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM formularios ORDER BY nome",
                null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Formulario f = new Formulario();
                f.setId(  cursor.getInt( 0 ) );
                f.setNome( cursor.getString( 1 ) );
                f.setProfissao( cursor.getString( 2 ) );
                f.setEmail( cursor.getString( 3 ) );
                form.add( f );
            }while ( cursor.moveToNext() );
        }
        return form;
    }

    public static Formulario getFormularioById(Context contexto, int idForm){
        BancoDeDados banco = new BancoDeDados(contexto);
        SQLiteDatabase db = banco.getReadableDatabase();

        String sql = "SELECT * FROM formularios WHERE id = " + idForm;
        Cursor cursor = db.rawQuery( sql ,null);

        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Formulario p = new Formulario();
            p.setId(  cursor.getInt( 0 ) );
            p.setNome( cursor.getString( 1 ) );
            p.setEmail( cursor.getString( 2 ) );
            p.setProfissao( cursor.getString( 2 ) );

            return p;
        }else {
            return null;
        }
    }

}