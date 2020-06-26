# Simple Redis

```text
➜  ~ wrk -t12 -c200 -d30s http://127.0.0.1:8080
Running 30s test @ http://127.0.0.1:8080
  12 threads and 200 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     4.40ms  361.10us  16.29ms   90.45%
    Req/Sec     3.65k   180.42     6.13k    94.09%
  1311872 requests in 30.10s, 173.90MB read
  Socket errors: connect 0, read 3, write 0, timeout 0
Requests/sec:  43580.03
```


## build native
```bash
gradle assemble
native-image --no-server -cp build/libs/perf-0.1-all.jar
```
**micronaut 2.0 works!**

~~
failed

```bash
native-image --no-server -cp build/libs/perf-0.1-all.jar \
 --initialize-at-run-time=io.micronaut.configuration.lettuce.session.$RedisHttpSessionConfigurationDefinition \
 
```
```bash
native-image --no-server -cp build/libs/perf-0.1-all.jar --initialize-at-run-time=io.micronaut.configuration.lettuce.session.$RedisHttpSessionConfigurationDefinition,reactor.core.publisher.Mono,reactor.core.publisher.Flux
```
~~