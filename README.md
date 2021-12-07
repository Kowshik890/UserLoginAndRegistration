# UserLoginAndRegistration
### This is a small module of a project, which is a complete backend application for "User Login and Registration with Email Verification" using Spring Boot and PostgreSQL database. 
1. Database Setup (PostgreSQL):
     * create database in PostgreSQL
          * open terminal and write "psql postgres"
          * to see the list of databases, type "\l"
          * create database by "create database 'databaseName'"
          * add this database name in application.properties while configuring PostgreSQL
          * to connect to database "databaseName" as user "username", type \c "databaseName" [e.g: \c userloginandregistration]
          * to see the list of relations, type \d
          * to see the data in expanded dispaly, type \x, then write select query.
          ```
              # PostgreSQL Configuration
              spring.datasource.url = jdbc:postgresql://localhost:5432/databaseName
              spring.datasource.username = postgres
              spring.datasource.password = root
          ```
1. Development of Backend Application:
    * create "AppUser" model & "AppUserRole" for the user
    * to register a user, create "RegistrationRequest" model
    * to secure the application, spring security is used
        1. "WebSecurityConfig" class is created which extends spring "WebSecurityConfigurerAdapter" class to authenticate the user
        2. to encrypt the password, "BCryptPasswordEncoder" is used
    * to register a user:
        1. check the email whether it is valid or not
        2. check the email whether the email id exists or not
        3. after fulfilling all conditions, user details have inserted into database with encrypted password
        4. while registering a user, a POST request was submitted
        5. at that time data were inserted two tables: AppUser & ConfirmationToken
    * to confirm user's email
        1. fetch the inserted token from database
        2. if token is not present, give an exception
        3. check confirmation status of the token  whether it's already confirmed or not
        4. check its expiry time whether the token has expired or not
        5. UPDATE the confirmed time for that token in ConfirmationToken table
        6. take the user email to UPDATE "enable = true" in AppUser table which was "enable = false" initially
    * to send email for confirmation
        1. create a interface "EmailSender" and a "EmailService" class which implements "EmailSender" 
        2. "JavaMailSender" is a built-in interface which extends org.springframework.mail.MailSender
        3. for more understanding, go to "EmailService.java" file (Link)
        4. configure "application.properties" file for sending email
           ```
              # Email configuration
              spring.mail.host = localhost
              spring.mail.port = 1025
              spring.mail.username = hello
              spring.mail.password = hello
              spring.mail.properties.mail.smtp.ssl.trust=*
              spring.mail.properties.mail.smtp.auth=true
              spring.mail.properties.mail.smtp.starttls.enable=true
              spring.mail.properties.mail.smtp.connectiontimeout=5000
              spring.mail.properties.mail.smtp.timeout=3000
              spring.mail.properties.mail.smtp.writetimeout=5000
           ```
           
        5. given below is an experiment demonstration
        
