#!/bin/bash
set -ex
wget https://github.com/wynspeare/http-server/archive/make-server-dependent.tar.gz
tar -xzvf make-server-dependent.tar.gz
cd http-server-make-server-dependent && ./gradlew build
cd ..