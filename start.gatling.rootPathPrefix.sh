#!/bin/bash
# ./start.gatling.rootPathPrefix.sh

datetimePrefix=`date '+%Y-%m-%d_%H'`
dateTimeMinute=`date '+%M'`

round=5
roundMinute=$(expr "$dateTimeMinute" / $round)
roundMinute=$(expr "$roundMinute" \* $round)
roundMinute=$(printf "%02d" $roundMinute)

export GATLING_PREFIX="v2.gatling.$datetimePrefix:$roundMinute.`hostname`"

echo $GATLING_PREFIX