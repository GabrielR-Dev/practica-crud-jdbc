package com.ejercicio.ejercicio.login.cac.data;

import com.ejercicio.ejercicio.login.cac.model.Usuarios;
import java.util.List;

public class Data {
    private static final String SELECT_ALL_USERS = "SELECT usuarios FROM ejercicio_codoacodo_db;";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM usuarios WHERE id = 3;";
    private static final String CREATE_USER = "INSERT INTO usuarios (nombre, apellido, edad, provincia) VALUES (?,?,?,?);";
    private static final String UPDATE_USER = "UPDATE usuarios SET nombre = ?, apellido = ?, edad = ?, provincia = ? WHERE id = ?;";
    private static final String DELETE_USER_BY_ID = "DELETE FROM usuarios WHERE id = ?;";
    
    public List<Usuarios> verUsuarios (){
        return null;
    }
}
  