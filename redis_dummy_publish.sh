#! /usr/bin/env bash

# Example usage:
# ./redis_dummy_publish.sh tradealgos_redis exch-1-btcusdbtc-240426

# abort on nonzero exitstatus
# set -o errexit
# abort on unbound variable
set -o nounset
# don't hide errors within pipes
set -o pipefail

CONTAINER=$1
CHANNEL=$2
while true; do docker exec -it $CONTAINER redis-cli PUBLISH $CHANNEL `openssl rand -base64 12`; sleep 2; done