

cd .\bin


rd /s/q .\org\hy\xflow\engine\junit


jar cvfm hy.xflow.engine-client.jar MANIFEST.MF META-INF org

copy hy.xflow.engine-client.jar ..
del /q hy.xflow.engine-client.jar
cd ..





cd .\src
jar cvfm hy.xflow.engine-client-sources.jar MANIFEST.MF META-INF org 
copy hy.xflow.engine-client-sources.jar ..
del /q hy.xflow.engine-client-sources.jar
cd ..
