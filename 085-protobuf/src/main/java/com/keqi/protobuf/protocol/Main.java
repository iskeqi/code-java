package com.keqi.protobuf.protocol;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;

import java.util.Arrays;

public class Main {

    /*
        感悟：
            JSON 序列化是把 Java 对象和 JSON字符串 相互转换

            Protobuf 序列化是把 Java 对象和字节数组 相互转换

            其实本质上 JSON 和 protobuf 并无本质的区别，只不过一个是文本字符串形式，一个是二进制字节数组形式
     */

    public static void main(String[] args) throws InvalidProtocolBufferException {
        PersonModel.Person.Builder builder = PersonModel.Person.newBuilder();
        builder.setId(1);
        builder.setName("jihite");
        //builder.setEmail("jihite@jihite.com");

        PersonModel.Person person = builder.build();
        System.out.println("before:" + person);

        System.out.println("===Person Byte:");
        System.out.println(Arrays.toString(person.toByteArray()));
        System.out.println("================");
        for (byte b : person.toByteArray()) {
            System.out.print(b);
        }
        System.out.println();
        System.out.println("================");

        // 从对象序列化成字节数组
        byte[] byteArray = person.toByteArray();

        // 从字节数组反序列化成对象
        PersonModel.Person p2 = PersonModel.Person.parseFrom(byteArray);

        System.out.println("after id:" + p2.getId());
        System.out.println("after name:" + p2.getName());
        System.out.println("after email:" + p2.getEmail());


//        PersonModel.Person jack = PersonModel.Person.newBuilder()
//                .setId(1)
//                .setName("jack")
//                .setEmail("sag@taoq.tech")
//                .build();


        Configuration.Config.Builder builder1 = Configuration.Config.newBuilder();
        Configuration.Config config = builder1.setKey("a").setValue("a").setValueUnit("23").build();
        System.out.println(Arrays.toString(config.toByteArray()));

        Configuration.Configurations.Builder builder2 = Configuration.Configurations.newBuilder();

        Configuration.Configurations configurations = builder2.addConfig(config).build();
        System.out.println(Arrays.toString(configurations.toByteArray()));

        String json = JsonFormat.printer().print(p2);
        System.out.println(json);
    }
}
