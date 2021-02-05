package com.atguigu.spring5.testdemo;

import com.atguigu.spring5.Book;
import com.atguigu.spring5.Orders;
import com.atguigu.spring5.User;
import com.atguigu.spring5.bean.Emp;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring5 {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean1.xml");
        User user = context.getBean("user", User.class);
        user.add();

        Book book = context.getBean("book", Book.class);
        System.out.println(book.toString());

        Orders orders = context.getBean("orders", Orders.class);
        System.out.println(orders.toString());

        UserService userService = context.getBean("userService", UserService.class);
        userService.add();


        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp.toString());
    }
}
