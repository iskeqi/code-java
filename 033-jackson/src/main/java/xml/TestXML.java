package xml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import json.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectMapper 是线程安全的，可以同时被多个线程共享
 */
public class TestXML {

    /*
        1、反序列化时忽略指定字段
            需要在 ObjectMapper 对象中做出以下配置：objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        2、序列化时忽略指定的名称
            在属性上使用注解：@JsonIgnore
            在类上使用注解(可以忽略一个或者多个字段)：@JsonIgnoreProperties

        3、序列化时修改字段名称
            在属性上使用 @JsonProperty 修改序列化时的名称

        4、序列化时格式化日期
            在属性上使用 @JsonFormat 注解指定格式化后的格式，如：@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone="GMT+8")

        总结：

        无论是序列化JSON还是XML，思路和API都是一样的，区别在于一个是 ObjectMapper 另一个是 XmlMapper


     */



    public static void main(String[] args) throws JsonProcessingException {
        TestXML testXML = new TestXML();
        Object s = testXML.Object2JsonString1();
        System.out.println(s);
    }


    // 单个对象 -> JSON 字符串
    public String Object2JsonString1() throws JsonProcessingException {
        Student s = new Student("keqi", 24, null);
        return XmlUtil.writeValueAsString(s);
    }

    // 列表 -> JSON 字符串
    public String List2JsonString1() throws JsonProcessingException {

        List<Student> list = new ArrayList<Student>();
        for (int i = 0; i < 3; i++) {
            Student s = new Student("keqi", 24 + i, null);
            list.add(s);
        }

        return XmlUtil.writeValueAsString(list);
    }

    // JSON字符串 -> 对象（无多余属性）
    public Student json2Object() throws JsonProcessingException {
        String json = Object2JsonString1();

        ObjectMapper objectMapper = new ObjectMapper();
        // {"name":"keqi","age":24,"score2":null}
        // 如果JSON 中有其他字段，是无法反序列化成功的，
        return objectMapper.readValue(json, Student.class);
    }

    // JSON字符串 -> 对象（有多余属性或者属性名称不对）
    public Student json2Object2() throws JsonProcessingException {
        String json = "<Student><name>keqi</name><age>24</age><score/></Student>";


        return XmlUtil.readValue(json, Student.class);
    }

    // JSON字符串 -> list对象（有多余属性或者属性名称不对）
    public <T> T jsonList2Object2(TypeReference<T> valueTypeRef) throws JsonProcessingException {
        String json = "<ArrayList><item><name>keqi</name><age>24</age><score/></item><item><name>keqi</name><age>25</age><score/></item><item><name>keqi</name><age>26</age><score/></item></ArrayList>";

        return XmlUtil.readValue(json, valueTypeRef);
    }
}
