/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejm;

/*import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.VistaProducto;
import Controlador.ControlProducto;
import Modelo.ConsultasEmpleado;
import Modelo.Empleado;
import Vista.VistaEmpleado;
import Controlador.ControlEmpleado;*/

import Vista.VistaInicial;

/**
 *
 * @author CAMILO
 */
public class EJM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        VistaInicial inicio = new VistaInicial();
        inicio.setVisible(true);
        inicio.setTitle("Menu Inicial");
        inicio.setLocationRelativeTo(null);
        
       /* Empleado Memp = new Empleado();
        ConsultasEmpleado MCemp = new ConsultasEmpleado();
        VistaEmpleado MVistaEmp = new VistaEmpleado();
        ControlEmpleado CtrlEmp = new ControlEmpleado(Memp, MCemp, MVistaEmp);
        CtrlEmp.iniciarVista();
        MVistaEmp.setVisible(true);
        
        Producto Mpro = new Producto();
        ConsultasProducto MCpro = new ConsultasProducto();
        VistaProducto MVista = new VistaProducto();
        ControlProducto Ctrl = new ControlProducto(Mpro, MCpro, MVista);
        Ctrl.iniciarVista();
        MVista.setVisible(true);*/
        
        
    }
    
}
