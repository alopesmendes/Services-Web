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

#### The differents commands 
##### <center>*Server Commands*</center>
|Commands|Descripton|Arguments|Example|
|:------:|:--------:|:-------:|:-----:|
|@add|the command that will add a car to the storage|[id:long], [price:long], [model:String]|@add 1 10000 renault|
|@remove|the command will remove a car from the storage|[id:long]|@remove 5|
|@all|the command will display all employee currently rented cars||@all|
|@help|the command will display the user manual of other commands||@help|

##### <center>*Client Commands*</center>
|Commands|Descripton|Arguments|Example|
|:------:|:--------:|:-------:|:-----:|
|@request|the command that will request a car|[id:long]|@request 1|
|@return|the command will return a car|[id:long], [rating:int], [condition:int]|@return 1 3 5|
|@all|the command will display all employee currently rented cars||@all|
|@rating|the command will display all the ratings of the model of a car|[id:long]|@rating 1
|@show|the command will display all the cars from a model|[model:String]|@show renault
|@help|the command will display the user manual of other commands||@help|

#### Rules

For each command if the are some errors the following messages will appear.
##### <center>*Server Rules*</center>
- comand **@remove**
    - AVERTISSEMENT: Bad Format : @remove[id:long]
    - INFOS: Car with id:3, and model:peugot does not exist.
- command **@add** 
    - AVERTISSEMENT: Bad Format : @add [id:long] [price:long] [model:String]

##### <center>*Client Rules*</center>
- command **@request**
    - AVERTISSEMENT: Bad Format : @request [carId:long]
- command **@return**
    - AVERTISSEMENT: Bad Format : @return [id:long], [rating:int], [condition:int]
    - INFOS: You cannot return a car you don't have.
- command **@rating**
    - AVERTISSEMENT: Bad Format : @rating [id:long]
    - INFOS: No car with the model:[model:String] exists
- command **@show**
    - INFOS: No car with the model:[name:String] exists

### Contributors

- Ailton LOPES MENDES
- Gérald LIN
- Alexandre MIRANDA

