# iqb-demo

A simple demo showing the use of RabbitMQ as Message bus between two microservices 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

Docker 
Java 8 or later

```
Give examples
```

### Installing

 * iqb-demo-commons  
    * common configurations of Q/Topic etc. Could possibly add shared messageformats if required. 
 * iqb-demo-consumer 
    * reads message from the Q and acts on it (print to console)
 * iqb-demo-producer 
    * sends message to Q (gets data from console)
 * iqb-rabbitmq-container 
    * docker-compose that will host an instance of RabbitMQ

### Steps to use


Download project

Get the rabbit-mq instance running first

```
cd iqb-rabbitmq-container

docker compose up

```

To validate go to http://localhost:15672/#/queues 
default creds: guest/guest

Run a maven install on iqb-demo-commons to install locally

Run a maven build on iqb-demo-consumer

then from the iqb-demo-consumer folder

```
 java -jar target/iqb-demo-consumer-0.0.1-SNAPSHOT.jar

```

Run a maven build on iqb-demo-producer

then from the iqb-demo-producer folder

```
 java -jar target/iqb-demo-producer-0.0.1-SNAPSHOT.jar

```


### EXAMPLE

on consumer console

```
Enter a name: 
MYNAMEIS
Sending message: Hello my name is, MYNAMEIS

```
on producer console
```
Hello MYNAMEIS, I am your father!
```


## Running the tests

The tests as part of the build
The test cover only the following

On producer it validates connection. Could possibly add test for message format validation before send.

On consumer it does in integration test. Thus it needs the local rabbitMQ instance to run.
On the consumer the formatting and validation also tested


## Deployment

Docker configs also added for producer. Usage not covered for this excerise 

## TODO
* dynamic props
* cleanup .gitignore

## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - Microservice
* [Maven](https://maven.apache.org/) - Dependency Management
* [Docker](https://www.docker.com/) - used for container

