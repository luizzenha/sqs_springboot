package br.com.fiap.demo_localstack.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Conditional
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsAsyncClient
import java.net.URI

@Configuration
class SQSConfig {

    @Value("\${spring.cloud.aws.endpoint}")
    lateinit var customEndpoint:String;

    @Bean(name = ["sqsAsyncClient"])
    @ConditionalOnExpression("'\${app.localstack:false}' == 'true'")
    fun localSqsAsyncClient() :SqsAsyncClient {
        return SqsAsyncClient.builder().endpointOverride( URI.create(customEndpoint)).region(Region.SA_EAST_1).build()
    }

    @Bean(name = ["sqsAsyncClient"])
    @ConditionalOnExpression("'\${app.localstack:false}' == 'false'")
    fun defaultSqsAsyncClient() :SqsAsyncClient {
        return SqsAsyncClient.builder().region(Region.US_EAST_1).build()
    }
}