# Heroes

## Overview
Heroes is a social network designed to help pet owners find blood donors for their pets. The platform connects pet owners with potential pet blood donors, blood banks, and a chatbot to assist in the process. It aims to streamline the search for blood donations, making it easier and faster to find compatible donors.

## Features
- **Pet Blood Donor Matching**: Connect with pet owners whose pets can donate blood.
- **Blood Banks**: Locate nearby blood banks for pets.
- **Chatbot Assistance**: Get automated guidance on finding blood donors.
- **User Profiles**: Manage your pet's profile and blood donation history.
- **Search & Filter**: Find donors based on pet type, blood type, and location.
- **Notifications**: Receive alerts for new donor matches and updates.

## Tech Stack
- **Java 17**
- **Spring Boot**
- **Maven**
- **JPA (Java Persistence API)**
- **JUnit (Testing Framework)**

## Installation
### Prerequisites
- Java 17 or later
- Maven
- MySQL

### Steps
1. Clone the repository:
   ```sh
   git clone https://github.com/gonzaviale/heroes.git
   cd heroes
   ```
2. Configure the database settings in `application.properties` or `application.yml`.
3. Build and run the application:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
4. Access the application at `http://localhost:8080`.

## Testing
Run tests using JUnit:
```sh
mvn test
```

## Contributing
1. Fork the repository.
2. Create a new branch (`feature-branch`).
3. Commit your changes.
4. Push to the branch.
5. Open a pull request.

## License
This project is licensed under the MIT License.

## Contact
For any questions or suggestions, feel free to contact us at gonzaloleonelviale@gmail.com.

