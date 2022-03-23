package com.keqi.mqtt.connect;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ConnectTest {

    public static void main(String[] args) {

        String topic        = "MQTT Examples";
        String content      = "Message from MqttPublishSample";
        int qos             = 2;
        String broker       = "tcp://mqtt.eclipseprojects.io:1883";
        String clientId     = "JavaSample";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);






            // 设置connect 属性
            MqttConnectOptions connOpts = new MqttConnectOptions();
            // 持久化连接
            connOpts.setCleanSession(true);
            // 设置自动重连
            connOpts.setAutomaticReconnect(true);
            connOpts.setUserName("username");
//            connOpts.setPassword("password".getBytes());

            sampleClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {

                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");


            // 发送一个 qos为2的消息到 broker 中
            System.out.println("Publishing message: "+content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(topic, message);
            System.out.println("Message published");

//            sampleClient.subscribe(); // 订阅
//            IMqttToken iMqttToken = sampleClient.subscribeWithResponse();
//            iMqttToken.get
//            sampleClient.unsubscribe(); //


            // 断开连接(客户端主动断开)
            sampleClient.disconnect();

            System.out.println("Disconnected");
            System.exit(0);
        } catch(MqttException me) {

            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);

            me.printStackTrace();
        }
    }
}
