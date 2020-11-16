# Rest

Car renting and buying application that is distributed and intended for Eiffel Corp employees, built with Java RMI and webservices.

## Installation

### Prerequisites

* Java 8
* Apache Maven
* Apache Tomcat

### Build

Assuming you already cloned this repository, run the following command in the root directory of the project:

```
mvn package
```

This commands builds the following packages:
* `bank.jar` - an executable JAR found at `bank/target`
* `ifscars-server.jar` - an executable JAR found at `ifscars-server/target`
* `renting-app.jar` - an executable JAR found at `renting-app/target`
* `ifscars-web.war` - a webservice WAR file that is ready to be deployed on a Tomcat server

### Deploy webservice to Tomcat

Make sure your Tomcat installation has users configured for the manager. If not, edit the `conf/tomcat-users.xml` of your Tomcat installation and add the following:

```xml
<tomcat-users>
	...
	<role rolename="manager-gui"/>
	<role rolename="manager-script"/>
	<user username="admin" password="password" roles="manager-gui, manager-script"/>
</tomcat-users>
```

Now edit the file located at `[user home]/.m2/settings.xml` (create it if it doesn't exist) and add the following (with the username and password defined previously):

```xml
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">

	...
	<servers>
		...
        <server>
        	<id>tomcat</id>
        	<username>admin</username>
        	<password>password</password>
       	</server>
	</servers>
</settings>
```

Go back the the root directory of the project, and run the following (make sure the Tomcat server is started at localhost:8080):

```
mvn tomcat7:deploy
```

You can now access the webservice at http://localhost:8080/ifscars-web/services/Hello

> **Note:** if you already deployed the webservice and want to update it, run `mvn tomcat7:redeploy` instead

## Development with Eclipse

In order to work on this project with Eclipse, follow these steps:

1. Make sure the Maven integration for Eclipse is installed. Instruction for installation can be found here: https://download.eclipse.org/technology/m2e/releases/1.9/
2. Once the plugin is installed and Eclipse is restarted, go to `File > Import...` and find `Import existing Maven project`
3. Select the project root directory, make sure all modules are ticked, and finish the import
4. Right click the `ifscars-web` project in the Package Explorer, select `Configure > Convert to Faceted Form...`, tick `Dynamic Web module` then `Apply and close`
5. Make sure all projects are using Java 1.8 as Compiler compliance level in `Project properties > Java Compiler`
6. Feel free to configure a Tomcat server within Eclipse to run the webservice directly from the IDE

## UML

<p align="center">
	<img src="https://github.com/alopesmendes/Rest/blob/dev/ailton/Images/UML.png" alt="" />
</p>

## Contributors

* Ailton LOPES MENDES
* Gérald LIN
* Alexandre MIRANDA