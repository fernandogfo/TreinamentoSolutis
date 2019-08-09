```sh
  ____           _                               _     _
 |  _ \   _ __  | |      _   _   _ __     __ _  | |_  (_)   ___
 | | | | | '__| | |     | | | | | '_ \   / _` | | __| | |  / __|
 | |_| | | |    | |___  | |_| | | | | | | (_| | | |_  | | | (__
 |____/  |_|    |_____|  \__,_| |_| |_|  \__,_|  \__| |_|  \___|
```

# Treinamento JAVA 8 + Spring Solutis

### Projeto Java + Spring

 * [Java 8 + Spring](https://github.com/DrLunatic/TreinamentoSolutis)
 
### Projeto VueJS

* [VueJS](https://github.com/DrLunatic/projetoVuejs)
  Tive que por em outro repositório.

### Docker para subir o postgres + pgAdmin4

* [Docker postgres](https://hub.docker.com/_/postgres) + [Docker pgAdmin4](https://hub.docker.com/r/dpage/pgadmin4/)

```sh
        docker push drlunatic/vuejs:tagname
        docker push drlunatic/pgadmin4:tagname
        docker push drlunatic/postgres:tagname
        
        postgres
        docker run -p 5432:5432  --name container-postgresdb -e POSTGRES_USER=user -e POSTGRES_PASSWORD=admin -d postgres

        pdAdmin4
        docker run -p 5050:80  --name container-pgadmin -e PGADMIN_DEFAULT_EMAIL=ferna126@hotmail.com -e PGADMIN_DEFAULT_PASSWORD=admin         -d dpage/pgadmin4

        VueJS
        docker run -it -p 8080:8080 --rm --name dockerize-fernando-app-1 vuejs-fernando/dockerize-vuejs-app
          
          postgres db config
          host: host.docker.internal
          database: postgres
          user: postgres
          password: admin
        
```

### Links Interessantes abaixo vvvvvvv

* [Cron Maker](http://www.cronmaker.com)  + [Cron Trigger Tutorial](http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html) + [FreeFormatter Cron Expression Generator](https://www.freeformatter.com/cron-expression-generator-quartz.html) 

* [Vue.js](https://br.vuejs.org/v2/guide/index.html)


### Entretenimento e conhecimento

* [HipsterTech](https://hipsters.tech) para quem quiser se atualizar e aprender um pouco.



### License
### MIT
