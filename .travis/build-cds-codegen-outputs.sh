#!/usr/bin/env bash

set -x

body="{ \"request\": 
        { 
           \"branch\": \"$TRAVIS_BRANCH\",
           \"message\": \"Triggered by cds-models build log at: $TRAVIS_JOB_WEB_URL\"
        }
     }"
curl -s -X POST \
   -H "Content-Type: application/json" \
   -H "Accept: application/json" \
   -H "Travis-API-Version: 3" \
   -H "Authorization: token $TRAVIS_TOKEN" \
   -d "$body" \
   https://api.travis-ci.com/repo/ConsumerDataStandardsAustralia%2Fcds-codegen-outputs/requests
   
   
