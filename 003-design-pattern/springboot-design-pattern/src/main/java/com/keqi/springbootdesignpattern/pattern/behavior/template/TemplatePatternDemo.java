package com.keqi.springbootdesignpattern.pattern.behavior.template;

/**
 * 模板模式
 */
public class TemplatePatternDemo {
	public static void main(String[] args) {
		/*
		模板模式的核心是规定了一个方法的执行步骤，但是具体步骤的实现可以任意。

		通常是依赖于方法而实现的

		举个例子来说，你玩游戏的常规流程肯定是要遵循三个步骤，初始化游戏(交钱)、开始游戏、结束游戏。
		但是具体的实现可以根据具体情况各自实现。

		模板就是把一个规范强制变成制度，用于规范他人的代码
		 */
		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}
}
