/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author CAMILO
 */

import Modelo.ConsultasEmpleado;
import Modelo.Empleado;
import Vista.VistaEmpleado;
import Vista.VistaInicial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlEmpleado implements ActionListener{
    
    private Empleado CtrlEmpleado;
    private ConsultasEmpleado CtrlConsultasEmp;
    private VistaEmpleado CtrlVistaEmp;
    
        public ControlEmpleado(Empleado CtrlEmpleado, ConsultasEmpleado CtrlConsultasEmp, VistaEmpleado CtrlVistaEmp){
        
        this.CtrlEmpleado=CtrlEmpleado;
        this.CtrlConsultasEmp=CtrlConsultasEmp;
        this.CtrlVistaEmp=CtrlVistaEmp;
        
        this.CtrlVistaEmp.btnBuscar.addActionListener(this);
        this.CtrlVistaEmp.btnModificar.addActionListener(this);
        this.CtrlVistaEmp.btnEliminar.addActionListener(this);
        this.CtrlVistaEmp.btnLimpiar.addActionListener(this);
        this.CtrlVistaEmp.btnGuardar.addActionListener(this);
        
       
             
    }
    
     public void iniciarVista(){
        CtrlVistaEmp.setTitle("Empleado");
        CtrlVistaEmp.setLocationRelativeTo(null);
    }

    /**
     *
     * @param e
     */
@Override
public void actionPerformed(ActionEvent e) {
         
                 if (e.getSource() == CtrlVistaEmp.btnGuardar) {

            CtrlEmpleado.setIdentificacion(CtrlVistaEmp.txtIdentificacion.getText());         
            CtrlEmpleado.setNombre(CtrlVistaEmp.txtNombre.getText());
            CtrlEmpleado.setSueldo(Double.parseDouble(CtrlVistaEmp.txtSueldo.getText()));

            if (CtrlConsultasEmp.registrar(CtrlEmpleado)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
                limpiar();
            }

        }
        //----------------------------------------------------------------------------
             if (e.getSource() == CtrlVistaEmp.btnModificar) {
            CtrlEmpleado.setId(Integer.parseInt(CtrlVistaEmp.txtId.getText()));
            CtrlEmpleado.setIdentificacion(CtrlVistaEmp.txtIdentificacion.getText());         
            CtrlEmpleado.setNombre(CtrlVistaEmp.txtNombre.getText());
            CtrlEmpleado.setSueldo(Double.parseDouble(CtrlVistaEmp.txtSueldo.getText()));

            if (CtrlConsultasEmp.modificar(CtrlEmpleado)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
                limpiar();
            }

        }
    //-----------------------------------------------------------------------------------
            if (e.getSource() == CtrlVistaEmp.btnEliminar) {
            CtrlEmpleado.setId(Integer.parseInt(CtrlVistaEmp.txtId.getText()));

            if (CtrlConsultasEmp.eliminar(CtrlEmpleado)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                limpiar();
            }

        }
    //------------------------------------------------------------------------------------
    
            if (e.getSource() == CtrlVistaEmp.btnBuscar) {
            CtrlEmpleado.setId(Integer.parseInt(CtrlVistaEmp.txtId.getText()));

            if (CtrlConsultasEmp.buscar(CtrlEmpleado)) {
                CtrlVistaEmp.txtId.setText(String.valueOf(CtrlEmpleado.getId()));
                CtrlVistaEmp.txtIdentificacion.setText(CtrlEmpleado.getIdentificacion());
                CtrlVistaEmp.txtNombre.setText(CtrlEmpleado.getNombre());
                CtrlVistaEmp.txtSueldo.setText(String.valueOf(CtrlEmpleado.getSueldo()));

            } else {
                JOptionPane.showMessageDialog(null, "Error al Buscar");
                limpiar();
            }

        }
            
            //-----------------------------------------------------------
            
             if (e.getSource() == CtrlVistaEmp.btnLimpiar) {
            limpiar();
        }
             
                     if (e.getSource() == CtrlVistaEmp.btnVolver) {
        /*VistaInicial inicio = new VistaInicial();
        inicio.setVisible(true);
        inicio.setTitle("Menu Inicial");
        inicio.setLocationRelativeTo(null);*/
       // CtrlVistaEmp.dispose();
       limpiar();
        }
     
     }
    
          public void limpiar() {
        CtrlVistaEmp.txtId.setText(null);
        CtrlVistaEmp.txtNombre.setText(null);
        CtrlVistaEmp.txtIdentificacion.setText(null);
        CtrlVistaEmp.txtSueldo.setText(null);
    }
          
               public void Volver(){
         
        VistaInicial inicio = new VistaInicial();
        inicio.setVisible(true);
        inicio.setTitle("Menu Inicial");
        inicio.setLocationRelativeTo(null);
        CtrlVistaEmp.dispose();
     
     }
          
          
          
}
    


