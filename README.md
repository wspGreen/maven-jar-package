# maven-jar-package
普通java项目转maven，多模块打jar包，加配置文件



## 环境

OS ： windows

IDE ：IntelliJ IDEA Community Edition 2021.3.2

Maven 使用 idea 自带



## 说明

打包插件有3种分别为 maven-assembly-plugin，maven-shade-plugin，maven-jar-plugin

本项目使用了 maven-jar-plugin  其他两种因为在打包配置没解决先不使用



### 打包第三方库

pom build 的配置

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-dependency-plugin</artifactId>
    <version>3.0.1</version>
    <executions>
        <execution>
            <id>copy-dependencies</id>
            <phase>prepare-package</phase>
            <goals>
                <goal>copy-dependencies</goal>
            </goals>
            <configuration>
                <!--                             拷贝依赖到target/bins-->
                <outputDirectory>
                    ${project.build.directory}/libs
                </outputDirectory>
            </configuration>
        </execution>
    </executions>
</plugin>
```



### 设置 manifest 

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-jar-plugin</artifactId>
    <version>2.4</version>
    <configuration>
        <archive>
            <manifest>
                <!-- manifest 文件在classpath添加依赖lib名称-->
                <addClasspath>true</addClasspath>
                <!-- manifest 文件在classpath添加依赖包前缀-->
                <classpathPrefix>libs/</classpathPrefix>
                <mainClass>
                    core.server.GameServer
                </mainClass>
            </manifest>
        </archive>
    </configuration>
</plugin>
```

### 导入外部jar

使用导入本地仓库的方式

如执行

```sh
mvn install:install-file -Dfile=gson-2.2.4.jar -DgroupId=com.lwt.gamelib -DartifactId=gson -Dversion=2.2.4 -Dpackaging=jar
```

将 gson-2.2.4.jar 导入本地库
