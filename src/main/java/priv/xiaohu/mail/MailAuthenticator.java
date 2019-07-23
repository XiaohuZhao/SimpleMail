package priv.xiaohu.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 服务器邮箱登录验证
 *
 * @author zxh
 */
class MailAuthenticator extends Authenticator {
	static final String REGEX = "^[A-Za-z0-9\\u4e00-\\u9fa5][A-Za-z0-9\\-_\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
	/**
	 * 用户名（登录邮箱）
	 */
	private String senderMail;
	/**
	 * 密码
	 */
	private String password;
	
	public void setSenderMail(final String senderMail) {
		this.senderMail = senderMail;
	}
	
	public void setPassword(final String password) {
		this.password = password;
	}
	
	public String getSenderMail() {
		return senderMail;
	}
	
	public String getPassword() {
		return password;
	}
	
	/**
	 * 初始化邮箱和密码
	 *
	 * @param senderMail
	 * 		邮箱
	 * @param password
	 * 		密码
	 */
	public MailAuthenticator(String senderMail, String password) {
		this.senderMail = senderMail;
		this.password = password;
	}
	
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(senderMail, password);
	}
}
