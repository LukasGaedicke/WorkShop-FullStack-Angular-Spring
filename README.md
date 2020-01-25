# WorkShop-FullStack-Angular-Spring
Esse repositório contém um CRUD de Oportunidades de emprego. O projeto foi desenvolvido durante o Workshop de Fullstrack Spring Boot e Angular, no qual foi conduzido pela Algaworks.

# Compile and Build
### API 
Vá até a pasta raiz do projeto (~/comercial-api) e execute: 
```
mvn clean package
```

Isso criará um arquivo `jar` dentro da pasta target e pode ser executado utlizando o seguinte comando:
```
java -jar comercial-api-0.0.1-SNAPSHOT.jar
```

URL base da API: http://localhost:8080/oportunidades

### Front-End 
Vá até a pasta raiz do projeto (~/comercial-ui) e execute:
```
ng serve
```

### Usando a aplicação

Para usar a aplicação, basta apenas acesar a seguinte url no seu navegador de preferência: 
```
http://localhost:4200/
```
<img src="https://github.com/LukasGaedicke/WorkShop-FullStack-Angular-Spring/blob/master/image-example.png">
