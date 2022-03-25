# REST API for Mercado Libre's Technical Challenge

In February of this year, I developed a Java web app as part of a technical test for the E-commerce company Mercado Libre. I was applying for a BackEnd Java Developer position on the enterprise, and so the challenge consisted about building one REST API with Java and then hosting the web app on a cloud computing platform (I chose Amazon Web Services for the job). 

The program's primary purpose is to intercept the location and the message of a spaceship in distress through satellite communication. There are three satellites besides the ship and we know the X and Y coordinates of each one (the relevant area of space is represented by a cartesian plane), we just have to input our estimates of the distance between each one of the satellites and the spaceship, as well as the help message received by each satellite (which is just a fragment of the actual message sent by the ship). Then if its possible, the program will determine both the location and the complete message of the endangered ship with the data entered.

## How to Use

We need a tool like [Postman](https://www.postman.com/) to generate HTTP requests to the URL of the site in which the app is currently being hosted:

http://challenge-meli.eba-xbm2th2m.sa-east-1.elasticbeanstalk.com/

In order to input the required data for the program to function, we have to send a POST request to http://challenge-meli.eba-xbm2th2m.sa-east-1.elasticbeanstalk.com/api/topsecret with the following JSON format info in the request's body:


```
[
       {
            "nombre": "kenobi",
            "distanciaAlEmisor": 0.0,
            "mensajeRecibido": ["", "", "", "", ""]
       },
       {
            "nombre": "skywalker",
            "distanciaAlEmisor": 0.0,
            "mensajeRecibido": ["", "", "", "", ""]
       },
       {
            "nombre": "sato",
            "distanciaAlEmisor": 0.0,
            "mensajeRecibido": ["", "", "", "", ""]
       }
]
```

Afterwards without modifying the name fields at all, we change the values of the fields corresponding to the estimated distance between the satellites and the spaceship with other real numbers of our choosing, and on the fields below with the empty quotes we add the words of the message as obtained by each one of the satellites, like in this example:

```
[
       {
            "nombre": "kenobi",
            "distanciaAlEmisor": 663.4,
            "mensajeRecibido": ["este", "", "", "mensaje", ""]
       },
       {
            "nombre": "skywalker",
            "distanciaAlEmisor": 264.7,
            "mensajeRecibido": ["", "es", "", "", "secreto"]
       },
       {
            "nombre": "sato",
            "distanciaAlEmisor": 447.7,
            "mensajeRecibido": ["este", "", "un", "", ""]
       }
]
```

## Tools Used for Coding and Testing

- Apache NetBeans IDE 12.6 (to create, edit and test the Maven web app project)
- Java Development Kit 8
- Java EE Web API 7
- Oracle GlassFish Server 5 (to run the app offline on the IDE)
- The Postman API Platform
- Geogebra Calculator Suite (to verify the accuracy of the trilateration algorithm)
