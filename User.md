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
Rest/renting-app$ java -jar target/renting-app.jar [id:long]
```

Thrid tab
```java
Rest/renting-app$ mvn package
Rest/renting-app$ java -jar target/renting-app.jar [id:long]
```

If the ids are the already in the base the following message will appear : 
- GRAVE: id already used


#### The differents commands 
##### <center>*Server Commands*</center>
|Commands|Descripton|Arguments|Example|
|:------:|:--------:|:-------:|:-----:|
|@add|the command that will add a car to the storage|[id:long], [price:double], [model:String]|@add 1 10000 renault|
|@remove|the command will remove a car from the storage|[id:long], [model:String]|@remove 5 renault|
|@all|the command will display all employee currently rented cars||@all|
|@help|the command will display the user manual of other commands||@help|

##### <center>*Client Commands*</center>
|Commands|Descripton|Arguments|Example|
|:------:|:--------:|:-------:|:-----:|
|@request|the command that will request a car|[id:long], [model:String]|@request 1 renault|
|@return|the command will return a car|[rating:double], [condition:double] [id:long] [model:String]|@return 5 3 1 renault|
|@all|the command will display all employee currently rented cars||@all|
|@rating|the command will display all the ratings of the model of a car|[id:long] [model:String]|@rating 1 renault
|@show|the command will display all the cars from a model|[model:String]|@show renault
|@help|the command will display the user manual of other commands||@help|

#### Rules

For each command if the are some errors the following messages will appear.
##### <center>*Server Rules*</center>
- comand **@remove**
    - AVERTISSEMENT: Bad Format : @remove[id:long] [model:String]
    - INFOS: Car with id:3, and model:peugot does not exist.
- command **@add** 
    - AVERTISSEMENT: Bad Format : @add [id:long] [price:double] [model:String]

##### <center>*Client Rules*</center>
- command **@request**
    - AVERTISSEMENT: Bad Format : @request [carId:long] [model:string]
- command **@return**
    - AVERTISSEMENT: Bad Format : @return [rating:double] [condition:double] [id:long] [model:String]
    - INFOS: You cannot return a car you don't have.
- command **@rating**
    - AVERTISSEMENT: Bad Format : @return [rating:double] [condition:double] [id:long] [model:String]
    - INFOS: No car with the model:[model:String] exists
- command **@show**
    - INFOS: No car with the model:fe exists

### Contributors

- Ailton LOPES MENDES
- Gérald LIN
- Alexandre MIRANDA

