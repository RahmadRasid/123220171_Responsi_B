
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Lab Informatika
 */
public class GymModel implements Calculation {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/gym";
    static final String USER = "root";
    static final String PASS = "";
    Connection connection;
    Statement statement;
    private Object resultSet;
    public GymModel(){
        try{
            Class.forName(JDBC_DRIVER);
            connection = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Connection Success");
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
            System.out.println("Connection Failed");
        }
        }

    @Override
    public double average(double nomor_telepon, double waktu_sewa, double biaya_sewa) {
        return ((waktu_sewa+biaya_sewa)*2)+1;
        public int getGymData() throws SQLException{
            try{
                int totalData = 0;
                String query = "SELECT * FROM `member`";
                statement = connection.createStatement();
                ResultSet resultset = statement.executeQuery(query);
                while(resultSet.next()){
                    totalData++;
                }
                statement.close();
                return totalData;
            }catch(SQLException ex){
                System.out.println("Error:"+ex.getMessage());
            }
        return 0;
    }
    }
}
