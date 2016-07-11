#!/bin/bash

for ((i=1;i<=100;i++)); do
        response=$(curl -s --header "Connection: keep-alive" "http://greeting-service-route-fuse-example.apps.pulsenow.co.uk/greeting/bluejeans")
        echo $response
        sleep 1s
done

