package com.example.appl_notas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class conexionSQLiteHelper extends SQLiteOpenHelper {

    final String CREAR_TABLA="CREATE TABLE datos(nota_1 DOUBLE,nota_2 Double,nota_p Double,nota_ot Double,pnota_1 DOUBLE,pnota_2 Double,pnota_p Double,pnota_ot Double,asignatura TEXT)";

    public conexionSQLiteHelper(@androidx.annotation.Nullable Context context, @androidx.annotation.Nullable String name, @androidx.annotation.Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS datos");
        onCreate(db);
    }
}
