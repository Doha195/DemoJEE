FROM tomcat:9.0.56
ADD target/DemoJEE.war /usr/local/tomcat/webapps/DemoJEE.war
EXPOSE 8080
CMD ["catalina.sh", "run"]