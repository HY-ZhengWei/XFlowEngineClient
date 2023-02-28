#!/bin/sh

mvn install:install-file -Dfile=hy.xflow.engine-client.jar                              -DpomFile=./src/main/resources/META-INF/maven/cn.openapis/hy.xflow.engine-client/pom.xml
mvn install:install-file -Dfile=hy.xflow.engine-client-sources.jar -Dclassifier=sources -DpomFile=./src/main/resources/META-INF/maven/cn.openapis/hy.xflow.engine-client/pom.xml

mvn deploy:deploy-file   -Dfile=hy.xflow.engine-client.jar                              -DpomFile=./src/main/resources/META-INF/maven/cn.openapis/hy.xflow.engine-clientpom.xml -DrepositoryId=thirdparty -Durl=http://HY-ZhengWei:8081/repository/thirdparty
mvn deploy:deploy-file   -Dfile=hy.xflow.engine-client-sources.jar -Dclassifier=sources -DpomFile=./src/main/resources/META-INF/maven/cn.openapis/hy.xflow.engine-clientpom.xml -DrepositoryId=thirdparty -Durl=http://HY-ZhengWei:8081/repository/thirdparty
