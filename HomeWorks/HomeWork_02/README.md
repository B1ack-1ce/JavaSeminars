### Домашнее задание 2

Дана строка sql-запроса `"select * from students where "`. 

Сформируйте часть **WHERE** этого запроса, используя **StringBuilder**. 

Если значение `null`, то параметр не должен попадать в запрос.

Параметры для фильтрации: **{"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}**

В итоге должно получится: `select * from students where name=Ivanov, country=Russia, city=Moscow, age=null`
