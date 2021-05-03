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

**Note**: Foi removido a criação do banco pela aplicação e agora esta configurada para docker compose.

### Container (atualização)

- Docker;
- Docker Composer (novo).

## Instalação (atualização)

### Instalaçãom com Docker Commpose

Faça o clone do projeto para a pasta desejada usando o comando git clone 

````
git clone https://github.com/ander-f-silva/pfa-docker.git
````

Este passo é necessario por que o script de inicializa a base esta no processo de subir o Mysql.

````
docker-compouse up -d
````

**Note**: Não precisa fazer o build das imagens, pois as images do proxy reverso e da aplicação foram alteradas para ficar mais flexivel.

### Instalaçãom com Docker 

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

**Note**: A aplicações estão nos repositórios do docker hub, neste caso não precisa criar as imagens com base no código.
