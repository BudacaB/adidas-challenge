package com.adidas.subscriptionservice.MessagingIntegration;

import org.eclipse.paho.client.mqttv3.*;

public class SubscriptionMessagingService {

    private String topic;
    private String broker;

    public SubscriptionMessagingService(String topic, String broker) {
        this.topic = topic;
        this.broker = broker;
    }

    public void publish(String message) {
        // get a random client ID
        String clientId = MqttAsyncClient.generateClientId();

        try {
            MqttClient mqttClient = new MqttClient(broker, clientId);
            MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();

            // configure connection options
            mqttConnectOptions.isCleanSession();
            mqttConnectOptions.isAutomaticReconnect();
            mqttConnectOptions.setConnectionTimeout(10);

            mqttClient.connect(mqttConnectOptions);

            mqttClient.publish(topic, new MqttMessage(message.getBytes()));
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
