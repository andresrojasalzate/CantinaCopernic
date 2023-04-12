/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.copernic.cantinadelcopernic.moduloDeudas.controladores;

import cat.copernic.cantinadelcopernic.DAO.DeudaDAO;
import cat.copernic.cantinadelcopernic.modelo.Deuda;
import cat.copernic.cantinadelcopernic.modelo.Profesor;
import cat.copernic.cantinadelcopernic.moduloDeudas.servicios.DeudaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * Controlador encargado de listar las deudas de un profesor en particular.
 *
 * Inyecta el servicio de DeudaService para obtener la información necesaria.
 *
 * Contiene un método GET que lista las deudas del profesor que ha iniciado
 * sesión.
 *
 * Este método retorna la vista "listarDeudasProfesor" que muestra el listado de
 * deudas correspondiente.
 *
 * @author Enric
 */
@Controller
public class ControladorListarDeudasProfesor {

    /**
     *
     * Servicio encargado de la gestión de las deudas.
     */
    @Autowired
    private DeudaService deudaService;

    /**
     *
     * Método GET encargado de listar las deudas de un profesor en particular.
     *
     * @param model modelo que se utiliza para pasar información a la vista.
     *
     * @return la vista "listarDeudasProfesor" que muestra el listado de deudas
     * correspondiente.
     */
    @GetMapping("/listarDeudasProfesor")
    public String listarDeudasProfesor(Model model) {

        String correoProfesor = getCurrentUser();

        List<Deuda> deudas = deudaService.listarDeudasDeUnProfesor(correoProfesor);

        model.addAttribute("listadoDeudas", deudas);

        return "/paginasDeudas/listarDeudasProfesor";
    }

    /**
     *
     * Método que obtiene el correo electrónico del profesor que ha iniciado
     * sesión.
     *
     * @return el correo electrónico del profesor que ha iniciado sesión.
     */
    public String getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        return username;
    }
}
