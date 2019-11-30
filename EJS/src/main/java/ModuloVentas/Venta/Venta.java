package ModuloVentas.Venta;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class Venta extends JFrame{
	
	private JPanel contentPane;
	private static JTextField textCantidad;
	private JTextField textFieldCodigo;
	static JTable tableListaP;
	private static String cantidad;
	private static double Total;
	private static double Subtotal;
	private static double impuesto;
	private static String idCajero;
	private JTextField textFieldidVenta;
	static JTextField textFieldImpuesto;
	static JTextField textFieldSubtotal;
	static JTextField textFieldTotal;
	private JTextField textFieldIdCajero;
	private JTextField textFielIdNegocio;
	
	DefaultTableModel m;
	int tStock=0;
	
	
	public static String getCantidad() {
		return cantidad;
	}

	public static void setCantidad(String cantidad) {
		Venta.cantidad = cantidad;
	}
	public static double getImpuesto() {
		return impuesto;
	}

	public static void setImpuesto(double impuesto) {
		Venta.impuesto = impuesto;
	}
	public static double getTotal() {
		return Total;
	}

	public static void setTotal(double total) {
		Total = total;
	}

	public static double getSubtotal() {
		return Subtotal;
	}

	public static void setSubtotal(double subtotal) {
		Subtotal = subtotal;
	}
	
	public static JTextField getTextCantidad() {
		return textCantidad;
	}

	public static JTextField getTextFieldSubtotal() {
		return textFieldSubtotal;
	}

	public static void setTextFieldSubtotal(JTextField textFieldSubtotal) {
		textFieldSubtotal = textFieldSubtotal;
	}

	public static JTextField getTextFieldTotal() {
		return textFieldTotal;
	}

	public static void setTextFieldTotal(JTextField textFieldTotal) {
		textFieldTotal = textFieldTotal;
	}

	public void setTextCantidad(JTextField textCantidad) {
		this.textCantidad = textCantidad;
	}

	public static JTable getTableListaP() {
		return tableListaP;
	}

	public void setTableListaP(JTable tableListaP) {
		this.tableListaP = tableListaP;
	}
	public static JTextField getTextFieldImpuesto() {
		return textFieldImpuesto;
	}

	public void setTextFieldImpuesto(JTextField textFieldImpuesto) {
		this.textFieldImpuesto = textFieldImpuesto;
	}

	
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Venta frame = new Venta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Venta() {
		
		setTitle("Realizar Venta");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 830, 620);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 814, 582);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextPane txtpnCantidad = new JTextPane();
		txtpnCantidad.setBounds(64, 57, 88, 33);
		txtpnCantidad.setEditable(false);
		txtpnCantidad.setForeground(SystemColor.inactiveCaptionText);
		txtpnCantidad.setFont(new Font("Lao UI", Font.BOLD, 18));
		txtpnCantidad.setText("Cantidad");
		panel.add(txtpnCantidad);
		
		JTextPane txtpnCodigoDe = new JTextPane();
		txtpnCodigoDe.setBounds(53, 101, 103, 56);
		txtpnCodigoDe.setEditable(false);
		txtpnCodigoDe.setForeground(SystemColor.inactiveCaptionText);
		txtpnCodigoDe.setBackground(Color.WHITE);
		txtpnCodigoDe.setFont(new Font("Lao UI", Font.BOLD, 18));
		txtpnCodigoDe.setText("Codigo de producto");
		panel.add(txtpnCodigoDe);
		
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(295, 117, 27, 35);
		textPane.setEditable(false);
		textPane.setForeground(SystemColor.inactiveCaptionText);
		textPane.setFont(new Font("Lao UI", Font.BOLD, 18));
		textPane.setText("ó");
		panel.add(textPane);
		
		JButton btnVerInventario = new JButton("Ver Inventario");
		btnVerInventario.setBounds(328, 119, 137, 25);
		btnVerInventario.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			/**ver Venatana de inventario 
			 *   
			 **/
				try {
					VerInventario dialog = new VerInventario();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception ev) {
					ev.printStackTrace();
				}
				
				
			}
		});
		btnVerInventario.setForeground(Color.WHITE);
		btnVerInventario.setBackground(Color.DARK_GRAY);
		btnVerInventario.setBackground(new java.awt.Color(0, 0, 0));
		btnVerInventario.setFont(new Font("Lao UI", Font.BOLD, 13));
		panel.add(btnVerInventario);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(298, 11, 6, 20);
		panel.add(textPane_1);
		
		textCantidad = new JTextField();
		textCantidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setCantidad(textCantidad.getText());
			}
		});
		textCantidad.setBounds(161, 68, 103, 20);
		panel.add(textCantidad);
		textCantidad.setColumns(10);
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getSource()==textFieldCodigo) {
					
				}
			}	
		});
		
		textFieldCodigo = new JTextField();
		textFieldCodigo.setBounds(161, 122, 103, 20);
		panel.add(textFieldCodigo);
		textFieldCodigo.setColumns(10);
		textFieldCodigo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel modelo = (DefaultTableModel) getTableListaP().getModel();	
				PreparedStatement ps = null;
				ResultSet rs = null;
				Connection con = Conexion.getConexion();
				try{
					ps= con.prepareStatement("SELECT id_producto, nombre, cantidad, precio_venta FROM  producto WHERE id_producto = ?");
					ps.setString(1, textFieldCodigo.getText());
					rs=ps.executeQuery();

					modelo.setColumnIdentifiers(new Object [] {"Id Producto", "Nombre", "Coste Unitario", "Cantidad", "Total"});

					if(rs.next()){
						double totalPorProducto=0.0, imp=0.0;

						String coste = rs.getString("precio_venta").toString();
						String stock =rs.getString("cantidad" ).toString();

						tStock=(Integer.parseInt(stock)-Integer.parseInt(cantidad));
						System.out.println(tStock);

						totalPorProducto=(Double.parseDouble(coste)*Integer.parseInt(cantidad));

						modelo.addRow(new Object [] {rs.getString("id_Producto"), rs.getString("nombre"), rs.getString("precio_venta"), getCantidad(),totalPorProducto});

						Total=Total+totalPorProducto;
						imp=Total*0.05;
						impuesto = imp;
						Subtotal= Total-imp;



						textFieldTotal.setText(" $  "+ Total);

						textFieldSubtotal.setText(" $ "+ Subtotal);

						textFieldImpuesto.setText(" $ "+ impuesto);



					}else{
						JOptionPane.showMessageDialog(null, "No se pudo encontrar el producto");

					}
					getTableListaP().setModel(modelo);

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

				getTextCantidad().setText(null);
				textFieldCodigo.setText(null);

			}


		});
		
		JPanel panelTablaListaP = new JPanel();
		panelTablaListaP.setBounds(37, 231, 738, 340);
		panel.add(panelTablaListaP);
		panelTablaListaP.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTablaListaP = new JLabel("LISTA DE PRODUCTOS");
		lblTablaListaP.setForeground(SystemColor.inactiveCaptionText);
		lblTablaListaP.setFont(new Font("Lao UI", Font.BOLD, 18));
		lblTablaListaP.setHorizontalAlignment(SwingConstants.CENTER);
		panelTablaListaP.add(lblTablaListaP, BorderLayout.NORTH);
		
		JScrollPane scrollPaneTablaListaP = new JScrollPane();
		panelTablaListaP.add(scrollPaneTablaListaP, BorderLayout.CENTER);
		
		
		setTableListaP(new JTable());
		
		getTableListaP().setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id Producto", "Descripcion", "Coste Unitario", "Cantidad", "Total"
			}
		));
		scrollPaneTablaListaP.setViewportView(getTableListaP());
		
		textFieldidVenta = new JTextField();
		textFieldidVenta.setBounds(649, 16, 86, 20);
		panel.add(textFieldidVenta);
		textFieldidVenta.setColumns(10);
		
		textFieldImpuesto = new JTextField();
		textFieldImpuesto.setEnabled(false);
		textFieldImpuesto.setBounds(687, 68, 98, 20);
		textFieldImpuesto.setFont(new Font("Lao UI", Font.BOLD, 16));
		panel.add(textFieldImpuesto);
		textFieldImpuesto.setColumns(10);
		
		textFieldSubtotal = new JTextField();
		textFieldSubtotal.setEnabled(false);
		textFieldSubtotal.setBounds(687, 106, 98, 20);
		textFieldSubtotal.setFont(new Font("Lao UI", Font.BOLD, 16));
		panel.add(textFieldSubtotal);
		textFieldSubtotal.setColumns(10);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setEnabled(false);
		textFieldTotal.setBounds(687, 137, 98, 20);
		textFieldTotal.setFont(new Font("Lao UI", Font.BOLD, 16));
		panel.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		textFieldIdCajero = new JTextField();
		textFieldIdCajero.setColumns(10);
		textFieldIdCajero.setBounds(420, 16, 103, 20);
		panel.add(textFieldIdCajero);
		idCajero = textFieldIdCajero.getText();
		

		
		JTextPane textPaneImpuesto = new JTextPane();
		textPaneImpuesto.setText("Impuesto :");
		textPaneImpuesto.setEditable(false);
		textPaneImpuesto.setForeground(SystemColor.inactiveCaptionText);
		textPaneImpuesto.setFont(new Font("Lao UI", Font.BOLD, 18));
		textPaneImpuesto.setBounds(576, 56, 88, 33);
		panel.add(textPaneImpuesto);
		
		JTextPane textPaneSubtotal = new JTextPane();
		textPaneSubtotal.setText("Subtotal :");
		textPaneSubtotal.setEditable(false);
		textPaneSubtotal.setForeground(SystemColor.inactiveCaptionText);
		textPaneSubtotal.setFont(new Font("Lao UI", Font.BOLD, 18));
		textPaneSubtotal.setBounds(576, 93, 88, 33);
		panel.add(textPaneSubtotal);
		
		JTextPane textPaneTotal = new JTextPane();
		textPaneTotal.setText("Total :");
		textPaneTotal.setEditable(false);
		textPaneTotal.setForeground(SystemColor.inactiveCaptionText);
		textPaneTotal.setFont(new Font("Lao UI", Font.BOLD, 18));
		textPaneTotal.setBounds(576, 124, 88, 33);
		panel.add(textPaneTotal);
		
		JTextPane txtpnIdVenta = new JTextPane();
		txtpnIdVenta.setText("Nº Venta");
		txtpnIdVenta.setEditable(false);
		txtpnIdVenta.setForeground(SystemColor.inactiveCaptionText);
		txtpnIdVenta.setFont(new Font("Lao UI", Font.BOLD, 15));
		txtpnIdVenta.setBounds(574, 11, 70, 25);
		panel.add(txtpnIdVenta);
		
		JButton btnPago = new JButton("PAGAR");
		btnPago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Pago frame = new Pago();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnPago.setForeground(Color.WHITE);
		btnPago.setFont(new Font("Lao UI", Font.BOLD, 13));
		btnPago.setBackground(Color.DARK_GRAY);
		btnPago.setBounds(614, 168, 121, 25);
		panel.add(btnPago);
		
		
		JTextPane txtpnIdCajero = new JTextPane();
		txtpnIdCajero.setText("ID Cajero");
		txtpnIdCajero.setEditable(false);
		txtpnIdCajero.setForeground(SystemColor.inactiveCaptionText);
		txtpnIdCajero.setFont(new Font("Lao UI", Font.BOLD, 15));
		txtpnIdCajero.setBounds(345, 11, 70, 25);
		panel.add(txtpnIdCajero);
	

		
		
	} //fin de metodo Venta

	public JTextField getTextFieldidVenta() {
		return textFieldidVenta;
	}

	public void setTextFieldidVenta(JTextField textFieldidVenta) {
		this.textFieldidVenta = textFieldidVenta;
	}

	public JTextField getTextFieldIdCajero() {
		return textFieldIdCajero;
	}

	public void setTextFieldIdCajero(JTextField textFieldIdCajero) {
		this.textFieldIdCajero = textFieldIdCajero;
	}

	public static  String getIdCajero() {
		return idCajero;
	}

	public  void setIdCajero(String idCajero) {
		this.idCajero = idCajero;
	}



	
	
}//fin de clase Venta
	
