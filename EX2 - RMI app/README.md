# RMI Application To manage Student Details Using SQL

## Setup Database
```sql
    CREATE DATABASE studentdb;

    USE studentdb;

    CREATE TABLE students (
    rollNum VARCHAR(255) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mobileNum VARCHAR(20) NOT NULL,
    yearOfStudy INT NOT NULL
    );
```

## Edit Connection Details
Edit `port` number, database : `name`, `username`, `password` in [StudentServiceImpl.java](./StudentServiceImpl.java#16).
```java
private static final String DB_URL = "jdbc:mysql://localhost:port/DBname";
private static final String DB_USER = "username";
private static final String DB_PASSWORD = "password";
```

## Set java path
### Setting the PATH Variable on Windows
1. Find Your JDK Installation Path:

   - Locate the directory where JDK is installed. For example, it might be something like 
   `C:\Program Files\Java\jdk-20\bin`

2. Open System Properties:

   - Open `Start Menu` and search `env`.
   - Open `Edit the system environment variables`.

3. Open Environment Variables:

   - In the System Properties window, click on the `Environment Variables` button near the bottom right.

4. Edit the PATH Variable:

   - In the Environment Variables window, locate the `Path` variable under the "System variables" section.
   - Select the `Path` variable and click on the `Edit` button.

5. Add the JDK Bin Directory:

   - In the Edit Environment Variable window, click on `New` and then add the path to the `bin` directory of your JDK installation.

## Run the project
1. ### Compile The Java Files
    ```bash
    javac -cp .;mysql-connector-j-9.0.0.jar *.java
    ```
2. ### Start The RMI Registry
    ```bash
    start rmiregistry 1099
    ```
3. ### Run the RMI Server
    ```bash
    java -cp .;mysql-connector-j-9.0.0.jar StudentServiceImpl
    ```
4. ### Run the RMI Client
    Open another terminal and run the client.
    ```bash
    java StudentClient
    ```