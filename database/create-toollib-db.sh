#!/bin/bash
BASEDIR=$(dirname $0)
psql -U postgres -f "$BASEDIR/toollib-dropdb.sql" &&
createdb -U postgres toollib &&
psql -U postgres -d toollib -f "$BASEDIR/toollib-schema.sql" &&
psql -U postgres -d toollib -f "$BASEDIR/toollib-user.sql" &&
psql -U postgres -d toollib -f "$BASEDIR/toollib-data.sql"