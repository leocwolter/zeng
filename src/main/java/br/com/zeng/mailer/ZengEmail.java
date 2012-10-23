package br.com.zeng.mailer;

import java.util.List;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.zeng.model.User;

public class ZengEmail {
	private HtmlEmail email;
	private String content;

	public ZengEmail() {
		email = new HtmlEmail();
	}

	public void setContent(String content) {
		this.content = content;
		try {
			email.setHtmlMsg(content);
		} catch (EmailException e) {
			new RuntimeException(
					"An error ocurred when trying to set html message on email",
					e);
		}

	}

	public void setSubject(String subject) {
		email.setSubject(subject);
	}

	public String getSubject() {
		return email.getSubject();
	}

	public String getContent() {
		return content;
	}

	public Email getHtmlEmail() {
		return email;
	}

	public void setCharset(String charset) {
		email.setCharset(charset);
	}

	public void setFrom(String email) {
		try {
			this.email.setFrom(email);
		} catch (EmailException e) {
			throw new RuntimeException(
					"An error ocurred while trying to set from", e);
		}
	}

	public void setTo(List<User> listOfEmails) {
		for (User user : listOfEmails) {
			addTo(user.getEmail());
		}
	}

	private void addTo(String email) {
		try {
			this.email.addTo(email);
		} catch (EmailException e) {
			throw new RuntimeException("An error ocurred while trying to add to", e);
		}
	}

}
