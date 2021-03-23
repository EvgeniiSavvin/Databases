## Setup on Linux

1. Download Oracle Database Express Edition (XE) Release 18.4.0.0.0 (18c) for Linux
   (https://www.oracle.com/ru/database/technologies/xe-downloads.html)
2. Find the downloaded RPM file
3. Setup and configure ```sqlplus``` as shown here https://manjaro.site/how-to-install-sqlplus-utility-on-ubuntu-18-04-and-ubuntu-18-10/
4. Follow the **build** instructions described here: https://github.com/fuzziebrain/docker-oracle-xe#build-image
5. Run ```run.sh```
6. Ur laptop will start rethinking its life choices, this is fine, just wait until "Completed 100%" and ```Completed: ALTER PLUGGABLE DATABASE XEPDB1 SAVE STATE```
7. In another terminal run ```connect-sysdba.sh```, this will open up sqlplus and connect to ur oracle as SYSDBA
8. Manually launch commands specified in ```image/run_this_manually.sh```
9. Now you can stop sqlplus and run ```connect.sh```, this will open sqlplus and connect as a plain user
10. Database should be working as expected, create/update/drop tables should work
11. Please note that ```~/st_and_db_labs_data``` was created for persistent Oracle trash that has to store somewhere
