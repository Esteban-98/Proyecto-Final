package ModuloVentas.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.mysql.cj.jdbc.result.ResultSetMetaData;


import ModuloVentas.Venta.Conexion;
import ModuloVentas.Venta.Venta;


public class VerInventario extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scrollPane;
	private JTable table;
	
	DefaultTableModel m;
	



	public VerInventario() {
	        initComponents();
	        PreparedStatement ps = null;
            ResultSet rs = null;
            
            Connection con = Conexion.getConexion();
	        
	        String where = ""; 
	         try{
	            
	            DefaultTableModel modelo = new DefaultTableModel();
	            table.setModel(modelo);
	            
	            
	            String sql ="SELECT id_producto, nombre, cantidad, precio_venta FROM producto" + where;
	            System.out.println(sql);
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            
	            ResultSetMetaData rsMd  = (ResultSetMetaData) rs.getMetaData();
	            int cantidadColumnas= rsMd.getColumnCount();
	            modelo.addColumn("ID Producto");
	            modelo.addColumn("Descripcion");
	            modelo.addColumn("Stock");
	            modelo.addColumn("Costo Unitario");
	           
	           
	            
	            int [] anchos = {100,100,100,100,100,100};
	            for (int x=0; x<cantidadColumnas;x++){
	            
	               table.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
	            }
	            
	            while(rs.next()){
	            
	                Object[]filas = new Object[cantidadColumnas];
	                
	                for (int i=0; i< cantidadColumnas; i++){
	                filas[i]= rs.getObject(i+1);
	                }
	                modelo.addRow(filas);
	                
	                
	            }
	        }
	        catch(SQLException ex){
	            System.err.println(ex.toString());
	        }finally{
	            try{
	            	con.close();
	            }catch(SQLException ex){
	            System.err.println(ex);
	            }
	            } 
	    }
	
	public void initComponents() {
		getContentPane().setBackground(SystemColor.textHighlightText);
		setBounds(100, 100, 830, 444);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 37, 814, 312);
		contentPanel.setBackground(SystemColor.textHighlightText);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		{
			scrollPane = new JScrollPane();
			scrollPane.setViewportBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			scrollPane.setAlignmentX(Component.RIGHT_ALIGNMENT);
		}
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		{
			table = new JTable();
			table.setBackground(SystemColor.control);
			
			table.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, ""},
					
				},
				new String[] {
					"ID Producto", "Descripcion", "Costo Unitario", "Stock", "Agregar"
				}
			));
			scrollPane.setViewportView(table);
		}
		{
			JLabel lblBuscarProducto = new JLabel("BUSCAR PRODUCTO");
			lblBuscarProducto.setBounds(0, 0, 814, 37);
			getContentPane().add(lblBuscarProducto);
			lblBuscarProducto.setHorizontalAlignment(SwingConstants.CENTER);
			lblBuscarProducto.setFont(new Font("Lao UI", Font.BOLD, 27));
			lblBuscarProducto.setForeground(SystemColor.inactiveCaptionText);
		}
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(Color.DARK_GRAY);
		btnAgregar.setBackground(new java.awt.Color(0,0,0));
		btnAgregar.setFont(new Font("Lao UI", Font.BOLD, 16));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSelc = table.getSelectedRow();
				try {
					String idProducto,descripcion,coste,cant,total,stock;
					double calcular=0.0, imp=0.0;
					double totalPorProducto=0.0;
					
					 if(filaSelc==-1) {
						 JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);	 
					 }else {
						 // seleccionar valores de la tabla buscar producto  
						 m=(DefaultTableModel) table.getModel();
						 idProducto=table.getValueAt(filaSelc, 0).toString();
						 descripcion=table.getValueAt(filaSelc, 1).toString();
						 
						 coste=table.getValueAt(filaSelc, 3).toString();
						 cant=Venta.getCantidad();
						 totalPorProducto=(Double.parseDouble(coste)*Integer.parseInt(Venta.getCantidad()));
						 total=String.valueOf(totalPorProducto);
						 
						 m=(DefaultTableModel) Venta.getTableListaP().getModel();
						 String filaElemt []= {idProducto,descripcion,coste,cant,total};
						 m.addRow(filaElemt);
						 
						 	Venta.setTotal(totalPorProducto + Venta.getTotal()); 
						 	imp=Venta.getTotal()*0.05;
						 	Venta.setImpuesto(imp);
				        	Venta.setSubtotal(Venta.getTotal() -imp );
				        	
				        	Venta.textFieldTotal.setText(" $ "+ Venta.getTotal());
				        	Venta.textFieldSubtotal.setText(" $ "+ Venta.getSubtotal());
				        	Venta.textFieldImpuesto.setText(" $ "+ Venta.getImpuesto());
				     
						 
					 }
				} catch (Exception a) {
					
				}  
				
				Venta.getTextCantidad().setText(null);
				dispose();
			}	
		});
		btnAgregar.setBounds(355, 360, 98, 35);
		getContentPane().add(btnAgregar);
	}
	
	
	

}
