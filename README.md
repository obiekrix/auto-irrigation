# Automatic Irrigation System

**HOW TO RUN**
1. Make sure jdk 8 or above is properly installed in your PC.
2. Also make sure Maven is installed and classpath is properly set.
3. Pull the source code from the git repo to your PC.
4. Build to application by typing the command below at the project root:</br>
   `mvn clean package`
5. The above command will run all tests and compile the code.
6. Run the application by typing the command below at the project root:</br>
   `java -jar target\auto-irrigation-1.0-SNAPSHOT.jar"`
7. Once running, you can see and try out all the endpoints from your browser by entering the URL http://localhost:8123/swagger-ui/index.html
8. You can also see the database tables from your browser by entering http://localhost:8123/h2-console
