#!/bin/sh

cd ./bin


rm -R ./org/hy/xflow/engine/junit


jar cvfm hy.xflow.engine-client.jar MANIFEST.MF META-INF org

cp hy.xflow.engine-client.jar ..
rm hy.xflow.engine-client.jar
cd ..





cd ./src
jar cvfm hy.xflow.engine-client-sources.jar MANIFEST.MF META-INF org 
cp hy.xflow.engine-client-sources.jar ..
rm hy.xflow.engine-client-sources.jar
cd ..
