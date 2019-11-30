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

import static Modelo.Conexion.getConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasProducto extends Conexion {
    
    public boolean registrar(Producto pro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO producto (nombre, cantidad, precio_venta) VALUES (?,?,?) ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getCantidad());
            ps.setDouble(3, pro.getPrecio());
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
    
    public boolean modificar(Producto pro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "UPDATE producto SET nombre=?, cantidad=?, precio_venta=? WHERE id_producto=? ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setInt(2, pro.getCantidad());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getId());
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
    
    public boolean eliminar(Producto pro){
        
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM producto WHERE id_producto=? ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
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
    
    public boolean buscar (Producto pro){
        
        PreparedStatement ps = null;
        ResultSet rs=null;
        Connection con = getConexion();
        
        String sql = "SELECT * FROM producto WHERE id_producto=? ";
        
        try{
            ps =con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
            pro.setId(Integer.parseInt(rs.getString("id_producto")));    
            pro.setNombre(rs.getString("nombre"));
            pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            pro.setPrecio(Double.parseDouble(rs.getString("precio_venta")));
            
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
