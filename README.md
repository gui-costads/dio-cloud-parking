# dio-cloud-parking
 Desafio proposto pela DIO para desenvolver uma API com spring

##Run Database
docker run --name parking-db -p 5432:5432 -e POSTGRES_DB=parking -e POSTGRES_USER=admin -e POSTGRES_PASSWORD=123 -d postgres:15-alpine