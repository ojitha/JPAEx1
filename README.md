# JPA Employee Management System: A Java Persistence API Example

This project demonstrates a comprehensive implementation of JPA (Java Persistence API) for managing employee data with complex entity relationships and embedded objects. It showcases best practices for persistence mapping, entity relationships, and data management using EclipseLink as the JPA provider.

The system manages employee records with related entities including departments, assets, work assignments, leave records, and contact information. It demonstrates various JPA features including one-to-many relationships, embedded objects, and table-based ID generation. The application supports both MySQL and Apache Derby databases, making it flexible for different deployment scenarios.

## Repository Structure
```
JPAEx1/
├── pom.xml                 # Maven project configuration with JPA dependencies
└── src/
    └── main/
        ├── java/
        │   └── au/com/ojitha/blogspot/jpaex1/
        │       ├── domain/             # Entity classes for data model
        │       │   ├── Address.java    # Embedded address information
        │       │   ├── Asset.java      # Employee asset management
        │       │   ├── Employee.java   # Core employee entity
        │       │   ├── Department.java # Department management
        │       │   └── [Other entities]# Additional supporting entities
        │       └── jpa/
        │           └── JpaTest.java    # Main test class demonstrating JPA usage
        └── resources/
            └── META-INF/
                └── persistence.xml     # JPA configuration and persistence unit
```

## Usage Instructions
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Maven 3.x
- MySQL Server 5.x or Apache Derby
- IDE with JPA support (optional)

### Installation

1. Clone the repository:
```bash
git clone [repository-url]
cd JPAEx1
```

2. Configure the database:
```bash
# MySQL Setup
mysql -u root -p
CREATE DATABASE hr;
CREATE USER 'ojitha'@'localhost' IDENTIFIED BY 'ojitha';
GRANT ALL PRIVILEGES ON hr.* TO 'ojitha'@'localhost';
FLUSH PRIVILEGES;
```

3. Build the project:
```bash
mvn clean install
```

### Quick Start

1. Configure database connection in `src/main/resources/META-INF/persistence.xml`:
```xml
<property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/hr"/>
<property name="javax.persistence.jdbc.user" value="your_username"/>
<property name="javax.persistence.jdbc.password" value="your_password"/>
```

2. Run the example:
```bash
mvn exec:java -Dexec.mainClass="au.com.ojitha.blogspot.jpaex1.jpa.JpaTest"
```

### More Detailed Examples

Creating an Employee with Department:
```java
EntityManager em = emf.createEntityManager();
EntityTransaction tx = em.getTransaction();

tx.begin();
Department dept = new Department();
dept.setName("Engineering");

Employee emp = new Employee();
emp.setPersonDetails(new PersonDetails("John", "Doe"));
emp.setDepartment(dept);

em.persist(dept);
em.persist(emp);
tx.commit();
```

### Troubleshooting

Common Issues:
1. Database Connection Failed
```
Error: Unable to connect to database
Solution: 
- Verify database credentials in persistence.xml
- Ensure MySQL service is running
- Check database port availability
```

2. Entity Mapping Issues
```
Error: Table not found
Solution:
- Set property "eclipselink.ddl-generation" to "create-tables"
- Verify @Entity annotations on domain classes
```

## Data Flow
The system manages employee data through JPA entities with bidirectional relationships and embedded objects.

```ascii
[Employee Entity] <----> [Department Entity]
       |
       +-----> [Asset Entity]
       |
       +-----> [Work Records]
       |
       +-----> [Leave Records]
       |
       +-----> [Contact Info (Embedded)]
```

Key Component Interactions:
1. Employee entities are the central domain objects
2. Departments maintain collections of employees
3. Assets are mapped one-to-one with employees
4. Work and Leave records are maintained as collections
5. Contact information is stored as embedded objects
6. Phone numbers are managed through a one-to-many relationship
7. All persistence operations are managed through JPA EntityManager