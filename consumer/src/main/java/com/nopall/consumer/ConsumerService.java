package com.nopall.consumer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private JavaMailSender mailSender;

    @RabbitListener(queues = "myQueue")
    public void receiveMessage(String message) {
        System.out.println("Received: " + message);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("ervan@pnp.ac.id");
        mail.setSubject("Order Baru Masuk");
        mail.setText(
                "ORDER BARU MASUK\n\n" +
                        "Detail Order:\n" +
                        "------------------------\n" +
                        message + "\n" +
                        "------------------------\n\n" +
                        "Silakan segera diproses.\n\n" +
                        "Terima kasih.");

        mailSender.send(mail);
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println("Sent: " + message);
    }

}