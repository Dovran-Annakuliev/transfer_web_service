Web-Сервис перевода средств с карты на карту.
======

#### Должен обладать следующими возможностями:
- Добавление карт и просмотр их баланса
- Пополнение баланса карты
- Перевод средств на карты других клиентов:
    - Пользователь должен ввести номер карты того, кому переводятся деньги
    - После этого система должна запросить подтверждение перевода и отобразить ФИО того, кому переводятся деньги
    - После перевода, средства должны быть списаны с исходящей карты в счёт входящей
    - Сумма перевода не может превышать текущий остаток (баланс)
- Просмотра истории операций с возможностью фильтрации (*):
    - По сумме от/до
    - По счёту получателя
    - По дате от/до
- Отображения статистики за выбранный период (**): 
    - Сумма переводов в разрезе счетов получателей за период
    - Отношение поступлений к тратам
    - Операция с максимальной суммой за период
    - Средние траты в день за период

(\*), (\*\*) - задания повышенной сложности.

#### Данный сервис использует Apache Tomcat 9.0.41 и PostgreSQL 13.1

Web-Сервис перевода средств с карты на карту.
======

#### Должен обладать следующими возможностями:
- Клиент регистрируется
- Создать карту клиенту
- Просмотр баланса карты по нормеру
- Пополнение баланса карты по номеру
- Перевод средств с карты на карты других клиентов:
    - Пользователь должен ввести номер своей карты и карты того, кому переводятся деньги
    - После этого система должна запросить подтверждение перевода и отобразить ФИО отправителя и получателя
    - Перевод с карты на карту
    - Сумма перевода не может превышать текущий остаток (баланс)
    - После перевода, средства должны быть списаны с исходящей карты в счёт входящей
- Просмотра истории операций с возможностью фильтрации (*):
    - По сумме от/до
    - По счёту получателя
    - По дате от/до
