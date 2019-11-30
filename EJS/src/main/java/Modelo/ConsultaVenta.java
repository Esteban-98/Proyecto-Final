package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ModuloVentas.Venta.Conexion;
import ModuloVentas.Venta.Venta;

public class ConsultaVenta extends Conexion{
	
	public boolean insertarIdVenta() {
		
		PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO venta (id_vendedor) VALUES (?) ";
        
        try{
        	ps = con.prepareStatement(sql);
        	ps.setString(1, Venta.getIdCajero());
        	ps.execute();
        	return true;
        	
        	

        
        }catch (SQLException e){
            
            System.err.print(e);
            return false;
            
        }finally{
        try{
            con.close();
        }catch(SQLException ex){
        System.err.println(ex);
        }
        } 
        
        
		
	}
	
	

}
