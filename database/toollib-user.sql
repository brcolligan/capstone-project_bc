-- ********************************************************************************
-- This script creates the database users and grants them the necessary permissions
-- ********************************************************************************

CREATE USER toollib_owner WITH PASSWORD 'toollib_owner1';

GRANT ALL 
ON ALL TABLES IN SCHEMA public
TO toollib_owner;

GRANT ALL 
ON ALL SEQUENCES IN SCHEMA public
TO toollib_owner; 

CREATE USER toollib_appuser WITH PASSWORD 'toollib_appuser1';

GRANT SELECT, INSERT 
ON ALL TABLES IN SCHEMA public
TO toollib_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO toollib_appuser; 