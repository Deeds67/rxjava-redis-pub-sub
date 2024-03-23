
import io.lettuce.core.RedisClient
import io.lettuce.core.pubsub.StatefulRedisPubSubConnection
import io.lettuce.core.pubsub.api.reactive.RedisPubSubReactiveCommands
import io.reactivex.rxjava3.core.Observable

object RedisPubSub {
    fun observe(redisClient: RedisClient, channel: String): Observable<String> {
        val connection: StatefulRedisPubSubConnection<String, String> = redisClient.connectPubSub()
        val reactiveCommands: RedisPubSubReactiveCommands<String, String> = connection.reactive()

        return Observable.create { emitter ->
            reactiveCommands.subscribe(channel).subscribe()

            reactiveCommands.observeChannels().filter { message -> message.channel == channel }.subscribe { message ->
                emitter.onNext(message.message)
            }

            emitter.setCancellable { reactiveCommands.unsubscribe(channel) }
        }
    }
}