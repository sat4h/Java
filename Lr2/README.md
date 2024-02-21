# Лабораторная работа 2
# Application using Spring Framework
## Самигуллин Равиль гр 6133
## Ионов Артем гр 6131

### General task
You are to develop an application using common Spring architecture and technologies. It should have three layers (data, logic, view) and provide means to work with a database.
It is strongly recommended to use version control and source code management system (like GitHub).
It is strongly recommended to use Maven to manage your project.
You can choose any IDE, but IntelliJ IDEA is recommended.

### Задание 1
Choose any subject area and make a model with at least two entities with a few properties.
Create a script to make a database for your model.
Yes, you can use the same models and scripts you used before.

Была использована та же база данных, что и в 1 лабораторной работе.

[Ссылка на файл со скриптом для бд](https://github.com/sat4h/Java/blob/e532a6b018bf8201ff0d051dbdbdf12b01afd345/Lr1/gamesenergyskript.sql)

Мы использовали в реализации своего приложения Apache Tomcat.
Для второй лабораторной в качестве ide мы использовали IntelliJ IDEA. 

![image](https://github.com/sat4h/Java/assets/146749026/e7f05e00-03e7-44b0-9281-dc9b976a66b3)

### Задание 2
Develop data layer as Java Beans for the model and make them prepared for use with Hibernate.
Create additional Hibernate classes and configuration files, as required.

Были сделаны DAO файлы для работы с базой данных. Сделан HibernateConfig для подключения к бд, мы работали с mysql.

### Задание 3
Implement business layer using Spring beans.

Были созданы файлы service и controller, где прописаны методы add, edit, delete, getAll. 

![image](https://github.com/sat4h/Java/assets/146749026/47512118-9835-43d8-8e8e-0c7f81d3dcaf)

### Задание 4
Implement view layer using Spring MVC.

Для отображения нашего веб приложения, мы использовали jsp, добавив туда немного стиля.

![image](https://github.com/sat4h/Java/assets/146749026/bcd04f0c-b1f9-40d1-9d99-ce11c204871d)

### Задание 5
Make everything work together…

Одна из ошибок с которой мы столкнулись при запуске нашего приложения, это проблема с часовым поясом у mysqlconnection

![image](https://github.com/sat4h/Java/assets/146749026/051b3037-e6a8-4188-9933-3ff3d9e2ef67)

Поэтому добавили сервер Часового пояса Europe/Samara

'jdbc.url=jdbc:mysql://localhost:3306/test?serverTimezone=Europe/Samara&useSSL=false'
