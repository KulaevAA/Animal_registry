@echo off
rem Компиляция
javac -cp ".;..\lib\mysql-connector-java-5.1.49-bin.jar" Main.java AnimalDatabase.java
if errorlevel 1 (
    echo Компиляция не удалась.
    pause
    exit /b 1
)

rem Запуск
java -cp ".;..\lib\mysql-connector-java-5.1.49-bin.jar" Main
