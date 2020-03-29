package com.keqi.java8.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 测试java8新增的Stream API的特性
 */
public class StreamTest {

	private List<Student> studentList;

	@Before
	public void init() {
		Student s1 = new Student(1L, "肖战", 15, "浙江");
		Student s2 = new Student(2L, "王一博", 15, "湖北");
		Student s3 = new Student(3L, "杨紫", 17, "北京");
		Student s4 = new Student(4L, "李现", 17, "浙江");
		studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
	}

	/*
	 为什么要使用StreamAPI

	 StreamAPI说穿了，就是用来操作集合的一些语法糖而已，我使用for循环来操作一样可以达到相同效果呀。这么说的确是的，但是有这些好处：

	 	1) 操作更加优雅，使用StreamAPI可能只需要一行代码，但是使用for循环可能要写很多行
	 	2) 性能更好，当数据量很大的时候，可以很轻松的使用并行流来分开处理数据，最后再合并
	 	3) 业务上真的用得上，比如在分页查询的时候，有些场景不适合先连接在查询，需要查询出记录后
	 	    再去查询关联记录，这个时候就涉及到很多的列表操作

	总结：
		以后凡是遇到需要操作集合的时候，就想想能不能通过java8的StreamAPI来解决，而不要去使用for循环

	 */


	/**
	 * 集合的筛选 filter方法
	 * 适用场景：排除掉集合中的一部分元素(可以替代冗长的Iterator删除集合中元素的方法哦)
	 */
	@Test
	public void testFilter() {
		// filter方法用来会保留满足条件的数据，不满足的会别丢弃
		// Stream<T> filter(Predicate<? super T> predicate);

		// 筛选年龄大于15岁的学生
		// return students.stream().filter(s -> s.getAge()>15).collect(Collectors.toList());

		// 筛选住在浙江省的学生
		List<Student> collect = studentList.stream().filter(
				x -> "浙江".equals(x.getAddress())
		).collect(Collectors.toList());

		collect.forEach(System.out::println);
	}

	/**
	 * 集合转换
	 * 使用场景：只想取出集合中元素的某一个属性或者多个属性的组合
	 *  分页查询时，直接使用map()方法把id组装出来，再配合 <foreach/> 就可以查询对应的关联记录
	 *  最后再使用 stream 的分组来区分一下，非常好用的方式
	 */
	@Test
	public void testMap() {
		// map方法会把函数式接口返回的数据保存起来
		// <R> Stream<R> map(Function<? super T, ? extends R> mapper);

		// 在地址前面加上部分信息，只获取地址输出
		List<String> collect = studentList.stream().map(s -> "住址:" + s.getAddress()).collect(Collectors.toList());

		collect.forEach(System.out::println);
	}

	/**
	 * 集合去重（基本类型）
	 */
	@Test
	public void testDistinct() {
		// 简单字符串的去重，这里调用了equals()方法而已啦，对象也是同理
		List<Student> collect = studentList.stream().distinct().collect(Collectors.toList());
		collect.forEach(System.out::println);
	}

	/**
	 * 集合排序（默认排序）
	 */
	@Test
	public void testSort1() {
		// 采用默认排序方式
		List<String> list = Arrays.asList("333", "222", "111");
		list.stream().sorted().forEach(System.out::println);
	}

	/**
	 * 集合排序（指定排序规则）
	 */
	@Test
	public void testSort2() {
		// sorted()方法用来对集合中的元素进行排序(这里是自己手动指定排序方式)
		// Stream<T> sorted(Comparator<? super T> comparator);

		// 先按照学生的id进行降序排序，再按照年龄进行降序排序
		studentList.stream()
				//.sorted((stu1,stu2) ->Long.compare(stu2.getId(), stu1.getId()))
				.sorted((stu1, stu2) -> Integer.compare(stu2.getAge(), stu1.getAge()))
				.forEach(System.out::println);
	}

	/**
	 * 集合limit，返回前几个元素
	 */
	@Test
	public void testLimit() {
		// limit()方法和sql中的limit关键字作用是一样的啦

		List<String> list = Arrays.asList("333", "222", "111");
		list.stream().limit(2).forEach(System.out::println);
	}

	/**
	 * 集合skip，删除前n个元素
	 */
	@Test
	public void testSkip() {
		// skip()方法用来跳过(其实相当于是删除啦)集合中的前几个元素

		List<String> list = Arrays.asList("333", "222", "111");
		list.stream().skip(2).forEach(System.out::println);
	}

	/**
	 * 集合reduce,将集合中每个元素聚合成一条数据
	 */
	@Test
	public void testReduce() {
		List<String> list = Arrays.asList("欢", "迎", "你");
		String appendStr = list.stream().reduce("北京", (a, b) -> a + b);
		System.out.println(appendStr); // 输出结果为：北京欢迎你
	}

	/**
	 * 求集合中元素的最小值
	 */
	@Test
	public void testMin() {
		// 指定比较方式，然后求所有学生中年龄最小的一个
		// max()方法同理

		Student minS = studentList.stream().min(Comparator.comparingInt(Student::getAge)).get();
		System.out.println(minS.toString());
	}

	@Test
	public void testMatch() {
		// 指定比较方式，即传递一个Predicate接口的对象作为参数

		// anyMatch：Stream 中任意一个元素符合传入的 predicate，返回 true
		// allMatch：Stream 中全部元素符合传入的 predicate，返回 true
		// noneMatch：Stream 中没有一个元素符合传入的 predicate，返回 true

		boolean anyMatch = studentList.stream().anyMatch(s -> "湖北".equals(s.getAddress()));
		if (anyMatch) {
			System.out.println("有湖北人");
		}
		boolean allMatch = studentList.stream().allMatch(s -> s.getAge() >= 15);
		if (allMatch) {
			System.out.println("所有学生都满15周岁");
		}
		boolean noneMatch = studentList.stream().noneMatch(s -> "杨洋".equals(s.getName()));
		if (noneMatch) {
			System.out.println("没有叫杨洋的同学");
		}
	}

	@Test
	public void testGroupBy() {

		// 直接在内存中按照指定的key值进行分组，这个用的也是非常的频繁哦
		Map<Long, List<Student>> collect = studentList.stream().
				collect(Collectors.groupingBy(Student::getId));

		Set<Map.Entry<Long, List<Student>>> entries = collect.entrySet();
		for (Map.Entry<Long, List<Student>> entry : entries) {
			Long key = entry.getKey();
			List<Student> value = entry.getValue();
			System.out.println(key);
			System.out.println(value);
		}


	}
}
