package iifrmdn.unikom.database;

import iifrmdn.unikom.database.util.ConnectionUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrepareStatementTest {

    @Test
    void testPrepareStatement() throws SQLException {
        Connection connection = ConnectionUtil.getDataSource().getConnection();
        String username = "admin'; #";
        String password = "salah";

        String sql = "SELECT * FROM admin WHERE username = ? AND password = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            System.out.println("Sukses login");
        }else {
            System.out.println("Gagal login");
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
