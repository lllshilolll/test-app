#create volume
docker volume create postgres_vol_1
docker volume create postgres_vol_2


#create network
docker network create app_net
docker network inspect app_net
docker network connect app_net postges_1-13.3
docker network connect app_net quizzical_galileo

#run container with delete and fon
docker run -d \
  --name postgresqldb \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres_admin \
  -e POSTGRES_USER=postgres_admin \
  -e POSTGRES_DB=test_app \
  -v postgres_vol_1:/var/lib/postgesql/data \
  --net=app_net \
  -d postgres:13.3

#docker build -t test-app:1.0-SNAPSHOT .
#docker run -p 8080:8080 --name=test_app --net=app_net test-app:1.0-SNAPSHOT