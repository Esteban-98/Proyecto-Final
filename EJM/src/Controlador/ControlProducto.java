/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VistaInicial;
import Vista.VistaProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author CAMILO
 */
public class ControlProducto implements ActionListener{
    
    private Producto CtrlProducto;
    private ConsultasProducto CtrlConsultasPro;
    private VistaProducto CtrlVistaPro;
    
    public ControlProducto(Producto CtrlProducto, ConsultasProducto CtrlConsultasPro, VistaProducto CtrlVistaPro){
        
        this.CtrlProducto=CtrlProducto;
        this.CtrlConsultasPro=CtrlConsultasPro;
        this.CtrlVistaPro=CtrlVistaPro;
        
        this.CtrlVistaPro.btnBuscar.addActionListener(this);
        this.CtrlVistaPro.btnEliminar.addActionListener(this);
        this.CtrlVistaPro.btnGuardar.addActionListener(this);
        this.CtrlVistaPro.btnModificar.addActionListener(this);
        this.CtrlVistaPro.btnLimpiar.addActionListener(this);
             
    }
    
     public void iniciarVista(){
        CtrlVistaPro.setTitle("Productos");
        CtrlVistaPro.setLocationRelativeTo(null);
    }
     
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //-------------------------------------------------------------------------------------------
        if (e.getSource() == CtrlVistaPro.btnGuardar) {

            CtrlProducto.setNombre(CtrlVistaPro.txtNombre.getText());
            CtrlProducto.setCantidad(Integer.parseInt(CtrlVistaPro.txtCantidad.getText()));
            CtrlProducto.setPrecio(Double.parseDouble(CtrlVistaPro.txtPrecio.getText()));

            if (CtrlConsultasPro.registrar(CtrlProducto)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }

        }
        //---------------------------------------------------------------------------------------------

        if (e.getSource() == CtrlVistaPro.btnModificar) {
            CtrlProducto.setId(Integer.parseInt(CtrlVistaPro.txtId.getText()));
            CtrlProducto.setNombre(CtrlVistaPro.txtNombre.getText());
            CtrlProducto.setCantidad(Integer.parseInt(CtrlVistaPro.txtCantidad.getText()));
            CtrlProducto.setPrecio(Double.parseDouble(CtrlVistaPro.txtPrecio.getText()));

            if (CtrlConsultasPro.modificar(CtrlProducto)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }

        }

        //------------------------------------------------------------------------------------------- 
        if (e.getSource() == CtrlVistaPro.btnEliminar) {
            CtrlProducto.setId(Integer.parseInt(CtrlVistaPro.txtId.getText()));

            if (CtrlConsultasPro.eliminar(CtrlProducto)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }

        }

        //-------------------------------------------------------------------------------------------
        if (e.getSource() == CtrlVistaPro.btnBuscar) {
            CtrlProducto.setId(Integer.parseInt(CtrlVistaPro.txtId.getText()));

            if (CtrlConsultasPro.buscar(CtrlProducto)) {
                CtrlVistaPro.txtId.setText(String.valueOf(CtrlProducto.getId()));
                CtrlVistaPro.txtNombre.setText(CtrlProducto.getNombre());
                CtrlVistaPro.txtCantidad.setText(String.valueOf(CtrlProducto.getCantidad()));
                CtrlVistaPro.txtPrecio.setText(String.valueOf(CtrlProducto.getPrecio()));

            } else {
                JOptionPane.showMessageDialog(null, "Error al Buscar");
                limpiar();
            }

        }

        //-------------------------------------------------------
        if (e.getSource() == CtrlVistaPro.btnLimpiar) {
            limpiar();
        }
        //-------------------------------------------------------------
                if (e.getSource() == CtrlVistaPro.btnVolver) {
        VistaInicial inicio = new VistaInicial();
        inicio.setVisible(true);
        inicio.setTitle("Menu Inicial");
        inicio.setLocationRelativeTo(null);
        CtrlVistaPro.dispose();
        }

    }
    
    
     public void limpiar() {
        CtrlVistaPro.txtId.setText(null);
        CtrlVistaPro.txtNombre.setText(null);
        CtrlVistaPro.txtPrecio.setText(null);
        CtrlVistaPro.txtCantidad.setText(null);
    }
     
     public void Volver(){
         
        VistaInicial inicio = new VistaInicial();
        inicio.setVisible(true);
        inicio.setTitle("Menu Inicial");
        inicio.setLocationRelativeTo(null);
        CtrlVistaPro.dispose();
     
     }
}
