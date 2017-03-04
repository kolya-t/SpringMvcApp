# SpringMvcApp
Spring (MVC + Data JPA + Security) + Thymeleaf
## Используемые технологии
- Java 8
- Spring 3.1.1:
  - MVC
  - Data JPA
  - Security
- Hibernate 3.5.6
- Bean Validation API 1.1
- Thymealeaf 2.1
- Bootstrap 3

## База данных
### Структура
#### user
Column Name | Datatype | PK | NN | UQ | AI
------------|----------|----|----|----|---
id | INT(11) | + | + | | +
login | VARCHAR(45) | | + | + | 
password | VARCHAR(45) | | + | | 
email | VARCHAR(45) | | + | + | 
enabled | BIT(1) | | + | | 

#### role
Column Name | Datatype | PK | NN | UQ | AI
------------|----------|----|----|----|---
id | INT(11) | + | + | | +
authority | VARCHAR(255) | | + | + | 

#### user_role
Column Name | Datatype | PK | NN | UQ | AI
------------|----------|----|----|----|---
id | BIGINT(20) | + | + | | +
user_id | BIGINT(20) | | + | | 
role_id | VARCHAR(45) | | + | | 

### Пример

#### user
id | login | password | email | enabled
---|-------|----------|-------|--------
1 | Sam | ffgf564b | sammy@gmail.com | 1
23 | dimon | fgfgdf | dimon2016@gmail.com | 1

#### role
id | authority
---|-------
1 | ROLE_USER
2 | ROLE_MODERATOR
3 | ROLE_ADMIN

#### user_role
id | user_id | role_id
---|---------|--------
1 | 1 | 2
6 | 23 | 1
7 | 23 | 3
