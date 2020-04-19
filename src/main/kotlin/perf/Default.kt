package perf

import io.lettuce.core.api.sync.RedisCommands
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import javax.inject.Inject

@Controller("/")
open class DefaultController {

    @Inject var connection: io.lettuce.core.api.StatefulRedisConnection<String, String>? = null
    
    @Get(produces = [MediaType.TEXT_PLAIN])
    fun index(): String {
        var syncCommands: RedisCommands<String, String> = connection!!.sync()
        return syncCommands.get("key")
    }
}