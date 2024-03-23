# rxjava-redis-pub-sub

This is a sample project of how to use Redis Pub/Sub with RxJava.
This example subscribes to multiple channels and uses `combineLatest` to combine the results into one list.

### How to run

```bash
docker compose up --detach
./gradlew run
```

### How to emit dummy data:

1. Get the docker container name for your redis:
```bash
docker ps
```

2. Pass this along with the redis channel you want to publish to:
```bash
./redis_dummy_publish.sh <container_name> <channel_name>
```

e.g.

```bash
./redis_dummy_publish.sh rxjava-redis-pub-sub-redis-1 channel
```
