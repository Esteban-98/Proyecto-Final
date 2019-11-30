/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author CAMILO
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasEmpleado extends Conexion {
    
        public boolean registrar(Empleado emp){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO empleado (identificacion, nombre, sueldo) VALUES (?,?,?) ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setString(1, emp.getIdentificacion());
            ps.setString(2, emp.getNombre());
            ps.setDouble(3, emp.getSueldo());
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
        //----------------------------------------------------------------------
        
public boolean modificar(Empleado emp){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE empleado SET identificacion=?, nombre=?, sueldo=? WHERE id_empleado=? ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setString(1, emp.getIdentificacion());
            ps.setString(2, emp.getNombre());
            ps.setDouble(3, emp.getSueldo());
            ps.setInt(4, emp.getId());
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
//--------------------------------------------------------------------------------

    public boolean eliminar(Empleado emp){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM empleado WHERE id_empleado=? ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setInt(1, emp.getId());
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
 
    //----------------------------------------------------------------------------
    
        public boolean buscar (Empleado emp){
        
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM empleado WHERE id_empleado=? ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setInt(1, emp.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
            emp.setId(Integer.parseInt(rs.getString("id_empleado"))); 
            emp.setIdentificacion(rs.getString("identificacion"));
            emp.setNombre(rs.getString("nombre"));
            emp.setSueldo(Double.parseDouble(rs.getString("sueldo")));
            
            return true;
        }else{
            
            return false;
        }
        
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
