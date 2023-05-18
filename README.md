# ING
[![CodeQL](https://github.com/florekk71/ING/actions/workflows/codeql.yml/badge.svg)](https://github.com/florekk71/ING/actions/workflows/codeql.yml)




Endpoint dla zadania z kolejką bankomatów:


curl -X POST http://localhost:8080/atms/calculateOrder -H 'Content-Type: application/json' -d '[{"region": 4,"requestType": "STANDARD","atmId": 1},{"region": 1,"requestType": "STANDARD","atmId": 1},{"region": 2,"requestType": "STANDARD","atmId": 1},{"region": 3,"requestType": "PRIORITY","atmId": 2},{"region": 3,"requestType": "STANDARD","atmId": 1},{"region": 2,"requestType": "SIGNAL_LOW","atmId": 1},{"region": 5,"requestType": "STANDARD","atmId": 2},{"region": 5,"requestType": "FAILURE_RESTART","atmId": 1}]'

Endpoint dla zadania z grą online:

curl -X POST http://localhost:8080/onlinegame/calculate -H 'Content-Type: application/json' -d '{"groupCount": 6,"clans": [{"numberOfPlayers": 4,"points": 50},{"numberOfPlayers": 2,"points": 70},{"numberOfPlayers": 6,"points": 60},{"numberOfPlayers": 1,"points": 15},{"numberOfPlayers": 5,"points": 40},{"numberOfPlayers": 3,"points": 45},{"numberOfPlayers": 1,"points": 12},{"numberOfPlayers": 4,"points": 40}]}'


Endpoint dla zadania z tranzakcjami bankowymi:


curl -X POST http://localhost:8080/transactions/report -H 'Content-Type: application/json' -d '[{"debitAccount": "32309111922661937852684864","creditAccount": "06105023389842834748547303","amount": 10.90},{"debitAccount": "31074318698137062235845814","creditAccount": "66105036543749403346524547","amount": 200.90},{"debitAccount": "66105036543749403346524547","creditAccount": "32309111922661937852684864","amount": 50.10}]'
