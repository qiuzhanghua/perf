FROM oracle/graalvm-ce:20.1.0-java11 as graalvm
RUN gu install native-image

COPY . /home/app/perf
WORKDIR /home/app/perf

RUN native-image --no-server -cp build/libs/perf-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/perf/perf /app/perf
ENTRYPOINT ["/app/perf"]
