# Лабораторная работа 1
# Application with common JavaEE architecture
## Самигуллин Равиль гр 6133
## Ионов Артем гр 6131

### General task
You are to develop an application using common JavaEE architecture and technologies. It should have three layers (data, logic, view) and provide means to work with a database.

It is strongly recommended to use version control and source code management system (like GitHub).

It is strongly recommended to use Maven to manage your project.

You can choose any IDE, but IntelliJ IDEA is recommended.

You may not use IDE to deploy your project to an application server. All deployment should be made using administrative console.

### Задание 1
Download GlassFish application server.
Install it by unpacking the archive.
Start the application server.
Open an administrative console and go through its controls.
Мы использовали в реализации своего приложения Apache Tomcat.
Сначала мы сделали вторую лабораторную работу, где использовали IntelliJ IDEA, а
для первой лабораторной в качестве ide мы использовали NetBeans IDE. 

![image](https://github.com/sat4h/Java/assets/146749026/4a6a832c-a6ad-4690-95c4-5fa07c3938a7)


### Задание 2
If you have no DBMS installed, please install one. You can choose any SQL DBMS you like, but PostgreSQL and MySQL are preferred.
В своей реализации мы использовали Mysql и Workbench.

![image](https://github.com/sat4h/Java/assets/146749026/0bf43d4c-5301-45b0-9e49-3ed2a6b4cb59)


### Задание 3
Choose any subject area and make a model with at least two entities with a few properties.
Create a script to make a database for your model.

Проектом мы выбрали представление магазина игр и энергетиков.
Создали сущности Energy.java и Game.java
Мы создали скрипты для создания бд и добавили туда данные.

/
[Ссылка на файл со скриптом](https://github.com/sat4h/Java/blob/e532a6b018bf8201ff0d051dbdbdf12b01afd345/Lr1/gamesenergyskript.sql)
/


### Задание 4
Develop data layer as Java Beans for the model and make them prepared for use with Entity Persistence.

Мы добавили слой взаимодействия с базой данных использовали jdbc. Создали файлы DAO в качестве прослойки для доступа к данным.
\
файл связи с бд
\

### Задание 5
Implement business layer for accessing data using session beans.

Мы добавили файлы сервлетов сервисные файлы для представления бизнес логики.
\

\

### Задание 6
Implement view layer using any technology of your choice, which is applicable here.

Для слоя представления были созданы файлы .jsp.
И мы получили следующие выводы на веб страницу.

### Задание 7
Make everything work together…

\
Скрины проекта.
\
