package br.com.fiap.demo_localstack.controller

import br.com.fiap.demo_localstack.dto.MessageDto
import br.com.fiap.demo_localstack.service.SQSService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/sqs")
@RestController
class SQSController (
    val sqsService: SQSService
        ) {


    @PostMapping
    fun postMessage(@RequestBody messageDto: MessageDto){
        sqsService.sendMessage(messageDto.title, messageDto.message)
    }
}