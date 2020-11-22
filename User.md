# <center>Usage</center>
### *Shell*
Starting point
```java
Rest/ifs-cars-server$ mvn package
Rest/ifs-cars-server$ java -jar target/ifs-cars-server.jar
```

Second tab
```java
Rest/renting-app$ mvn package
Rest/renting-app$ java -jar target/renting-app.jar
```

Thrid tab
```java
Rest/renting-app$ mvn package
Rest/renting-app$ java -jar target/renting-app.jar [id:int]
```

#### The differents commands 

|Commands|Descripton|Arguments|Example|
|:------:|:--------:|:-------:|:-----:|
|@request|the command that will request a car|model(String)|@request renault|
|@return|the command will return a car|[model:String], [rating:int], [condition:int]|@return renault 5 3|
|@all|the command will display all employee currently rented cars||@all|
|@rating|the command will display the average rating of a car|[model:String]|@ratinf renault

#### Rules

For each command if the are some errors the following messages will appear.
- INFOS: The car does not exist. Cause : model was not identified.
- INFOS: The rating must be between 1 and 5. Cause : rating was not between 1 and 5.
- INFOS: The condition must be between 1 and 5. Cause : condition was not between 1 and 5.
