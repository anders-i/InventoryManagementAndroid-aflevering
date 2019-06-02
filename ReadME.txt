User Manual

Requirements:

Apache Maven version 3.6.1
Java version 1.8.0 
Javac version 1.8.0
Gradle version 3.4.1+
Android Studio

You also need to download the servers from https://github.com/anders-i/AuthManagementServer and https://github.com/anders-i/ProductManagementServer

Installation:

1. Create a database with a the name “postgres”
2. Add a user/role to the database with the name “admin” and password “1234” and give the
“admin” user permission to log in.
3. Run query file “/DB_dump” to create the database.
4. Edit the port number in “/AuthManagementServer/src/main/java/implementation/DataSource.java” and “/ProductManagementServer/src/main/java/implementation/DataSource.java” on line 31 to the port number your Database/PostgreSQL-server  is running on.
5. Edit the ip on line 28 and 29 to your own ipv4 address.
6. Start an explorer and execute the  “/InventoryManagementAndroid/install-jars.bat” file.
7. Start the servers by executing the “/AuthManagementServer/RunAllServers.bat” file. 
8. The program is ready to be started by running InventoryManagementAndroid in Android Studio.
