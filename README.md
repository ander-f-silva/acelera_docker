# PFA - Docker
Este desafio tem como objetivo criar uma lista com alguns módulos do curso FullCycle acessando o endereço via HTTP.

## Tecnologias

### Aplicação

Para construir a aplicação eu utilizo os frameworks do ecossistema Spring:

- Spring Boot;
- Spring MVC;
- Spring Data com JPA.

A linguagem de progração é Java versão 11 e gerenciador de pacotes Maven.
A aplicação roda na porta 3000.

### Proxy

Utilizo o Nginx aponta para porta 80 e externamente para 8080.

### Banco de Dados

Utilizei o banco de dados MySQL rodando na porta 3306.

## Instalação

### Baixando os projetos pelo docker hub

- Primeiro criar a reder:

````
docker network create pfa-network
````

- Segundo passo criar o banco de dados através do commando baixo :

````
docker run -d \
--network pfa-network \
--network-alias database \
--name module-db \
-e MYSQL_DATABASE=module-db \
-e MYSQL_USER=module \
-e MYSQL_PASSWORD=module \
-e MYSQL_ROOT_PASSWORD=root \
mysql:5.7
````

- Terceiro passo baixar a aplicação

````
docker run -d \
--network pfa-network \
--network-alias application \
--name module-api \
-e DB_USERNAME='module' \
-e DB_PASSWORD='module' \
-e DB_HOST='database' \
-e DB_PORT='3306' \
-e DB_DATABASE='module-db' \
andersonfsilva/module-api:1.0.0
````

- Quato passo baixar o proxy 

````
docker run -d \
--network pfa-network \
-p 8080:80 \
--name web-proxy \
andersonfsilva/web-proxy:1.0.0
````

### Testar o resultado

Há duas formas para realizar o teste:

1 - Usar o browser digitando o enderenço http://localhost:8080/modules

ou 

2 - Uar o curl em um terminal 

````
curl -X GET http://localhost:8080/modules
````

#### Note

A aplicações estão nos repositórios do docker hub, neste caso não precisa criar as imagens com base no código.
