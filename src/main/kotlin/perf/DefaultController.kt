package perf

import io.lettuce.core.api.async.RedisAsyncCommands
import io.lettuce.core.api.sync.RedisCommands
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.annotation.PostConstruct
import javax.inject.Inject

@Controller("/")
open class DefaultController {

    @Inject
    lateinit var connection: io.lettuce.core.api.StatefulRedisConnection<String, String>
    lateinit var syncCommands: RedisCommands<String, String>

    @PostConstruct
    fun init() {
        syncCommands = connection.sync();
    }

    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        return syncCommands.get("key")
//        return syncCommands.hgetall("people:834212ef-7022-459e-a281-16342addc1d0")["name"]!!
    }
}

// https://www.baeldung.com/java-redis-lettuce
// https://netty.io/wiki/native-transports.html