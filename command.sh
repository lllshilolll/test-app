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

docker run --name metrics-app \
  -p 8428:8428 \
  --net=app_net \
  -v ./config/metrics.yaml:/metrics.yaml  \
  victoriametrics/victoria-metrics \
  -promscrape.config=metrics.yaml


docker run --name metrics-app \
  -p 8428:8428 \
  --net=app_net \
  -v ./config/metrics.yaml:/metrics.yaml  \
  victoriametrics/victoria-metrics \
  -promscrape.config=metrics.yaml

docker run -d --name=grafana \
  -p 3000:3000 \
  --net=app_net \
  -u "$(id -u)" \
  grafana/grafana

docker run -p 3100:3100 \
  --name=loki \
  --net=app_net \
   grafana/loki:2.9.0

#docker build -t test-app:1.0-SNAPSHOT .

docker run -p 8080:8080 \
  --name=test_app \
  --net=app_net \
  -e LOKI=http://loki:3100 \
  test-app:1.0-SNAPSHOT