FROM java:8
MAINTAINER trushn45@gmail.com
VOLUME /tmp
#We added a VOLUME pointing to "/tmp" because that is where a Spring Boot application creates working directories for Tomcat by default

EXPOSE 8080

# Install maven
#RUN apt-get update  
#RUN apt-get install -y maven

ENV USER_NAME propagation-sample-spring
ENV APP_HOME /home/$USER_NAME/app

RUN useradd -ms /bin/bash $USER_NAME  #añades el usuario
RUN mkdir $APP_HOME



# Prepare by downloading dependencies
#ADD pom.xml $APP_HOME/pom.xml  
#RUN ["mvn", "dependency:resolve", "-X"]  
#RUN ["mvn", "verify"]

# Adding source, compile and package into a fat jar
#ADD src $APP_HOME/src  
#RUN ["mvn", "package"]




#Estas líneas si añado desde mi local el jar, ahora mismo se comentan porque se esta haciendo 
#maven desde el proyecot
ADD target/propagation-sample-0.0.1-SNAPSHOT.jar $APP_HOME/propagation-sample-0.0.1-SNAPSHOT.jar
RUN chown $USER_NAME $APP_HOME/propagation-sample-0.0.1-SNAPSHOT.jar #se hace propeitario a username

USER $USER_NAME
WORKDIR $APP_HOME

RUN bash -c 'touch propagation-sample-0.0.1-SNAPSHOT.jar'
# command is to ‘touch’ the JAR and give it a modified date.
#This actually isn’t important for the simple app that we wrote, but any static content (e.g. "index.html") would require the file to #have a modification time.


ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","propagation-sample-0.0.1-SNAPSHOT.jar"]



#CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","target/propagation-sample-0.0.1-SNAPSHOT.jar"]

  
