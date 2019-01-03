package com.fvaras.ale.homelessmiaus.db;

/**
 * Created by Alejandro on 01-11-2017.
 */

public class ProviderContract {

    public static final String TABLE_PROVIDERS           = "proveedor";
    public static final String TABLE_PROVIDERS_ID        = "id";
    public static final String TABLE_PROVIDERS_NOMBRE_EMPRESA   = "nombre_empresa";
    public static final String TABLE_PROVIDERS_TELEFONO  = "telefono";
    public static final String TABLE_PROVIDERS_EMAIL     = "email";
    public static final String TABLE_PROVIDERS_GIRO     = "giro";
    public static final String TABLE_PROVIDERS_RAZONSOCIAL     = "razon_social";
    public static final String TABLE_PROVIDERS_DIRECCION     = "direccion";


    private ProviderContract() {
    }

    public static final String SQL_CREATE_ENTRIES_PROVIDERS = "CREATE TABLE " + TABLE_PROVIDERS  + "(" +
            TABLE_PROVIDERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            TABLE_PROVIDERS_NOMBRE_EMPRESA + " TEXT, " +
            TABLE_PROVIDERS_TELEFONO + " TEXT, " +
            TABLE_PROVIDERS_EMAIL + " TEXT, " +
            TABLE_PROVIDERS_GIRO + " TEXT, " +
            TABLE_PROVIDERS_RAZONSOCIAL + " TEXT, " +
            TABLE_PROVIDERS_DIRECCION + " TEXT " +
            ")";


    public static final String SQL_DELETE_TABLE_PROVIDERS="DROP TABLE IF EXIST"+TABLE_PROVIDERS;

}
