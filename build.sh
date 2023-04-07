#!/bin/bash

# Przejdź do katalogu z projektem
cd  "$(dirname "$0")"

# Wykonaj polecenie mvn clean install
mvn clean install

# Sprawdź kod wyjścia polecenia mvn clean install
if [ $? -eq 0 ]; then
    echo "Budowanie zakończone pomyślnie"
else
    echo "Błąd podczas budowania projektu"
    exit 1
fi
