# Лабораторная работа 1
# Application with common JavaEE architecture
## Самигуллин Равиль гр 6133
## Ионов Артем гр 6131

### Задание 1
Download GlassFish application server.
Install it by unpacking the archive.
Start the application server.
Open an administrative console and go through its controls.
Мы использовали в реализации своего приложения Apache Tomcat.
Для первой лабораторной в качестве ide мы использовали net beans. 
/
Вставка картинки
/

### Задание 2
If you have no DBMS installed, please install one. You can choose any SQL DBMS you like, but PostgreSQL and MySQL are preferred.
В своей реализации мы использовали Mysql и Workbench.

/
Вставка картинки
/

### Задание 3
Choose any subject area and make a model with at least two entities with a few properties.
Create a script to make a database for your model.

Проектом мы выбрали представление магазина игр и энергетиков.
Создали сущности Energy.java и Game.java
Мы создали скрипты для создания бд и добавили туда данные.
/
Ссылки на файл со скриптами
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