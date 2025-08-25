### PowerShell scripts tp build aot cache with project Layden

```powershell
cd .\graphql-spring-boot\target
$J24 = C:\Install\Java\jdk-24.0.2\bin\java.exe
& $J24 -Djarmode=tools -jar app.jar extract --destination app
& $J24 -XX:AOTMode=record -XX:AOTConfiguration=app.aotconf -Dspring.profiles.active=appcds,h2 -jar app.jar
cd ..\oha
& .\oha.ps1
& $J24 "-XX:AOTMode=create" "-XX:AOTConfiguration=app.aotconf" "-XX:AOTCache=app.aot" -jar app.jar
& $J24 "-Xlog:cds" "-XX:AOTCache=app.aot" "-Dspring.profiles.active=h2" -jar app.jar
```
