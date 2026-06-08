package org.generation.ALMIUX.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // ** Importa el algoritmo BCrypt para el hash de contraseñas
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

// ** Clase de configuración de Spring Security: Expone el bean PasswordEncoder y configura los permisos HTTP
@Configuration
@EnableWebSecurity // ** Habilita la configuración personalizada de seguridad web
public class SecurityConfig {

    // ** Bean que provee el PasswordEncoder (BCrypt) que UserService necesita para encriptar contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // ** BCrypt es el algoritmo estándar para hash de contraseñas en Spring
    }

    // ** Configura las reglas de acceso HTTP: en desarrollo se permiten todas las rutas sin autenticación
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // ** Deshabilita CSRF porque la API es stateless (usa tokens, no sesiones de formulario)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // ** Permite todas las rutas sin autenticación (adecuado para desarrollo)
            );
        return http.build(); // ** Construye y retorna la cadena de filtros de seguridad
    }
}
