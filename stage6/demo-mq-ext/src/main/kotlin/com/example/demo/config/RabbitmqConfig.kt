package com.example.demo.config

import com.example.demo.service.MessageReceiver
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitmqConfig {

    @Bean
    fun queue() = Queue("test-queue", false)

    @Bean
    fun exchange() = TopicExchange("test-exchange")

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange) = BindingBuilder.bind(queue).to(exchange).with("com.example.demo.mq.#")

    @Bean
    fun container(connectionFactory: ConnectionFactory, listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {
        var container = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames("test-queue")
        container.setMessageListener(listenerAdapter)
        return container
    }

    @Bean
    fun listenerAdapter(messageReceiver: MessageReceiver) = MessageListenerAdapter(messageReceiver, "receiveMsg")
}