# REST API for Mercado Libre's Technical Challenge

In February of this year, I developed a Java web app as part of a technical test for the E-commerce company Mercado Libre. I was applying for a BackEnd Java Developer position on the enterprise, and so the challenge consisted about building one REST API with Java and then hosting the web app on a cloud computing platform (I chose Amazon Web Services for the job). 

The program's primary purpose is to intercept the location and the message of a spaceship in distress through satellite communication. There are three satellites besides the ship and we know the X and Y coordinates of each one (the relevant area of space is represented by a cartesian plane), we just have to input our estimates of the distance between each one of the satellites and the spaceship, as well as the help message received by each satellite (which is just a fragment of the actual message sent by the ship). Then if its possible, the program will determine both the location and the complete message of the endangered ship with the data entered.

## How to Use

We need a tool like [Postman API](https://www.postman.com/) to generate HTTP requests to the URL where the app is currently being hosted:

http://challenge-meli.eba-xbm2th2m.sa-east-1.elasticbeanstalk.com/
