package com.example

import io.kotest.core.spec.style.StringSpec
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class PerfTest(private val application: EmbeddedApplication<*>): StringSpec({

    "test the server is running" {
        assert(application.isRunning)
    }
})