
package Conexion;
import java.sql.Connection;
import com.mysql.jdbc.jdbc2.optional.*;
//import com.microsoft.sqlserver.jdbc.*;
//import java.sql.SQLException;
import javax.swing.*;


public class ClsConexion {
   private static Connection cnxmysql = null;
   //private static Connection cnxsql = null;
   
   public Connection getConnection(){
       try {
           // MYSQL Server
           MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
           ds.setServerName("localhost"); //ip,nombre,domino
           ds.setPort(3306);
           ds.setDatabaseName("db_sistema");
           cnxmysql = ds.getConnection("root","");
           
           // SQL Server
//           SQLServerDataSource ds2 = new SQLServerConnectionPoolDataSource();
//           ds2.setServerName("localhost"); //ip,nombre,domino
//           ds2.setInstanceName("MSSQLSERVER");
//           ds2.setPortNumber(1433);
//           ds2.setDatabaseName("db_sistema");
//           cnxsql = ds2.getConnection("sa","");
           
       } catch (Exception e) {
           JOptionPane.showMessageDialog(null,"Error de conexión a la BD");
       }
       return cnxmysql;
   }
}
