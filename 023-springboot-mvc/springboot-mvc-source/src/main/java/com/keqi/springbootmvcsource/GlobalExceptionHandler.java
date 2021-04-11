package com.keqi.springbootmvcsource;

import com.keqi.springbootmvcsource.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理器(SpringMVC 中此类可以存在多个，可根据实际情况进行扩展)
 *
 * @author keqi
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {



    /**
     * 这个异常必须要放在最后
     *
     * @param e Throwable
     * @return r
     */
    @ExceptionHandler(Throwable.class)
    public Student throwable(Throwable e) {
        System.out.println("===========");
        Student student = new Student();
        student.setName("keqi");
        student.setAge(12);
        return student;
    }

}
