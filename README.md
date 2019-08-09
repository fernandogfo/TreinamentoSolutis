```sh
  ____           _                               _     _
 |  _ \   _ __  | |      _   _   _ __     __ _  | |_  (_)   ___
 | | | | | '__| | |     | | | | | '_ \   / _` | | __| | |  / __|
 | |_| | | |    | |___  | |_| | | | | | | (_| | | |_  | | | (__
 |____/  |_|    |_____|  \__,_| |_| |_|  \__,_|  \__| |_|  \___|
```

# Treinamento JAVA 8 + Spring Solutis

### Projeto Java + Spring

 * [ESP8266 CIRCUIT](https://github.com/DrLunatic/ESP8266_MQTT_ANDROIDAPP/blob/master/NODEMCU%20ESP8266%20CIRCUIT.png)
 
### Projeto VueJS

* [ESP8266 CODE](https://github.com/DrLunatic/ESP8266_MQTT_ANDROIDAPP/blob/master/ESP8266_MQTT.ino)

### Docker para subir o postgres + pgAdmin

* [Código Classe principal/Main Class Code](https://github.com/DrLunatic/ESP8266_MQTT_ANDROIDAPP/blob/master/AndroidAppMainClassCODE)


### Links Interessantes abaixo vvvvvvv

* [Cron Maker](http://www.cronmaker.com)  + [Cron Trigger Tutorial](http://www.quartz-scheduler.org/documentation/quartz-2.3.0/tutorials/crontrigger.html) + [FreeFormatter Cron Expression Generator](https://www.freeformatter.com/cron-expression-generator-quartz.html) 

* [Vue.js](https://br.vuejs.org/v2/guide/index.html) + [Vue.js](https://hub.docker.com/_/postgres) 




```sh
        <uses-permission android:name="android.permission.WAKE_LOCK" />
        <uses-permission android:name="android.permission.INTERNET" />
        <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
        <uses-permission android:name="android.permission.READ_PHONE_STATE" />
```
```sh
        <service android:name="org.eclipse.paho.android.service.MqttService" >
        </service>
```

- Repositório Maven e Dependencias no build gradle do app / Repositories Maven and Dependencies on build gradle of the app:
```sh
        repositories {
         maven {
             url "https://repo.eclipse.org/content/repositories/paho-releases/"
                    }
                    }
```
```sh
         dependencies {
             compile('org.eclipse.paho:org.eclipse.paho.android.service:1.0.2') {
                    exclude module: 'support-v4'
          }
          }
```

### License
### MIT
