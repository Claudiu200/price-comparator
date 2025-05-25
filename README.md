# 🛒 Price Comparator API

This is a Spring Boot application that processes product pricing and discount data from multiple stores and provides smart recommendations to help users identify the best value purchases. The application uses MySQL for data persistence and Swagger for API testing.

## 📁 Project Structure Overview

```
src/
├── main/
│   ├── java/com/example/pricecomparator/
│   │   ├── controller/         # REST controllers for handling API requests
│   │   ├── dto/                # Data Transfer Objects
│   │   ├── model/              # JPA entities (Price, Discount)
│   │   ├── repository/         # Spring Data JPA repositories
│   │   ├── service/            # Business logic
│   │   └── PriceComparatorApplication.java
│   └── resources/
│       ├── application.properties
│       └── data/               # Directory for CSV files
└── test/                      # Unit and integration tests
```

---

## 🚀 How to Build and Run

### ✅ Prerequisites

- Java 17+
- Maven
- MySQL

1. Clone the project:
   ```bash
   git clone https://github.com/Claudiu200/price-comparator
   cd price-comparator
   ```

2. Configure your `application.properties` or `application.yml`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/price_db
   spring.datasource.username=mysql_username
   spring.datasource.password=mysql_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Import CSV Test Data

The test data was provided in CSV format and imported into the MySQL database using custom scripts.

👉 The scripts are located in the `/tools/data-import-scripts` directory and include:

- `import_products.sql` – for inserting product/price data.
- `import_discounts.sql` – for inserting discount data.

#### 🛠 How to Run the SQL Scripts: 
Open MySQL Workbench or a terminal and run:
   ```bash
   mysql -u your_user_name -p price_db < tools/data-import/import_products.sql
   ```

> ⚠️ Make sure the database is created and configured properly before running the scripts.

4. Build the project:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```

6. Access Swagger UI:
   ```
   http://localhost:8080/swagger-ui/index.html
   ```

---

## 💡 Implemented Features
### 1. **Best Discounts**
- **Purpose**: Display top current discounts (percentage-based) for a specific date across all stores.
- **Endpoint**:
  ```
  GET /api/discounts/best?date=YYYY-MM-DD
  ```
  
  - **Query Parameters:**

      - `date` (required): The date for which to retrieve the best discounts (ISO format, e.g., `2025-05-25`). (Was added for testing purposes)
  - **Sample Response**:
    ```json
    [{
        "productId": "P020",
        "productName": "spaghetti nr.5",
        "storeName": "lidl",
        "brand": "Barilla",
        "category": "paste făinoase",
        "percentageOfDiscount": 20,
        "fromDate": "2025-05-03",
        "toDate": "2025-05-09",
        "registeredAt": "2025-05-01"
    }]
    ```
    > 🧪 Test it easily in Swagger by providing a valid date in the query field.
---

### 2. **New Discounts (Last 24 Hours)**
- **Purpose**: Highlight newly added deals.
- **Endpoint**:
  ```
  GET /api/discounts/new
  ```
- **Sample Response**:
  ```json
  [
    {
     "productId": "P999",
     "productName": "test produs",
     "storeName": "lidl",
     "brand": "TestBrand",
     "category": "test categorie",
     "percentageOfDiscount": 17.5,
     "fromDate": "2025-05-24",
     "toDate": "2025-05-30",
     "registeredAt": "2025-05-24"
    }
  ]
  ```

---

### 3. **Product Substitutes & Recommendations**
- **Purpose**: Help users find the best value by showing **value per unit** (e.g., price/kg or price/L), even if product sizes differ.


- **Endpoint**:
  ```
  GET /api/discounts/substitutes?productName=name
  ```

- **Query Parameters:**

    - `productName` (required): The name of the product for which to find best value alternatives (e.g. ```lapte zuzu```).
- **Sample Response**:
  ```json
  [
    {
      "storeName": "Lidl",
      "price": 9.9,
      "packageQuantity": 1,
      "packageUnit": "l",
      "pricePerUnit": 9.9
    },
    {
      "storeName": "Kaufland",
      "price": 10.1,
      "packageQuantity": 1,
      "packageUnit": "l",
      "pricePerUnit": 10.1
    }
  ]
  ```

---

# 📌 Assumptions & Simplifications

- Discounts are stored with `from_date` and `to_date` fields to determine activity and freshness.
- CSVs are assumed to be clean and validated externally before import.
- Application uses `@EmbeddedId` for composite keys in `Price` and `Discount` tables.

---

## 🧪 API Testing with Swagger

After starting the application, navigate to:

> [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

There, you can:
- View all available endpoints
- Execute API calls with real data
- Validate responses in real-time

---

## 📬 Contact

For questions or suggestions, feel free to reach out via GitHub issues or email.
