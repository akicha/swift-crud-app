# swift-crud-app
Backend for Swift CRUD application


##  Prerequisites

Before proceeding ensure that Docker installed on your machine.

## Running application

This application was containerized using Docker. To run this application you need to clone this repository using the next command: 

`git clone https://github.com/akicha/swift-crud-app.git`

Go to the project's root folder (replace <swift-crud-app> with your path)

`cd <swift-crud-app>`

Next steep consists in building Docker image with parameters defined in dockerfile

`docker build --tag 'backend' .`

Now run the Docker container

`docker run -p 8080:8080 backend`
