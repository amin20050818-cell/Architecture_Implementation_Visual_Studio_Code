# Architecture and Implementation — 5 complete cases

**Important:** The supplied PDF specifically requires Java Spring Boot, JPA, Kafka and Maven, so the correct editor is **Visual Studio Code** with Extension Pack for Java and Spring Boot Extension Pack; **Visual Studio 2022** is not a native Java/Spring Boot IDE. No conversion to C# was made.

## Prerequisites
- JDK 17 or later, Maven 3.9+, Docker Desktop (for cases 2, 3 and 5)
- Open `Architecture-Implementation.code-workspace` in Visual Studio Code.

## Start / test each app
```bash
cd 01-Student-Attendance
mvn clean test
mvn spring-boot:run
```
For cases 2, 3 and 5, go into the respective case folder and run `docker compose up --build` instead to start the database/Kafka with the application. Case 4 uses `mvn spring-boot:run`. Ports: 8081, 8082, 8083, 8084, 8085.

## Endpoints
1. Attendance: `GET/POST /api/attendance`, `GET/PUT/DELETE /api/attendance/{id}`. Example POST: `{"studentId":1,"course":"Software Architecture","attendanceDate":"2026-11-05","present":true}`.
2. Quiz: `GET /quiz/start`, `POST /quiz/check`, JSON body `[ {"questionId":1,"selectedOption":"A"} ]`; monitoring `GET /actuator/prometheus`.
3. Payments: `POST /api/payments` JSON `{ "amount": 150.50 }`; `GET /api/payments/{id}`. Kafka consumer changes `PENDING` to `CONFIRMED` asynchronously. The response may still show `PENDING` initially.
4. Books: `GET /recommend?genre=AI`.
5. Inventory: `GET/POST /items`, `GET /items/{id}`, `POST /items/{id}/reduce` JSON `{ "amount": 2 }`.

## Diagrams
Import `Architecture_Implementation_Diagrams.drawio` into https://app.diagrams.net/; it contains case-specific editable pages, flows and sequence/component/class diagrams. Pages 10–12 of the source document provide example use-case and service architecture images; these project-specific diagrams are based on the written requirements in pages 7–9 rather than copying those generic examples.

## Production notes
- Credentials in Compose and Kubernetes samples are **local demonstration values only**. Never commit real secrets.
- Kafka / Docker / Kubernetes require external services. The local Maven projects are separate, not a single Maven reactor.
- CI workflow files inside each folder are triggered when **that folder is the Git repository root**. If creating one monorepo, adjust `working-directory` for each workflow.
- The example JPA entities / APIs are minimal learning implementations, not hardened production deployments.
- The Kafka Compose example uses a Zookeeper-based image to match the PDF requirement.
