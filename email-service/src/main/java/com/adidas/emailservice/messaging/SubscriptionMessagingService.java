package com.adidas.emailservice.messaging;

import com.adidas.emailservice.service.EmailDispatchService;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import java.nio.charset.StandardCharsets;

public class SubscriptionMessagingService {

    private String topic = "";
    private String broker = "";
    private EmailDispatchService emailDispatchService = new EmailDispatchService();

    public SubscriptionMessagingService(String topic, String broker) {
        this.topic = topic;
        this.broker = broker;
    }

    public void subscribe() {
        String clientId = MqttAsyncClient.generateClientId();

        try {
            MqttClient mqttClient = new MqttClient(broker, clientId);
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();

            // configure connection options
            mqttConnectOptions.isCleanSession();
            mqttConnectOptions.isAutomaticReconnect();
            mqttConnectOptions.setConnectionTimeout(10);

            mqttClient.connect(mqttConnectOptions);

            // this function fires whenever there's a new message
            mqttClient.subscribe(topic, (topic, msg) -> {
                handleMessage(new String(msg.getPayload(), StandardCharsets.UTF_8));
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void handleMessage(String message) {
        emailDispatchService.dispatchEmail(message);
    }
}
