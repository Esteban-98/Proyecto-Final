package ModuloVentas.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Modelo.ConsultaVenta;



public class Pago extends JDialog {
	
	private JPanel contentPane;
	private JTextField textFieldTotalP;
	private JTextField textFieldRecibido;
	private JTextField textFieldCambio;
	private ConsultaVenta obtenerIdVenta; 
	private Venta idVenta;


	/**
	 * Create the frame.
	 */
	public Pago() {
		
		setBounds(100, 100, 450, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Efectuar Pago");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel.setFont(new Font("Lao UI", Font.BOLD, 28));
		lblNewLabel.setBounds(59, 11, 309, 38);
		panel.add(lblNewLabel);
		
		JTextPane txtpnTotalAPagar = new JTextPane();
		txtpnTotalAPagar.setEditable(false);
		txtpnTotalAPagar.setForeground(SystemColor.inactiveCaptionText);
		txtpnTotalAPagar.setFont(new Font("Lao UI", Font.BOLD, 20));
		txtpnTotalAPagar.setText("Total a Pagar");
		txtpnTotalAPagar.setBounds(140, 60, 139, 38);
		panel.add(txtpnTotalAPagar);
		
		textFieldTotalP = new JTextField();
		textFieldTotalP.setEditable(false);
		textFieldTotalP.setBounds(150, 104, 129, 28);
		panel.add(textFieldTotalP);
		textFieldTotalP.setColumns(10);
		textFieldTotalP.setText(" $ "+ Venta.getTotal());
		
		
		JTextPane txtpnRecibido = new JTextPane();
		txtpnRecibido.setEditable(false);
		txtpnRecibido.setText("Recibido");
		txtpnRecibido.setForeground(SystemColor.inactiveCaptionText);
		txtpnRecibido.setFont(new Font("Lao UI", Font.BOLD, 20));
		txtpnRecibido.setBounds(160, 139, 88, 28);
		panel.add(txtpnRecibido);
		
		textFieldRecibido = new JTextField();
		textFieldRecibido.setColumns(10);
		textFieldRecibido.setBounds(150, 178, 129, 28);
		panel.add(textFieldRecibido);
		textFieldRecibido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double R = (Double.parseDouble(textFieldRecibido.getText()));
				 if(R < Venta.getTotal()) {
					 JOptionPane.showMessageDialog(null, "El monto de dinero recibido es inferior al pago.  ", "Advertencia", JOptionPane.WARNING_MESSAGE);
					 textFieldRecibido.setText(null);
				 }else {
					 double C =0.0;
					 
					 C=R-Venta.getTotal();
					 textFieldCambio.setText(" $ "+String.valueOf(C));
				 }
				
			}
		});
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//obtenerIdVenta.insertarIdVenta();
				
		        Connection con = Conexion.getConexion();
				try {
					String idVenta = Venta.getIdCajero();
					
					for(int i=0; i<Venta.tableListaP.getRowCount();i++) {
						PreparedStatement pst = con.prepareStatement("INSERT INTO detalle_venta(id_venta, id_producto, cantidad_vendida) VALUES (?,?,?)");
						
						pst.setString(1,  idVenta);
						pst.setString(2,  (String) Venta.tableListaP.getValueAt(i,0));
						pst.setString(3,  (String) Venta.tableListaP.getValueAt(i,3));
						pst.executeUpdate();
						
					}
					
					
				}
				catch(SQLException e1){
					System.out.println(e1.getMessage());
					
				}finally{
			        try{
			            con.close();
			        }catch(SQLException ex){
			        System.err.println(ex);
			        }
			        }	
				limpiar();
				limpiarTabla();
				dispose();
			}
		});
		btnContinuar.setForeground(Color.WHITE);
		btnContinuar.setFont(new Font("Lao UI", Font.BOLD, 15));
		btnContinuar.setBackground(Color.DARK_GRAY);
		btnContinuar.setBounds(90, 326, 116, 28);
		panel.add(btnContinuar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				limpiar();
				limpiarTabla();
				dispose();
				
				
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Lao UI", Font.BOLD, 15));
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(200, 326, 116, 28);
		panel.add(btnCancelar);
		
		
		
		JTextPane txtpnCambio = new JTextPane();
		txtpnCambio.setText("Cambio");
		txtpnCambio.setForeground(SystemColor.inactiveCaptionText);
		txtpnCambio.setFont(new Font("Lao UI", Font.BOLD, 20));
		txtpnCambio.setEditable(false);
		txtpnCambio.setBounds(160, 214, 88, 28);
		panel.add(txtpnCambio);
		
		textFieldCambio = new JTextField();
		textFieldCambio.setEditable(false);
		textFieldCambio.setColumns(10);
		textFieldCambio.setBounds(150, 253, 129, 28);
		panel.add(textFieldCambio);
		
	
		
	}
	
	public void limpiar() {
		idVenta.textFieldImpuesto.setText("");
		idVenta.textFieldSubtotal.setText("");
		idVenta.textFieldTotal.setText("");
	}
	
	public void limpiarTabla(){
        DefaultTableModel tb = (DefaultTableModel) Venta.tableListaP.getModel();
        int a = Venta.tableListaP.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
        
    }
	
	
}
