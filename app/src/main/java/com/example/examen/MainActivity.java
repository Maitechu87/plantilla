package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        entryPostgres.start();
    }

    Thread entryPostgres = new Thread(){
        public void run(){
            Connection conn = null;
            try {
                Class.forName("org.postgresql.Driver");
                //importante / final de la ip
                conn = DriverManager.getConnection("jdbc:postgresql://192.168.0.22/", "angela", "ruizrobles");

                Statement st = conn.createStatement();
                //para crear tabla, execute
                st.execute(CREATE_POSTGRES);

                st.executeUpdate("INSERT INTO MAITE (ENTRADA,SALIDA) VALUES ('HOLA','ADIOS')");

                




            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();

                //siempre hay que cerrar la conexión
            } finally {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    };

    //maite es el nombre de la tabla
    //poner ejemplos de todos los tipos INT, VARCHAR Y TAL
    private static final String CREATE_POSTGRES = "CREATE TABLE IF NOT EXISTS MAITE"
            + "("
            +  "Entrada TEXT,"
            +  "Salida TEXT,"
            + "UNIQUE (" + "Entrada" + "))";
}

