package com.keqi.springbootdesignpattern.pattern.behavior.interpreter;

/**
 * 解释器模式
 */
public class InterpreterPatternDemo {

	/*
		解释器模式有点过于底层了，实际业务开发中很少会用到。倒是一些框架中经常会用到，
		比如SQL、表达式等这些符号的解析上面。

	 */

	//规则：Robert 和 John 是男性
	public static Expression getMaleExpression(){
		Expression robert = new TerminalExpression("Robert");
		Expression john = new TerminalExpression("John");
		return new OrExpression(robert, john);
	}

	//规则：Julie 是一个已婚的女性
	public static Expression getMarriedWomanExpression(){
		Expression julie = new TerminalExpression("Julie");
		Expression married = new TerminalExpression("Married");
		return new AndExpression(julie, married);
	}

	public static void main(String[] args) {
		Expression isMale = getMaleExpression();
		Expression isMarriedWoman = getMarriedWomanExpression();

		System.out.println("John is male? " + isMale.interpret("John"));
		System.out.println("Julie is a married women? "
				+ isMarriedWoman.interpret("Married Julie"));
	}
}
