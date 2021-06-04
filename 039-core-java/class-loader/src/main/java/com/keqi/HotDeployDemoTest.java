package com.keqi;

/**
 * @author keqi
 */
public class HotDeployDemoTest {
	/*
		热部署的思路就是，检测字节码文件是否有更改，有更改就创建一个新的自定义的类加载器对象去加载字节码，然后得到
		Class 对象，最后创建实例对象，并替换之前的对象。如此实现了热更新！
	 */
}
