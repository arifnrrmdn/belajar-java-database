package iifrmdn.unikom.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Driver;
import java.sql.SQLException;

public class DriverTest {

    @Test
    void testRegister() {
        try{
            Driver mysqlDriver = new com.mysql.cj.jdbc.Driver();
        }catch (SQLException exception) {
            Assertions.fail(exception);
        }
    }

}
