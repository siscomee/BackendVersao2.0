echo off
cls

cd FrontendAngular
cmd /c npm install
cmd /c npm run ng build
cd ..
cmd /c robocopy FrontendAngular\dist\FrontendAngular BackendSpringboot\src\main\resources\public /E
cd BackendSpringboot
cmd /c mvn clean package -Ptest,sonar -Dmaven.test.skip=false
cd ..
cd BackendSpringboot\target
start java -jar -Xms1g misiscoint-backend.jar
cmd /c ping 127.0.0.1 -n 10
echo "Finalizado!"
exit /b 0

