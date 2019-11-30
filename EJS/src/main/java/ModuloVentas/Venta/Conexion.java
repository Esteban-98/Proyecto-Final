package ModuloVentas.Venta;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static final String USERNAME="admin";
    public static final String PASSWORD="MalditoDavidd1";
    public static final String URL="jdbc:mysql://inventario.csug2jfbrn9j.us-east-2.rds.amazonaws.com/proyecto_final_arquitectura"+"?useTimezone=true&serverTimezone=UTC";
 
        public static Connection getConexion() {
		
		Connection con =null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			
		}
		
		 catch (HeadlessException | ClassNotFoundException | SQLException e) {
                     
			 System.out.println(e);
		 }
		return con;
		
		
				
		}

}
