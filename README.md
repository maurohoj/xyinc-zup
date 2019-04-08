# xyIinc-ZUP

## Introduction

> This project was developed by Mauro Júnior to meet the requirements of the company ZUP.

## About Database
> This project uses the H2 resource as the database. This feature is instantiated in memory and can be accessed through the URL http://localhost:8080/h2-console. For more information visit [H2](https://www.h2database.com/html/main.html)
>
>For this project, a Test Profile is used, which can be identified in the /src/main/resouces/"application-test.properties" directory, referenced in "application.properties".


## Quick Start

> 1.Install [Java](https://www.java.com/pt_BR/download/) (version 1.8) and [Maven](https://maven.apache.org/download.cgi)
>
> 2.Clone this repository using `https://github.com/maurohoj/xyinc-zup.git`
>
> 3.In CMD, go to the root of the project and run:
>
> ``` mvn clean install (this will build the project) ```
>
> ``` mvn spring-boot:run (this will start the webservice at localhost:8080) ```
>
> 4.In your browser, in the URL ` http://localhost:8080/ ` to test the webservice or use any HttpClient that you want. In my tests, i used [Postman](https://www.getpostman.com/) to test the application.
>
>5.When you start the project, the data points of interest informed in the reference document are already instantiated in the database. This data initially instantiated can be verified through the call http://localhost:8080/pois

## Endpoints

> ` GET /pois `
>
> Search for all Point Of Interest saved in the database and don't take any parameters.
>
> Example: http://localhost:8080/pois
>
> ` GET /pois/{id} `
>
> Search for a specific Point Of Interest if given "id" via path parameter.
>
> Example: http://localhost:8080/pois/1
>
>` DELETE /pois/{id} `
>
>Delete a specific Point Of Interest if given "id" via path parameter
>
>Example: http://localhost:8080/pois/2
>
> ` POST/PUT /pois/create `
>
>Create a Point Of Interest in the database.
>
> Example:
> URI: http://localhost:8080
>
> Body:
```
{
    "name": "TestCreatePOI",
    "coordx": 100,
    "coordy": 100
}
```
> ` GET /pois/poisNearby `
>
> Lists the POIs by proximity according to the input parameters.
>
> Expected parameters:
>
> int coordX, int coordY, double maxDistance (all three required)
>
> Example: http://localhost:8080/pois/poisNearby?coordX=20&coordY=10&maxDistance=10
>

## Requests and tests
>
>For requests and tests, i used the Postman tool.
>
>If you want to use it, please use the direct import link in the tool: https://www.getpostman.com/collections/082204ae96892ccf9686
>
>The link above contains the "status code" and "body not null" tests.
>

## Technologies

> Backend
> * [SpringBoot](http://projects.spring.io/spring-boot/)
> * [Maven](https://maven.apache.org/)
>
>Database
> * [H2](https://www.h2database.com/html/main.html)
>
>Testing
> * [JUnit](http://junit.org/)
> * [Postman](https://www.getpostman.com/)
>
> Git Repository
> * [GitHub](https://github.com/)

## Considerations
>All endpoints returns status 200 (ok) if everything goes well and 400 (bad request) if something goes wrong
>
>JAVA_VERSION: 1.8
>
>SPRING_VERSION: 2.1.4
>
>MAVEN_VERSION: 3.5.0

## Future improvements
>Based on the real world, and based on the mathematics of the distance between two points, it would be interesting in the future to implement calculations known as "Haversine", taking into account the Earth's curvature. However, since this is a simple test, I did not consider these calculations.
>
>Correct http responses to fit the REST concept
>
>Change the "/create" endpoint to accept a list of arguments
>
>When creating a POI, verify its existence (do not allow POI's with the same coordinates)
>
>To protect the backend, we could adopt a Gateway API solution, such as AWS, ZUPme or Sensedia Gateway, for troubleshooting, throttling, security (Oauth 2, JWS) implementation, authentication, etc.

## Support materials
>https://www.mkyong.com/java8/java-8-streams-filter-examples/
>
>https://github.com/jasonwinn/haversine/blob/master/Haversine.java