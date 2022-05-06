package com.keqi.mqtt.connect;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.time.LocalDateTime;

public class TopicTest {

    // 客户端唯一标识符
    public static final String CLIENT_IDENTIFIER = "193234de359";
    // Broker 服务URL
    public static final String SERVER_URI = "tcp://114.132.245.130:1883";

    public static void main(String[] args) throws MqttException {
        // 创建 MqttClient 对象
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        MqttClient mqttClient = new MqttClient(SERVER_URI, CLIENT_IDENTIFIER, memoryPersistence);

        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 设置用户名
        mqttConnectOptions.setUserName("admin");
        // 设置密码
        mqttConnectOptions.setPassword("admin".toCharArray());
        // 设置会话清除标识
        mqttConnectOptions.setCleanSession(true);
        // 设置自动重连
        mqttConnectOptions.setAutomaticReconnect(true);
        // 设置 Keepalive 心跳时长为 60s
        mqttConnectOptions.setKeepAliveInterval(6);

        IMqttToken iMqttToken = mqttClient.connectWithResult(mqttConnectOptions);
        System.out.println(iMqttToken.getResponse().toString());

        String topic = "/elevator/F24C21/#";
        // 订阅所有以 /elevator/F24C21/ 开头的主题
        mqttClient.subscribe(topic, 1, new IMqttMessageListener() {
            @Override
            public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
                System.out.println(topic);
                System.out.println("===");
                System.out.println(new String(mqttMessage.getPayload()));
            }
        });

        try {
            System.out.println("开始睡眠 " + LocalDateTime.now());
            Thread.sleep(10000);
            System.out.println("结束睡眠 " + LocalDateTime.now());
        } catch (InterruptedException e) {
            System.out.println("睡眠 3 秒失败");
        }

        // 取消订阅主题
        mqttClient.unsubscribe(topic);
//
//        // Client 主动关闭连接
//        mqttClient.disconnect();
    }


}
