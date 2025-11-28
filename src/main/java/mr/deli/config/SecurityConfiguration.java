// mr.deli.config.SecurityConfiguration.java
package mr.deli.config;

import mr.deli.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Habilita o @PreAuthorize
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    public SecurityConfiguration(
            JwtAuthenticationFilter jwtAuthenticationFilter,
            AuthenticationProvider authenticationProvider
    ) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Desabilita CSRF (porque usamos JWT, que não usa sessão)
                .csrf(AbstractHttpConfigurer::disable)

                // Configuração CORS (Permite requisições de outras origens)
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))

                // Gerenciamento de Autorizações
                .authorizeHttpRequests(auth -> auth

                        // 1. ROTAS PÚBLICAS (Permite acesso sem autenticação)
                        // Login, Registro
                        .requestMatchers("/api/auth/**").permitAll()
                        // Consulta de Produtos (GET)
                        .requestMatchers(HttpMethod.GET, "/api/products").permitAll()
                        // Rota padrão (evita 403 se o usuário acessar a URL raiz)
                        .requestMatchers("/").permitAll()
                        // Outras rotas comuns, como páginas de erro
                        .requestMatchers("/error").permitAll()

                        // 2. ROTAS RESTRITAS AO ADMIN (Protegido por @PreAuthorize)
                        // O filtro checará o JWT, mas o @PreAuthorize checará a ROLE
                        .requestMatchers("/api/products/management/**").authenticated()

                        // 3. QUALQUER OUTRA ROTA (Exige autenticação válida - JWT)
                        .anyRequest().authenticated()
                )

                // Configurações de Sessão como STATELESS (Sem estado)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Define o provedor de autenticação customizado
                .authenticationProvider(authenticationProvider)

                // Adiciona nosso filtro JWT antes do filtro de autenticação padrão do Spring
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Define a configuração de CORS (Cross-Origin Resource Sharing)
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // Permite acesso de qualquer origem em ambiente de desenvolvimento
        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}