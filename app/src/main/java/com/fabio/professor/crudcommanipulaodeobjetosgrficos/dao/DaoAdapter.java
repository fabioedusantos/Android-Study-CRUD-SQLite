package com.fabio.professor.crudcommanipulaodeobjetosgrficos.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DaoAdapter extends SQLiteOpenHelper {
    public static final String BANCO = "aula";
    public static final int VERSAO = 1;

    private static final String queryDelete[] = {
            "DROP TABLE IF EXISTS usuarios;"
    };

    private static final String query[] = {
            "CREATE TABLE IF NOT EXISTS usuarios ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nome VARCHAR(30) NOT NULL,"
                    + "senha VARCHAR(100) NOT NULL"
                    + ");"
    };

    public DaoAdapter(Context context) {
        super(context, BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        for (int i = 0; i < query.length; i++) db.execSQL(query[i]);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        for (int i = 0; i < queryDelete.length; i++) db.execSQL(queryDelete[i]);
        onCreate(db);
    }
}
