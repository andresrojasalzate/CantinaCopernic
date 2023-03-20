/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;
import java.io.Serializable;


import lombok.Data;

/**
 *
 * @author marku
 */
@Data
@Entity
@Table(name = "pedido")
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;


    
    @ManyToOne()
    @JoinColumn(name = "bebida_idbebida") 
    private Bebida bebida;


    
    @ManyToOne()
    @JoinColumn(name = "bocadillo_semana_idbocadillo_semana") 
    private BocadilloSemana bocadilloSemana;


    
    @ManyToOne()
    @JoinColumn(name = "usuarios_correo") 
    private Profesor profesores;
}
