package br.com.fiap.demo_localstack

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoLocalStackApplication

fun main(args: Array<String>) {
	runApplication<DemoLocalStackApplication>(*args)
}
