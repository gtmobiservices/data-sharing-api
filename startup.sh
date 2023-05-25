#!/bin/bash

/app/script/import-ssl-cert.sh
java -jar /app/gtmobi.jar /app/application.properties
