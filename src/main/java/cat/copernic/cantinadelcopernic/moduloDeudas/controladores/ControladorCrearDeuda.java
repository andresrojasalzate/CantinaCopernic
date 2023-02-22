/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Enric
 */
@Controller
public class ControladorCrearDeuda {

    /*La interface Model d'Spring Boot ens permet transferir dades entre el controlador i la vista
     */
    @GetMapping("/crearDeuda")
    public String inici(Model model) {

        return "/paginasDeudas/crearDeuda"; //Retorna la pàgina iniciEnviarDades
    }
    
    
}