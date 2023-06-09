/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Enric
 */
@Data
@Entity
@Table(name = "tipo_tarea")
public class TipoTarea {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo_tarea")
    public int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @OneToMany(mappedBy = "tipo", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Tarea> tareas;
    
    public TipoTarea(int id) {
        this.id = id;
    }
    
    public TipoTarea() {}
    
}
