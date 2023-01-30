/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermercado_super_25;

/**
 *
 * @author USUARIO
 */
public class codigoDescuento {
    
    String nombreCodigo;
    float descuento;
    
    public codigoDescuento(String nombre, float descuento){
        this.nombreCodigo = nombre;
        this.descuento = descuento/100;
    }
    
}
