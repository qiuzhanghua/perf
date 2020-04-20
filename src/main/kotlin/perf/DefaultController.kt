package perf

import io.lettuce.core.api.async.RedisAsyncCommands
import io.lettuce.core.api.sync.RedisCommands
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/")
open class DefaultController {

    @Inject
    var connection: io.lettuce.core.api.StatefulRedisConnection<String, String>? = null

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        var syncCommands: RedisCommands<String, String> = connection!!.sync()
//        return syncCommands.get("key")
        return syncCommands.hgetall("people:834212ef-7022-459e-a281-16342addc1d0")["name"]!!

//        var asyncCommands: RedisAsyncCommands<String, String> = connection!!.async()
//        return asyncCommands.get("key").get()!!
    }
}

// https://www.baeldung.com/java-redis-lettuce
// https://netty.io/wiki/native-transports.html