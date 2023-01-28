#! /bin/bash


mvn -f ../ clean package

echo "Copy files over SSH...."

scp ../backend/target/backend-1.0.jar root@45.93.139.93:/home/ansis

echo "Restart server ...."

ssh root@45.93.139.93 << EOF

nohup redis-server &
pgrep java | xargs kill -9
nohup java -jar /home/ansis/backend-1.0.jar >> log.txt &

EOF

printf "\n\nAll done ..."
echo "http://quincyessentialmusic.com"