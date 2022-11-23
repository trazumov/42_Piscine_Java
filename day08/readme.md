xml самый старый способ - ex00 ex01
конфигурация через аннотации - ex02

Spring позволяет создавать объеты с зависимостями в "одну строку", зависимости в xml файл
ApplicationContext подтягивается через pom file, в BeanFactory можно увидеть зависимости и сам объект

Что делать если есть два бина одного класса ? Если его грепать, то произейдет exception. Что делать. ? getBean имеет перезагрузку метода с конкретным id

JdbcTemplae поставляется by String. Этот класс используется для работы с кодом и избавляет от того, чтобы писать много кода для работы с БД.
CreateReadUpdateDelete == CRUD\
interface CrudRepository<T> является дженериком
I extends I | C implement I | C extends C
Optional<User> Задачей этого класса является предоставление решений на уровне типа-обертки для обеспечения удобства обработки возможных null-значений

Одна UserRepository через Statements
UsersRepositoryJdbcTemplateImpl чере Bean DriverManagerDataSource
  
INSERT INTO users VALUES (?, ?); - 
  
Bean HicaryDS <- Bean JDBCImpl
Bead DriverManagerDS <- Bean JDBCTemplImpl

