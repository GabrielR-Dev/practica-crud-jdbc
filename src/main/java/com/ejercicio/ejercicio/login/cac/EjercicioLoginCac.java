/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.ejercicio.ejercicio.login.cac;

import com.ejercicio.ejercicio.login.cac.data.UsuarioDAO;
import com.ejercicio.ejercicio.login.cac.model.Usuarios;
import java.sql.SQLException;

/**
 *
 * @author gabri
 */
public class EjercicioLoginCac {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        UsuarioDAO u = new UsuarioDAO();
        //u.verUsuario(3);
        Usuarios usuario = new Usuarios("Gaby", "1234","apellif", 27, "La pampa");
        u.crearUsuario(usuario);
    }
}
