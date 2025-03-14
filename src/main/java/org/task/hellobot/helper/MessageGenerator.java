package org.task.hellobot.helper;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public class MessageGenerator {

	private final MenuHelper menuHelper;

	public MessageGenerator() {
		this.menuHelper = new MenuHelper();
	}

	private SendMessage generateMessage(Long chatId, String text, ReplyKeyboardMarkup replyMarkup) {
		var message = new SendMessage();
		message.setChatId(chatId.toString());
		message.setText(text);
		message.setReplyMarkup(replyMarkup);

		return message;
	}

	public SendMessage generateMessage(Long chatId, String text) {
		var message = new SendMessage();
		message.setChatId(chatId.toString());
		message.setText(text);

		return message;
	}

	public SendMessage mainMenu(Long chatId) {
		return generateMessage(chatId, "Оберіть кнопку з меню:", menuHelper.buildMainMenu());
	}

	public SendMessage nextMenu(Long chatId) {
		return generateMessage(chatId, "Оберіть кнопку з меню 2:", menuHelper.buildNextMenu());
	}

}
