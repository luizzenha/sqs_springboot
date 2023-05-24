package br.com.fiap.demo_localstack.service.impl

import br.com.fiap.demo_localstack.service.SQSService
import io.awspring.cloud.sqs.operations.SqsTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Service
import org.springframework.web.util.UriBuilder
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.sqs.SqsAsyncClient
import software.amazon.awssdk.services.sqs.SqsAsyncClientBuilder
import java.net.URI

@Service
class SQSServiceImpl (
    val sqsAsyncClient: SqsAsyncClient,
    @Value("\${app.my.queue}")
    val queue: String
        ) : SQSService  {



    override fun sendMessage(title: String, message: String) {
        val template = SqsTemplate.newTemplate(sqsAsyncClient)

        template.send(queue, mapOf(
            "title" to title,
            "message" to message
        ))
    }

}