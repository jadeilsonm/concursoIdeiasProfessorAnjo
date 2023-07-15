package br.edu.ifpe.concursoideiasprofessoranjo.Configurations;

import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.SwaggerUiConfigParameters;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class SpringdocConfig {

    @Value("${springdoc.swagger-ui.path}")
    private String swaggerUiPath;

    public SpringdocConfig(@NotNull SwaggerUiConfigParameters sp) {
        sp.getConfigParameters().put("validatorUrl", null); // Remove a validação do Swagger UI
        sp.getConfigParameters().put("urls.primaryName", "API Documentation"); // Define o nome do link de documentação

        // Configuração do CORS
        sp.getConfigParameters().put("requestInterceptor",
                "function() {\n" +
                        "  if (window.swaggerUi && window.swaggerUi.web && window.swaggerUi.web.SwaggerTranslator) {\n" +
                        "    window.swaggerUi.web.SwaggerTranslator.translate('Please wait...');\n" +
                        "  }\n" +
                        "  this.headers['Access-Control-Allow-Origin'] = 'https://seu-dominio.com';\n" +
                        "  this.headers['Access-Control-Allow-Methods'] = 'GET, POST, PUT, DELETE';\n" +
                        "  this.headers['Access-Control-Allow-Headers'] = '*';\n" +
                        "  return this;\n" +
                        "}"
        );
    }
}
