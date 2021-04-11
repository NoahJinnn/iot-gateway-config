package com.iotgateway.coreservice.coreservice.configuration;

import com.iotgateway.coreservice.coreservice.constant.IotRabbitMQConstants;
import com.iotgateway.coreservice.coreservice.mq.IotMQReceiver;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
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
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(iotMQReceiver, "receive");
        messageListenerAdapter.setMessageConverter(jsonMessageConverter());
        return messageListenerAdapter;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}

