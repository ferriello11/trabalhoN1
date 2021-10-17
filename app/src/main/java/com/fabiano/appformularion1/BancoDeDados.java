package com.fabiano.appformularion1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados  extends SQLiteOpenHelper {

    private static final int VERSAO = 1;
    private static final String NOME = "AppFormularioN12";

    public BancoDeDados(Context contexto){
        super(contexto, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS formularios ( " +
                " id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT ," +
                " nome TEXT ," +
                " email TEXT ," +
                " profissao TEXT );");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int versaoAntiga, int novaVersao) {
    }
}
