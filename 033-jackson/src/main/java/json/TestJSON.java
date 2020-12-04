package json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * ObjectMapper 是线程安全的，可以同时被多个线程共享
 */
public class TestJSON {

    public static void main(String[] args) throws JsonProcessingException {
        TestJSON testJSON = new TestJSON();
        Object obj = testJSON.json2Object2();
        System.out.println(obj);
    }


    // 单个对象 -> JSON 字符串
    public String Object2JsonString1() throws JsonProcessingException {
        Student s = new Student("keqi", 24, null);
        ObjectMapper objectMapper = new ObjectMapper();
        // 默认是会把属性为 null 属性序列化的
        return objectMapper.writeValueAsString(s);
    }

    // 列表 -> JSON 字符串
    public String List2JsonString1() throws JsonProcessingException {

        List<Student> list = new ArrayList<Student>();
        for (int i = 0; i < 3; i++) {
            Student s = new Student("keqi", 24 + i, null);
            list.add(s);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        // 同一个方法输出数组也没有问题
        return objectMapper.writeValueAsString(list);
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
        String json = "{\"name\":\"keqi\",\"age\":24,\"score2\":null}";
        ObjectMapper objectMapper = new ObjectMapper();

        // 反序列化时，如果有多余参数或属性名不对，需要显示做此配置
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return objectMapper.readValue(json, Student.class);
    }
}
