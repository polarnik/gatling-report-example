#!/bin/bash

GATLING_ROOT_PATH_PREFIX=`./start.gatling.rootPathPrefix.sh`

GATLING_ROOT_PATH_PREFIX=$GATLING_ROOT_PATH_PREFIX sbt -Dgatling.data.graphite.rootPathPrefix=$GATLING_ROOT_PATH_PREFIX  "gatling:testOnly io.qaload.gatling.reportExample.simulation.OpenModel_AtOnceUsers"
