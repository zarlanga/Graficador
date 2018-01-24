/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graficador;

/**
 *
 * 
 * Agregar varios componentes con un array (layout)
 * 
 * cambia el ancho pero no el alto del jpanel
 * 
 * 
 * 
 * @author tyt
 */
public class Controlador {
    
    VistaSF v;
    Modelo m;
    public void iniciar(){
        v=new VistaSF();
        m=new Modelo();
        
        v.iniciar();
    }
    
}
