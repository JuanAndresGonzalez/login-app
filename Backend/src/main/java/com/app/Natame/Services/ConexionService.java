package com.app.Natame.Services;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.Natame.Logica.Conexion;

public class ConexionService {
    private static ConexionService servicio;

    private ConexionService() {
    }

    public static ConexionService obtenerServicio() {
        if (servicio == null) {
            servicio = new ConexionService();
        }
        return servicio;
    }

    int numPedido;
    Date fecha_pedido = new Date(System.currentTimeMillis());
    int id_cliente;

    public Map<String, Object> iniciarSesion(String user, String pass) {
        try {
            new Conexion(user, pass).EjecutarQuery("select * from dual");
            Map<String, Object> response = Map.of("message", "Conectado!", "codigo", 200);
            return response;
        } catch (Exception e) {
            throw e;
        }
    }

}
