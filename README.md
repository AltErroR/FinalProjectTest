# FinalProjectTest
FinalProject for epam courses

![изображение](https://user-images.githubusercontent.com/79856335/145109186-1edf5d50-c739-4809-8cd7-dbf923cff40c.png)




Загальні вимоги до реалізації


1. На основі сутностей предметної області створити класи, які їм відповідають.
2. Класи і методи повинні мати назви, що відображають їх функціональність, і повинні бути
   рознесені по пакетам.
3. Оформлення коду має відповідати Java Code Convention.
4. Інформацію щодо предметної області зберігати у реляційній базі даних (в якості СУБД
   рекомендується використовувати MySQL або PostgreSQL).
5. Застосунок має підтримувати роботу з кирилицею (бути багатомовним), в тому числі при
   зберіганні інформації в базі даних:
   a. повинна бути можливість перемикання мови інтерфейсу;
   b. повинна бути підтримка введення, виведення і зберігання інформації (в базі даних),
   записаної на різних мовах;
   c. в якості мов обрати мінімум дві: одна на основі кирилиці (українська або російська),
   інша на основі латиниці (англійська);
   d. дати повинні бути реалізовані через DataTime бібліотеку (Java8).
6. Реалізувати захист від повторної відправки даних на сервер при оновленні сторінки
   (реалізувати PRG).
7. У застосунку повинні бути реалізовані аутентифікація і авторизація, розмежування прав
   доступу користувачів системи до компонентів програми. Шифрування паролів заохочується.
8. Впровадити у проект журнал подій із використанням бібліотеки log4j.
9. Код повинен містити коментарі документації (всі класи верхнього рівня, нетривіальні методи
   і конструктори).
10. Застосунок має бути покритим модульними тестами (мінімальний відсоток покриття 40%).
    Написання інтеграційних тестів заохочуються. Використання Mockito заохочується.
11. Реалізувати механізм пагінації сторінок з даними.
12. Всі поля введення повинні бути із валідацією даних.
13. Застосунок має коректно реагувати на помилки та виключні ситуації різного роду (кінцевий
    користувач не повинен бачити stack trace на стороні клієнта).
14. Самостійне розширення постановки задачі по функціональності заохочується! (додавання
    капчі, формування звітів у різних форматах, тощо)
15. Використання HTML, CSS, JS фреймворків для інтерфейсу користувача (Bootstrap, Materialize,
    ін.) заохочується!
16. Розробка проектів за допомогою Git заохочується.

    
    До сервлетного проекту:
    

17. Для доступу до даних використовувати JDBC API із застосуванням готового або ж
    розробленого самостійно пулу з'єднань.
    НЕ допускається використання ORM фреймворків
18. Архітектура застосунка повинна відповідати шаблону MVC.
    НЕ допускається використання MVC-фреймворків
    НЕ допускається використання Project Lombok
19. При реалізації бізнес-логіки необхідно використовувати шаблони проектування: Команда,
    Стратегія, Фабрика, Будівельник, Сінглтон, Фронт-контролер, Спостерігач, Адаптер та ін.
    Використання шаблонів повинно бути обґрунтованим
20. Використовуючи сервлети і JSP, реалізувати функціональність, наведену в постановці
    завдання.
21. Використовувати Apache Tomcat у якості контейнера сервлетів.
22. На сторінках JSP застосовувати теги з бібліотеки JSTL та розроблені власні теги (мінімум: один
    тег custom tag library і один тег tag file).
23. При розробці використовувати сесії, фільтри, слухачі.

Салон Краси

Система реалізує розклад роботи співробітників салону краси. Існують ролі: Гість, Клієнт, Адміністратор, Майстер.
Гість може бачити каталог послуг і список майстрів салону з врахуванням сортування:
- за ім’ям майстра;
- за рейтингом майстрів
  може здійснювати фільтрацію:
- за певним майстром;
- за послугами.
  Клієнт (авторизований користувач) може записатися на певну послугу, яку надає майстер, та на певний таймслот.
  Адміністратор може:
- переглядати заявки клієнтів і змінювати обраний таймслот;
- скасовувати запис;
- приймати оплату послуги.
  Майстер бачить свій розклад (зайняті і вільні таймслоти) і відмічає виконання замовлення.
  Після надання послуг Клієнт залишає відгук. Пропозиція про відгук приходить на електронну пошту Клієнта на наступний день після надання послуги.
