# RabbitMQ Consumer for Email Queue

This project implements a RabbitMQ consumer in a Spring Boot application that listens to and processes messages from a queue named `email-queue`.

## Features

- **RabbitMQ Consumer**: Listens for incoming messages on the `email-queue`.
- **Queue Declaration**: Queue is declared and configured in `RabbitMQConfig`.
- **Message Processing**: Logs received messages for further processing.
  
## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- RabbitMQ server (running locally or remotely)
- RabbitMQ management console for monitoring queues (optional)

### Project Structure

- `RabbitMQConfig`: Configures RabbitMQ and declares the `email-queue`.
- `EmailConsumer`: Listens to messages from `email-queue` and processes them.
- `application.properties`: Contains RabbitMQ connection details (host, port, username, password).

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/welbashier/sk-notifications.git
   cd sk-notifications

2. Build the project using Maven:
   ```bash
   mvn clean install

3. Run the application:
   ```bash
   mvn spring-boot:run

### Configuration
To configure RabbitMQ, update the connection details in `src/main/resources/application.properties`:
  ```bash
  spring.rabbitmq.host=localhost
  spring.rabbitmq.port=5672
  spring.rabbitmq.username=guest
  spring.rabbitmq.password=guest

Make sure RabbitMQ is running on your system. If you have a custom setup, adjust the connection details accordingly.

### How It Works
  The application connects to RabbitMQ using the provided configuration.
  The queue email-queue is declared and is ready to receive messages.
  The EmailConsumer listens for incoming messages from the queue and logs them to the console. You can extend the consumer logic to handle messages as required.

### Example Usage
  You can publish a test message to the queue using the RabbitMQ management console or any RabbitMQ client (e.g., Postman, amqp-publish):
  ```bash
  amqp-publish -r email-queue -b "Test email message"

The application will log the message:
  ```bash
  Received message from email-queue: Test email message

### Testing
  You can test the consumer by publishing messages to the email-queue and verifying that they are received and processed correctly by the application.

