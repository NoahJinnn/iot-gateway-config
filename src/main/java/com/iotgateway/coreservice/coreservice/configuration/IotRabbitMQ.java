package com.iotgateway.coreservice.coreservice.configuration;

import com.iotgateway.coreservice.coreservice.constant.IotRabbitMQConstants;
import com.iotgateway.coreservice.coreservice.mq.IotMQReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IotRabbitMQ {

    @Bean
    Queue queue() {
        return new Queue(IotRabbitMQConstants.QUEUE_NAME, false);
    }

    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange(IotRabbitMQConstants.EXCHANGE_TOPIC);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange topicExchange) {
        return BindingBuilder.bind(queue).to(topicExchange).with("foo.bar.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(IotRabbitMQConstants.QUEUE_NAME);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean MessageListenerAdapter messageListenerAdapter(IotMQReceiver iotMQReceiver) {
        return new MessageListenerAdapter(iotMQReceiver, "receive");
    }
}

