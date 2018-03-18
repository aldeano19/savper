#!/usr/bin/env bash

set -x

mongod &
sleep 3
mongo < /mongodb-dependencies/initial-setup.js

# needs a perpetual process running for the container to stay alive. 
# The tail command serves that purpose
tail -f /dev/null