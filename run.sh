#!/bin/bash

# Przejdź do katalogu z projektem
cd "$(dirname "$0")"

# Wykonaj polecenie mvn spring-boot:run z określonymi argumentami JVM
mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"

# Sprawdź kod wyjścia polecenia mvn spring-boot:run
if [ $? -eq 0 ]; then
    echo "Uruchomienie aplikacji zakończone pomyślnie"
else
    echo "Błąd podczas uruchamiania aplikacji"
    exit 1
fi
