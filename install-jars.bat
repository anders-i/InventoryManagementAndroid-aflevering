CD app\libs\AndroidApiLib
call mvn clean package install
CD ..\
CD AndroidApiClients
call mvn clean package install
TIMEOUT "5"