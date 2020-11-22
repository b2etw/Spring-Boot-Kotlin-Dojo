### mongodb
```shell script
$ docker exec -it $mongo_container_id mongo
> use admin;
> db.createUser({user:'root',pwd:'rootroot',roles:[{role:'readWrite',db:'test'}]});
```