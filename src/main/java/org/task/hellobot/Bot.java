package org.task.hellobot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.hellobot.helper.MessageGenerator;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

	private static final Logger log = LoggerFactory.getLogger(Bot.class);
	private final String username;
	private final String token;

	private final MessageGenerator generator;

	public Bot(String username, String token) {
		this.username = username;
		this.token = token;
		this.generator = new MessageGenerator();
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			var messageText = update.getMessage().getText();
			var chatId = update.getMessage().getChatId();

			log.debug("Message received from chat {} : {}", chatId, messageText);
			switch (messageText) {
				case "/start":
					executeMessage(generator.generateMessage(chatId, "Hello World!"));
					executeMessage(generator.mainMenu(chatId));
					break;
				case "Кнопка 1":
					executeMessage(generator.generateMessage(chatId, "Кнопка 1"));
					break;
				case "Кнопка 2":
					executeMessage(generator.generateMessage(chatId, "Кнопка 2"));
					break;
				case "Далі":
					executeMessage(generator.nextMenu(chatId));
					break;
				case "Назад":
					executeMessage(generator.mainMenu(chatId));
					break;
				default:
					executeMessage(generator.generateMessage(chatId, "‼️Помилка! Невідома команда!‼️"));
					break;
			}
		}
	}

	@Override
	public String getBotUsername() {
		return username;
	}

	@Override
	public String getBotToken() {
		return token;
	}

	private void executeMessage(SendMessage sendMessage){
		try {
			execute(sendMessage);
		} catch (TelegramApiException e) {
			log.error("Message execution failed! Exception is: ", e);
		}
	}
}
