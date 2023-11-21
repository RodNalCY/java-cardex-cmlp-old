package com.cmlp.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * ?useUnicode=true: Este parámetro se utiliza para indicar que se debe usar
 * Unicode en la conexión. Unicode es un estándar de codificación de caracteres
 * que abarca la mayoría de los caracteres del mundo.
 * 
 * &characterEncoding=UTF-8: Este parámetro especifica la codificación de
 * caracteres que se debe usar en la conexión. En este caso, se establece en
 * UTF-8, que es una codificación de caracteres ampliamente utilizada y
 * compatible con una amplia variedad de caracteres.
 *
 * &useJDBCCompliantTimezoneShift=true: Este parámetro se refiere al manejo del
 * cambio de zona horaria de manera compatible con JDBC (Java Database
 * Connectivity). Puede ser útil en situaciones en las que se trabaja con fechas
 * y horas y se desea un manejo adecuado de las zonas horarias.
 *
 * &useLegacyDatetimeCode=false: Este parámetro indica si se debe utilizar el
 * código de fecha y hora heredado. Establecerlo en false significa que se
 * utilizará un código de fecha y hora más moderno y compatible.
 *
 * &serverTimezone=UTC: Este parámetro establece la zona horaria del servidor de
 * base de datos. En este caso, se configura en UTC (Tiempo Universal
 * Coordinado), que es una zona horaria estándar. Este ajuste puede ser
 * importante para garantizar la coherencia en las operaciones de fecha y hora
 * entre la aplicación y el servidor de base de datos.
 */
public class DBConexion {

    private static String DRIVER = "com.mysql.jdbc.Driver";
    private static String USUARIO = "root";
    private static String PASSWORD = "@Local_2021.";
    private static String URL = "jdbc:mysql://localhost:3306/dbcajacmlp";
    private static String PARAMS = "?serverTimezone=UTC";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL DRIVER: " + e);
        }
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            System.out.println("URL de conexion: " + URL+PARAMS);
            connection = DriverManager.getConnection(URL + PARAMS, USUARIO, PASSWORD);
            System.out.println("Se conecto exitosamente a Mysql !!!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR EN LA CONEXION: " + e.getLocalizedMessage());
        }
        return connection;
    }
}
