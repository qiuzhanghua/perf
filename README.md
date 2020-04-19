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
