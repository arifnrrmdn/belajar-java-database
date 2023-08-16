package iifrmdn.unikom.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

    @BeforeAll
    static void beforAll() {
        try{
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
        }catch(SQLException exception) {
            exception.printStackTrace();
        }
    }



    @Test
    void testConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "toor";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Sukses konek ke database anjay...");
        }catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    void testConnectionClose() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "toor";

        try{
            Connection connection = DriverManager.getConnection(jdbcUrl,username,password);
            System.out.println("Sukses konek ke database..");

            // menutup koneksi
            connection.close();
            System.out.println("Sukses menutup koneksi..");

        }catch(SQLException exception) {
            Assertions.fail(exception);
        }
    }

    @Test
    //menutup koneksi dengan try with resource
    void testConnectionCloseWithTryWithResource() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/belajar_java_database";
        String username = "root";
        String password = "toor";

        // otomatis menutup koneksi dengan try with resource
        try(Connection connection = DriverManager.getConnection(jdbcUrl,username,password)) {

            System.out.println("Sukses Konek ke Database..");

        }catch (SQLException exception){
            Assertions.fail(exception);
        }

    }

}
