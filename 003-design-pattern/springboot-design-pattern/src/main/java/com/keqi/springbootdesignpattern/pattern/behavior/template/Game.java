package com.keqi.springbootdesignpattern.pattern.behavior.template;

/**
 * 模板模式，核心之处在类的方法上面
 */
public abstract class Game {

	abstract void initialize();
	abstract void startPlay();
	abstract void endPlay();

	// 模板方法(为了防止被子类重写，最好加上final关键字)
	// 模板模式通过这种方式把规范变成了制度
	public final void play() {
		// 初始化游戏
		initialize();
		// 开始游戏
		startPlay();
		// 结束游戏
		endPlay();
	}
}
