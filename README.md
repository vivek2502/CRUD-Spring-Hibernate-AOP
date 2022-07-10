# CRUD-Spring-Hibernate-AOP

Spring-Hibernate based web application having functionality of CRUD operation.

![image](https://user-images.githubusercontent.com/42957988/178134989-3984ffd7-0b43-414c-8cef-dfa4ef5dcdb4.png)

# Tech Stack

HTML, CSS, JSP

Java 1.8, Spring 5, Spring MVC, Hibernate

MySQL workbench

Tomcat Server

# Define db connection in : spring-mvc-crud-demo-servlet.xml
<bean id="myDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
      
    <property name="driverClass" value="com.mysql.cj.jdbc.Driver" />
    
    <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&amp;serverTimezone=UTC" />
    
    <property name="user" value="springstudent" />
    
    <property name="password" value="springstudent" /> 
