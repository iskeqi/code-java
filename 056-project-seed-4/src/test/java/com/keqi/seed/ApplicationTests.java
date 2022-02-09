package com.keqi.seed;

import com.keqi.seed.core.util.JsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
        Ylcblpc t1 = new Ylcblpc();
        t1.setStatus(Ylcblpc.Status.BLZ.getCode());
        String s1 = JsonUtil.writeValueAsString(t1);
        System.out.println(s1);

        Ylcblpc t2 = JsonUtil.readValue(s1, Ylcblpc.class);
        System.out.println(JsonUtil.writeValueAsString(t2));

//        Ylcblpc.CallTypeAgv callTypeAgv = Ylcblpc.CallTypeAgv.NO.parse("2");
//        System.out.println(callTypeAgv.getCode() + " " + callTypeAgv.getCodeName());
    }

}
