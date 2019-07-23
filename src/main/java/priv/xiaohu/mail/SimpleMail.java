package priv.xiaohu.mail;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zxh
 */
public class SimpleMail {
	/**
	 * <p>邮件接收人</p>
	 * <p>优先于SimpleMailSender中设置的邮件接收人</p>
	 * <p>当同时存在时按SimpleMail设置的接收人发送</p>
	 *
	 * @see SimpleMailSender#getRecipients()
	 */
	private Collection<String> recipients;
	/**
	 * 邮件标题
	 */
	private String subject;
	/**
	 * 邮件内容
	 */
	private String content;
	/**
	 * 附件
	 */
	private Collection<File> attachments;
	
	public Collection<String> getRecipients() {
		return recipients;
	}
	
	public void setRecipients(final List<String> recipients) {
		if (recipients.stream().noneMatch(s -> s.matches(MailAuthenticator.REGEX))) {
			throw new IllegalMailFormatException();
		}
		this.recipients = recipients;
	}
	
	public void setRecipients(final String... recipients) {
		this.setRecipients(Arrays.asList(recipients));
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(final String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(final String content) {
		this.content = content;
	}
	
	public Collection<File> getAttachments() {
		return attachments;
	}
	
	public void setAttachments(final List<File> attachments) {
		this.attachments = attachments.stream().distinct().collect(Collectors.toList());
	}
}
