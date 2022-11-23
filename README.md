# dio-cloud-parking
  Desafio proposto pela DIO para desenvolver uma API com spring
 
### Para iniciar o projeto, é necessário clonar o projeto do GitHub num diretório de sua preferência:
  ``` 
  cd "diretório"
  git clone git@github.com:gui-costads/dio-cloud-parking.git
  ```

### Para construir o projeto com o Maven, executar os comando abaixo:
  ```shell
  mvn clean install
  ```

### Iniciar Banco de dados
  docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:15-alpine

### Acessar api e logar para acessar recursos
  ```
  localhost:8080/
  Login: user 
  Password: 123456
  ```

### Funcionalidades do projeto
- Listar todos acessos de veículo ao estacionamento
- Criar entrada no estacionamento
- Atualizar veiculo no estacionamento
- Atualizar para finalizar acesso ao estacionamento e gerar valor pelo tempo estacionado
- Deletar acesso ao estacionamento

### Link para projeto no heroku
- [Api-Swagger(Heroku)](https://parking-gc.herokuapp.com/)

### Tecnologias utilizadas
-`Java`
-`Spring Boot`
-`Spring Security`
-`PostgresSql`
-`Swagger`
-`Rest Assured`
