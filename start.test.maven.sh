#!/usr/bin/env bash

GATLING_ROOT_PATH_PREFIX=`./start.gatling.rootPathPrefix.sh`

# GATLING_ROOT_PATH_PREFIX=$GATLING_ROOT_PATH_PREFIX mvn gatling:test -Dgatling.simulationClass=io.qaload.gatling.reportExample.simulation.OpenModel_RampUsers2

GATLING_ROOT_PATH_PREFIX=$GATLING_ROOT_PATH_PREFIX mvn gatling:test -Dsimulation=OpenModel_RampUsers2
