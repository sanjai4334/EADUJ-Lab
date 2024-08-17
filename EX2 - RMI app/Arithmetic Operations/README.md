# RMI Application To Perform Arithmetic Operations

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
    javac *.java
    ```
2. ### Start The RMI Registry
    ```bash
    start rmiregistry 1099
    ```
3. ### Run the RMI Server
    ```bash
    java ArithmeticServiceImpl
    ```
4. ### Run the RMI Client
    Open another terminal and run the client.
    ```bash
    java ArithmeticClient
    ```