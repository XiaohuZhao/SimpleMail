package priv.xiaohu.mail;

/**
 * @author zxh
 */
public class IllegalMailFormatException extends RuntimeException {
	public IllegalMailFormatException() {
		super("邮箱格式不正确！邮箱名由英文、数字、汉字和英文符号（下划线、中划线、小数点和 @）组成，且不可以符号开头");
	}
	
	public IllegalMailFormatException(String message) {
		super(message);
	}
}
