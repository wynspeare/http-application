#!/bin/bash
set -ex
wget https://github.com/wynspeare/http-server/archive/make-server-dependent.tar.gz
tar -xzvf make-server-dependent.tar.gz
mv http-server-make-server-dependent/build/libs/httpServer-1.0-SNAPSHOT.jar build/libs/

