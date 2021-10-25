### *`Taxi Service - web app`*

_You can see how the program works on a remote server by following
this link [https://services-taxi.herokuapp.com/](https://services-taxi.herokuapp.com/login)_ <br><br>

#### _This is a simple application of the drivers registration system in the taxis service._ 
#### _Implemented Taxi-Service web application shows my skills in  JavaCore, OOP, SOLID, OPTIONAL, RDBMS, JDBC, WEB_ <br><br>

***`Functionality of the service:`*** <br>
- Create a new user without logging in using the "Register" button (the user is the driver).
- Log in to the driver. If the login or password is invalid, an "Error" message appears on the web page.
- `Display all drivers` Here we can display all drivers and remove the driver from the database. If you delete a driver - the driver is removed from all cars.`
- `Display all cars` Here we can display all cars and remove the car from the database. When we delete a car - all drivers are detached from that car.
- `Display all manufacturers` Here we can display all manufacturers and remove the manufacturer from the database.
- `Create new driver` Here we add a new driver to the database.
- `Create new car` Here we add new car in the database.
- `Create new manufacturer` Here we add a new car manufacturer to the database.
- `Add Driver to Car` Here we assign the driver to the car.
- `Display all cars for current driver` Here we can display all cars assigned to the current driver.
- Also we have a header with buttons "Back to the home page" and "Logout".


***`Technologies`***
- _JDK 11_
- _MySQL_
- _JDBC_
- _Servlet API_
- _JSP technology_
- _JSTL_
- _Tomcat_<br><br>

***`How to install`***
- _Install Tomcat version 9.0.54._
- _Configure Local Tomcat Server (set "/" in Deployment - taxi-service:war exploded - Application context)._
- _Install MySQL. In the resources directory you can find the init_db.sql file. Use it to initialize the database._
- _Don't forget in the ConnectionUtil class located in src/main/java/mate/util 
and add your URL to the database, login, password and JDBC driver there._
- _Run this project using a local Tomcat server_

