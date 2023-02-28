

del /Q hy.xflow.engine-client.jar
del /Q hy.xflow.engine-client-sources.jar


call mvn clean package
cd .\target\classes


rd /s/q .\org\hy\xflow\engine\junit


jar cvfm hy.xflow.engine-client.jar META-INF/MANIFEST.MF META-INF org

copy hy.xflow.engine-client.jar ..\..
del /q hy.xflow.engine-client.jar
cd ..\..





cd .\src\main\java
xcopy /S ..\resources\* .
jar cvfm hy.xflow.engine-client-sources.jar META-INF\MANIFEST.MF META-INF org 
copy hy.xflow.engine-client-sources.jar ..\..\..
del /Q hy.xflow.engine-client-sources.jar
rd /s/q META-INF
cd ..\..\..
