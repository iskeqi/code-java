package com.keqi.springbootemail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

@SpringBootTest
class SpringbootEmailApplicationTests {

	// 由于springboot的自动配置，所以直接注入此对象即可
	@Autowired
	private JavaMailSender mailSender;

	// 导入thymeleaf模板
	@Autowired
	TemplateEngine templateEngine;

	/**
	 * 发送普通文本邮件
	 * @throws Exception
	 */
	@Test
	public void sendSimpleMail() throws Exception {
		// 发送简单文本邮件，使用此对象即可
		SimpleMailMessage message = new SimpleMailMessage();

		// 必须和发送邮箱保持一致(也就是说，没有自定义的可能性，所以无需对外暴露，但是却需要显示设置，不设置还不行，真是奇怪)
		// mail from address must be same as authorization user
		message.setFrom("1209023760@qq.com"); // 也就是和配置文件里面配置的邮箱要保持相同

		// 邮箱地址设置错了，并不会报错，邮件服务器会忽略掉它的存在
		String users[] = {"keqi@my7g.cn","1209023760@qq.com"}; // 一次性发送多个邮箱地址，通过重载的数组参数的方法即可
		message.setTo(users); // 设置邮件接收者，可以有多个接收者
		// message.setTo("keqi@my7g.cn"); // 如果只发送一个邮箱，那就用这个方法

		message.setSubject("主题：简单邮件"); // 设置邮件主题

		message.setText("测试邮件内容"); // 设置邮件正文

		//message.setCc("37xxxxx37@qq.com"); // 设置邮件抄送人，可以有多个抄送人
		// 如果需要一次性发送多个邮箱地址，通过重载的数组参数的方法即可

		//message.setBcc("14xxxxx098@qq.com"); // 设置隐秘抄送人，可以有多个
		// 如果需要一次性发送多个邮箱地址，通过重载的数组参数的方法即可

		//message.setSentDate(new Date(System.currentTimeMillis() / 2));
		// 设置邮件发送日期,这个时间可以任意指定，会展示在邮件抬头处，表示邮件的发送时间
		// 也可以不指定，默认就是当前时间

		mailSender.send(message);
	}

	/**
	 * 发送带附件的邮件
	 * @throws Exception
	 */
	@Test
	public void sendAttachmentsMail() throws Exception {

		// 发送多媒体类型的邮件就要使用这种方式而来
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setFrom("1209023760@qq.com");
		helper.setTo("keqi@my7g.cn");
		helper.setSubject("主题：有附件");
		helper.setText("有附件的邮件");

		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
		helper.addAttachment("附件-1.jpg", file);
		helper.addAttachment("附件-2.jpg", file);

		mailSender.send(mimeMessage);
	}

	/**
	 * 在邮件正文中嵌入静态资源
	 * @throws Exception
	 */
	@Test
	public void sendInlineMail() throws Exception {

		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);


		helper.setFrom("1209023760@qq.com");
		helper.setTo("keqi@my7g.cn");
		helper.setSubject("主题：嵌入静态资源");
		helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

		helper.addInline();
		FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));

		mailSender.send(mimeMessage);
	}


	/**
	 * 发送thymeleaf模板邮件
	 * @throws MessagingException
	 */
	@Test
	public void sendThymeleafMail() throws MessagingException {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

		helper.setSubject("这是一封测试邮件");
		helper.setFrom("1510161612@qq.com");
		helper.setTo("25xxxxx755@qq.com");
		helper.setCc("37xxxxx37@qq.com");
		helper.setBcc("14xxxxx098@qq.com");
		helper.setSentDate(new Date());
		Context context = new Context();

		context.setVariable("username", "javaboy");
		context.setVariable("num", "000001");
		context.setVariable("salary", "99999");

		String process = templateEngine.process("mail.html", context);

		// 本质上还是把一个html字符串设置到文本中
		helper.setText(process, true);

		mailSender.send(mimeMessage);
	}
}
