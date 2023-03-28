#aguardar openjdk:20 ficar disponivel no repository dockerHub
FROM openjdk:19-jdk-alpine

WORKDIR app

COPY . .

# Expõe a porta que a aplicação utiliza
EXPOSE 8080


# Comando para executar a aplicação quando o contêiner for iniciado
CMD ["java", "-jar", "target/ConcursoIdeiasProfessorAnjo-0.0.1-SNAPSHOT.jar"]
