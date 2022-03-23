package com.keqi.mqtt.connect;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Demo1 {

    public static void main(String[] args) throws MqttException {
        // 使用内存持久化
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        // 设置 clientIdentifier
        String clientIdentifier = "93bde262-6264-4799-a7b9-afef899b111a";
        MqttClient mqttClient = new MqttClient("tcp://mqtt.eclipseprojects.io:1883", clientIdentifier, memoryPersistence);

        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 设置用户名
        mqttConnectOptions.setUserName("username");
        // 设置密码
        mqttConnectOptions.setPassword("password".toCharArray());
        // 设置持久化连接
        mqttConnectOptions.setCleanSession(false);
        // 设置 keepalive 心跳时间间隔
        mqttConnectOptions.setKeepAliveInterval(60);
        // 设置遗愿主题，遗愿消息，遗愿消息qos，遗愿消息是否是保留消息
        mqttConnectOptions.setWill("/home/" + clientIdentifier + "/status", "offline".getBytes(StandardCharsets.UTF_8), 1, true);

        // 建立连接，并同步获取连接结果
        IMqttToken iMqttToken = mqttClient.connectWithResult(mqttConnectOptions);
        System.out.println(iMqttToken.getResponse());


        // 发布消息
//        mqttClient.publish("/notice/93bde262-6264-4799-a7b9-afef899b111a", "a message".getBytes(StandardCharsets.UTF_8), 1,true);
//        System.out.println("publish a message");

        // 订阅一个主题消息
        IMqttToken response = mqttClient.subscribeWithResponse("/notice/93bde262-6264-4799-a7b9-afef899b111a", 1, new IMqttMessageListener() {
            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                System.out.println(topic + " -> " + new String(message.getPayload()));
            }
        });
        System.out.println(response.getResponse());

//        // 取消订阅
//        mqttClient.unsubscribe("/notice/93bde262-6264-4799-a7b9-afef899b111a");
//
//        mqttClient.subscribe("/notice/93bde262-6264-4799-a7b9-afef899b111a/notice", new IMqttMessageListener() {
//            @Override
//            public void messageArrived(String topic, MqttMessage message) throws Exception {
//                System.out.println("->" + topic + " -> " + new String(message.getPayload()) + " -> " + message.getId());
//            }
//        });

//        mqttClient.setCallback(new MqttCallbackExtended() {
//            @Override
//            public void connectComplete(boolean reconnect, String serverURI) {
//
//            }
//
//            @Override
//            public void connectionLost(Throwable cause) {
//
//            }
//
//            @Override
//            public void messageArrived(String topic, MqttMessage message) throws Exception {
//                System.out.println(topic + " -> " + new String(message.getPayload()) + " -> " + message.getId());
//            }
//
//            @Override
//            public void deliveryComplete(IMqttDeliveryToken token) {
//
//            }
//        });
//
//        for (int i = 0; i < 6; i++) {
//            MqttMessage message = new MqttMessage();
//            // 其实也可以这样发送一个文件，毕竟内容格式字节码
//            message.setPayload("ugsgg".getBytes(StandardCharsets.UTF_8));
//            mqttClient.publish("/notice/93bde262-6264-4799-a7b9-afef899b111a/notice", message);
//        }



        // 关闭连接
        //mqttClient.disconnect();
    }
}
