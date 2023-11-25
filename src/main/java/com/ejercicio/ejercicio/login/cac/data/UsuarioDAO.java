package com.ejercicio.ejercicio.login.cac.data;

import static com.ejercicio.ejercicio.login.cac.data.Conexion.*;
import com.ejercicio.ejercicio.login.cac.model.Usuarios;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static final String SELECT_ALL_USERS = "SELECT * FROM usuarios;";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM usuarios WHERE id = ?;";
    private static final String CREATE_USER = "INSERT INTO usuarios (nombre, contracenia , apellido, edad, provincia) VALUES (?,?,?,?,?);";
    private static final String UPDATE_USER = "UPDATE usuarios SET nombre = ?, apellido = ?, edad = ?, provincia = ? WHERE id = ?;";
    private static final String DELETE_USER_BY_ID = "DELETE FROM usuarios WHERE id = ?;";

    public List<Usuarios> verUsuarios() {

        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Usuarios usuario = null;
        List<Usuarios> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            rs = conn.prepareStatement(SELECT_ALL_USERS).executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id");
                String nombreUsuario = rs.getString("nombre");
                String apellidoUsuario = rs.getString("apellido");
                String provinciaUsuario = rs.getString("provincia");
                String edadUsuario = rs.getString("edad");
                String fechaUsuario = rs.getString("fecha");
                

                usuario = new Usuarios(nombreUsuario, apellidoUsuario, parseInt(edadUsuario), provinciaUsuario);
                usuario.setId(idUsuario);
                usuario.setFecha(LocalDate.parse(fechaUsuario));
                usuarios.add(usuario);
            }

        } catch (ClassNotFoundException | NumberFormatException | SQLException e) {
            System.out.print(e);
        } finally {
            try {
                close(rs);
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        }

        return usuarios;
    }

    public Usuarios verUsuario(int id) {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        Usuarios usuario = null;
        try {
            conn = Conexion.getConexion();
            stm = conn.prepareStatement(SELECT_USER_BY_ID);
            stm.setInt(1, id);
            rs = stm.executeQuery();

            if (rs.next()) {
                usuario = new Usuarios(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"), rs.getString("provincia"));
            }

        } catch (NumberFormatException | SQLException | ClassNotFoundException e) {
            System.out.print(e);
        } finally {
            try {
                close(rs);
                close(stm);
                close(conn);
            } catch (SQLException ex) {
                System.out.print(ex);
            }
        }
        System.out.print(usuario);
        return usuario;
    }
    
    public void crearUsuario(Usuarios usuario){
        
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs =null;
        
        try {
            
            
            conn = Conexion.getConexion();
            stm = conn.prepareStatement(CREATE_USER);
            stm.setString(1, usuario.getNombre());
            stm.setString(2, usuario.getContracenia());
            stm.setString(3, usuario.getApellido());
            stm.setInt(4, usuario.getEdad());
            stm.setString(5, usuario.getProvincia());

            stm.execute();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.print("Usuario registrado");
    }

}
