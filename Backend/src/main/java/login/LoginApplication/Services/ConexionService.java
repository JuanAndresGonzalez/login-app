package login.LoginApplication.Services;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import login.LoginApplication.Logica.Conexion;

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
