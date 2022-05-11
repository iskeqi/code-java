package com.keqi.mqtt.connect.robot;

import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.time.LocalDateTime;

public class ConnectRobot {

    // 客户端唯一标识符
    public static final String CLIENT_IDENTIFIER = "193bde35911a";
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
        // 设置为持久化连接
        mqttConnectOptions.setCleanSession(true);
        // 设置自动重连
        mqttConnectOptions.setAutomaticReconnect(true);
        // 设置 Keepalive 心跳时长为 60s
        mqttConnectOptions.setKeepAliveInterval(6);


        IMqttToken iMqttToken = mqttClient.connectWithResult(mqttConnectOptions);
        System.out.println(iMqttToken.getResponse().toString());

        try {
            System.out.println("开始睡眠 " + LocalDateTime.now());
            Thread.sleep(10000);
            System.out.println("结束睡眠 " + LocalDateTime.now());
        } catch (InterruptedException e) {
            System.out.println("睡眠 3 秒失败");
        }

        // Client 主动关闭连接
        mqttClient.disconnect();
    }


}
