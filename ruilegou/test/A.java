import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class A {
    public static void main(String[] args) throws SQLException {

            ComboPooledDataSource co = new ComboPooledDataSource();
            Connection connection = co.getConnection();
            String sql = "select * from users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        }


}
