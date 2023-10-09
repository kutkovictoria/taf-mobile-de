# taf-mobile-de

Технические требования к проекту:

- TAF API тестирования Mobile.de
- Сайт https://www.mobile.de/
- Проект Maven, TestNG, Rest Assured
- Создаем репозиторий на гитхабе taf-mobile-de
- Оформляем README.md файл проекта
- Результат работы - ссылки на итоговые репозитории отправляем в Slack >> announcement >> Replay in thread

------------------
Задание:

1.

- Отправляем запрос GET https://www.mobile.de/
- Проверяем ответ: Status Code = 200

------------------

2.

2.1 На сайте выбираем руками любую машину и смотрим в адресной строке ее id
2.2 Отправляем запрос:

- POST https://suchen.mobile.de/fahrzeuge/svc/my/parkings/значение_id_машины
- Хедер запроса
  x-mobile-vi =
  eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjaWQiOiJmZDM5MWZjMS00YmI3LTRkZjQt
  YTUxMS04YWIxNTJkOTRiZDIiLCJpYXQiOjE2Nzg4OTg3OTh9.4i0QiqIXw9FZOhuJQNs38
  I2pUL99pQgmEaOjwkCO4NY
- Тело (body) запроса
  {
  "adId": "значение_id_машины",
  "ref": null,
  "refId": null
  }
  2.3 Проверяем ответ: Status Code = 201
- Проверяем, что adId= значение_id_машины в теле:
  {
  "version": 0,
  "adId": значение_id_машины,
  "created": 1696775766,
  "price": {
  "amount": 150000.00,
  "currency": "EUR",
  "localized": "150.000 €"
  }
  }

3.

Отправляем запрос:

- POST https://www.mobile.de/api/my/account
- Хедер запроса:
  x-mobile-client=de.mobile.cis
- Тело (body) запроса
  {
  "email": "test@gmail.com",
  "password": "1q@W3e4r",
  "privacy": true,
  "generalTermsApproved": true,
  "privacySettings": [
  "ALLOW_MARKET_RESEARCH",
  "ALLOW_MARKETING_ACTIVITIES"
  ]
  }
- Проверяем ответ
  Status Code = 400
  В теле
  [
  {
  "field": "email",
  "code": "account-exists",
  "message": "Diese E-Mail-Adresse ist bereits registriert."
  }
  ]
- Проверяем все поля на соответствие значений

4.

- Отправляем запрос: POST https://www.mobile.de/api/my/account
  Хедер запроса
  x-mobile-client=de.mobile.cis
  Тело (body) запроса
  {
  "email": "",
  "password": "1q@W3e4r",
  "privacy": true,
  "generalTermsApproved": true,
  "privacySettings": [
  "ALLOW_MARKET_RESEARCH",
  "ALLOW_MARKETING_ACTIVITIES"
  ]
  }
- Проверяем ответ: Status Code = 400
  В теле
  [
  {
  "field": "email",
  "code": "email-empty",
  "message": "Bitte geben Sie eine E-Mail-Adresse ein."
  },
  {
  "field": "email",
  "code": "email-invalid",
  "message": "Die eingegebene E-Mail-Adresse ist ungültig."
  }
  ]
- Проверяем все поля на соответствие значений

5.

- Отправляем запрос: POST https://www.mobile.de/api/my/account
- Хедер запроса
  x-mobile-client=de.mobile.cis
- Тело (body) запроса
  {
  "email": "test1234523434@gmail.com",
  "password": "",
  "privacy": true,
  "generalTermsApproved": true,
  "privacySettings": [
  "ALLOW_MARKET_RESEARCH",
  "ALLOW_MARKETING_ACTIVITIES"
  ]
  }
- Проверяем ответ
  Status Code = 400
  В теле
  [
  {
  "field": "password",
  "code": "password-empty",
  "message": "Bitte gib ein Passtwort ein."
  }
  ]
- Проверяем все поля на соответствие значений
