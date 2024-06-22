package com.app.Natame.Controllers;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Natame.Services.ConexionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

    ConexionService conexionDB = ConexionService.obtenerServicio();

    @PostMapping("/iniciar")
    ResponseEntity<Map<String, Object>> iniciarSesion(@RequestBody Map<String, Object> data) {
        try {
            return ResponseEntity.ok()
                    .body(conexionDB.iniciarSesion((String) data.get("user"), (String) data.get("pass")));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("message", e.getCause().getMessage(), "codigo", 400));
        }
    }
    // awaw
}
