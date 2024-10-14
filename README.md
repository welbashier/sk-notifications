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
   cd sk-notifications```

2. Build the project using Maven:
   ```mvn clean install```

3. Run the application:
   ```mvn spring-boot:run```

### Configuration
To configure RabbitMQ, update the connection details in `src/main/resources/application.properties`:
  ```spring.rabbitmq.host=localhost
  spring.rabbitmq.port=5672
  spring.rabbitmq.username=guest
  spring.rabbitmq.password=guest```

