package iifrmdn.unikom.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import iifrmdn.unikom.database.util.ConnectionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPoolTest {

    @Test
    void testHikariCP() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:mysql://localhost:3306/belajar_java_database");
        config.setUsername("root");
        config.setPassword("toor");

        //konfigurasi
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setIdleTimeout(60_000);
        config.setMaxLifetime(10 & 60_000);

        try {
            HikariDataSource hikariDataSource = new HikariDataSource(config);
            Connection connection = hikariDataSource.getConnection();
            System.out.println("Sukses mengambil koneksi");

            connection.close();
            System.out.println("Sukses mengembalikan koneksi");

            hikariDataSource.close();
            System.out.println("Sukses menutup pool");

        }catch (SQLException exception) {
            Assertions.fail(exception);
        }

    }

    @Test
    void testUtil() throws SQLException{
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        System.out.println("Sukses mengambil koneksi");
        connection.close();
        System.out.println("Sukses mengembalikan koneksi");

    }


}
