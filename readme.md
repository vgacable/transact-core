# Transact Rule Application

## Prerequisites
- Docker
- Java 17 +
- Maven

## Running application locally

1. Clone the repository
2. Add following entries at the end of your .zshrc or .bashrc file
```shell
export GOOGLE_CLIENT_ID="xxx"
export GOOGLE_CLIENT_SECRET="yyy"

export TRANSACT_DATASOURCE_URL="jdbc:sqlserver://localhost:1433;databaseName=transact;encrypt=true;trustServerCertificate=true"
export TRANSACT_DATASOURCE_USERNAME="sa"
export TRANSACT_DATASOURCE_PASSWORD="YourStrong!Passw0rd"

````
2. Start docker-compose from the root directory of the project to start the database server
```shell
docker-compose up
```
3. Adding the transact database to the server
 - In IntelliJ IDEA, Click on File> New > Data Source > Microsoft SQL Server > Microsoft SQL Server 
 - Fill in the details as follows:
    - Host: localhost
    - Port: 1433
    - User: sa
    - Password: YourStrong!Passw0rd
 - Click on Test Connection to verify the connection
 - Click on Apply and OK 
 - Right-click on the @localhost in the Database tool window and click on New > Database 
 - Enter the database name as `transact` ad click on OK 
 - Right-click on the @localhost in the Database tool window and click on Refersh 
 - Click on 1 of 5 next to @localhost and check next to the `transact` database

4. Build the application using the following command
```shell
mvn clean install
```
5. Run the application using the following command
```shell
mvn -pl admin-ui spring-boot:run
```

6. Access the application using the following URL
```shell
http://localhost:8080
```
