package br.com.fiap.demo_localstack.service

interface SQSService {
    fun sendMessage(title:String, message: String);
}