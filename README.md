# HearthStone

## Para rodar a aplicação

1. Clone o projeto `git clone https://github.com/GuiRocha/HearthStone.git`
2. Para fazer o Build do projeto use `mvn clean install`
3. Rode usando `mvn spring-boot:run`ou Rode através do Jar `java -jar target/hearthstone-0.0.1-SNAPSHOT.jar`
4. Rode os testes unitarios `mvn test`
5. A aplicação estará disponivel na porta `localhost:8080/carta` - acesse usando o POSTMAN

## SwaggerUI - Endpoints

1. Acesse `http://localhost:8080/swagger-ui.html` para conferir os endpoints

## Postman

1. GET - `http://localhost:8080/carta/`
2. GET by ID - `http://localhost:8080/carta/{id}`
3. GET by TIPO - `http://localhost:8080/carta/tipo?codigo={id tipo 1 ou 2}`
4. GET by NOME - `http://localhost:8080/carta/nome?text={nome}`
5. POST - `http://localhost:8080/carta/`
- faça post utilizando JSON:
{
  "nome": "Teste",
  "descricao": "Uma descrição",
  "ataque": 10,
  "defesa": 10,
  "tipo": "MAGIA",
  "classe": "PALADINO"
}
    
6. DELETE - `http://localhost:8080/carta/1`
