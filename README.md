# Shop Mono Repo

This is my porfolio comprehensive demo project combining a REST API, a CMS, and a client UI into a single repository. 
This project is designed to handle the full range of functionalities required for a modern online shop, including business logic, content management, and user interface.

## Repository Structure

```
shop-mono-repo/
│
├── shop-api/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
├── shop-cms/
│   ├── src/
│   ├── pom.xml
│   └── README.md
│
└── shop-client-ui/
    ├── src/
    ├── angular.json
    └── README.md
```

### 1. `shop-api`

**Description**: The `shop-api` module is a Spring Boot REST API that handles most of the business logic for the shop. It includes features such as product management, user authentication, order processing, and more.

**Key Features**:
- RESTful endpoints for shop operations
- User authentication and authorization
- Order management
- Product catalog management

**Setup**:
1. Navigate to the `shop-api` directory.
2. Build the project using Maven:
    ```bash
    mvn clean install
    ```
3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### 2. `shop-cms`

**Description**: The `shop-cms` module handles the content management system (CMS) for the shop, including articles and blogs. It also manages the ingestion of these documents into Elasticsearch for efficient searching and indexing.

**Key Features**:
- Content creation and management
- Integration with Elasticsearch for search capabilities
- RESTful endpoints for content operations

**Setup**:
1. Navigate to the `shop-cms` directory.
2. Build the project using Maven:
    ```bash
    mvn clean install
    ```
3. Run the application:
    ```bash
    mvn spring-boot:run
    ```

### 3. `shop-client-ui`

**Description**: The `shop-client-ui` module is an Angular application that serves as the user interface for the shop. It interacts with the `shop-api` and `shop-cms` to provide a seamless user experience.

**Key Features**:
- Responsive UI for shop functionalities
- Integration with `shop-api` for business logic
- Integration with `shop-cms` for content display

**Setup**:
1. Navigate to the `shop-client-ui` directory.
2. Install the dependencies:
    ```bash
    npm install
    ```
3. Serve the application:
    ```bash
    ng serve
    ```



