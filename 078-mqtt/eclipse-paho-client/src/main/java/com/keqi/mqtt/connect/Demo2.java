package com.keqi.mqtt.connect;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo2 {

    public static final String CLIENT_IDENTIFIER = "93bde359-6264-4799-a7b9-afef899b111a";
    public static final String SERVER_URI = "tcp://mqtt.eclipseprojects.io:1883";
    public static final String TOPIC = "/msg/93456264-6264-4129-a7b9-afef899b111a/topic1";
    public static final String TOPIC2 = "/msg/92526262-6264-4799-a7b9-afef899b111a/topic1";

    public static void main(String[] args) throws MqttException {
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        MqttClient mqttClient = new MqttClient(SERVER_URI, CLIENT_IDENTIFIER, memoryPersistence);
//        MqttAsyncClient mqttClient = new MqttAsyncClient(SERVER_URI, CLIENT_IDENTIFIER, memoryPersistence);


        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        mqttConnectOptions.setCleanSession(true);
        mqttConnectOptions.setAutomaticReconnect(true);

        mqttClient.connect(mqttConnectOptions);

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        executor.schedule(() -> {
            System.out.println("发送消息：" + Thread.currentThread().getName());
            for (int i = 0; i < 100; i++) {
                MqttMessage message = new MqttMessage();
                message.setPayload((LocalDateTime.now() + " -> " + UUID.randomUUID()).getBytes(StandardCharsets.UTF_8));
                try {
                    mqttClient.publish(TOPIC, message);
                    mqttClient.publish(TOPIC2, message);
                } catch (MqttException e) {
                    e.printStackTrace();
                }
            }
        }, 5, TimeUnit.SECONDS);

        // 不同的 topic 发送过来的消息，使用的都是同一个线程名称为：MQTT Call 的线程接收的消息，如果希望使用多线程来接收消息，需要自己
        // 使用一个线程池，交给不同的线程去处理，mqtt类库内部并没有实现这种机制，自己实现就好了
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        AtomicInteger count = new AtomicInteger();
        mqttClient.subscribe(TOPIC, (topic, message) -> {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(count + " | " + Thread.currentThread().getName() + " | " + new String(message.getPayload()));
                }
            });
        });

        mqttClient.subscribe(TOPIC2, (topic, message) -> {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(count + " | " + Thread.currentThread().getName() + " | " + new String(message.getPayload()));
                }
            });
        });

//        mqttClient.subscribe(TOPIC);
//        mqttClient.subscribe(TOPIC2);


//        mqttClient.setCallback(new FooCallbackListener(executorService));
    }

    public static class FooCallbackListener implements MqttCallback {

        ExecutorService executorService;

        public FooCallbackListener(ExecutorService executorService) {
            this.executorService = executorService;
        }

        @Override
        public void connectionLost(Throwable e) {
            e.printStackTrace();
        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
            //TODO:emtpy
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            // 手动使用线程池进行处理数据
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " | " + new String(message.getPayload()));
                }
            });
        }

    }
}
