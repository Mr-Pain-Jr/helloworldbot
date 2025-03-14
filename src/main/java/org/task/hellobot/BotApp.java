package org.task.hellobot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.task.hellobot.util.ConfigUtil;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class BotApp {

	private static final Logger log = LoggerFactory.getLogger(BotApp.class);

	public static void main(String[] args) throws TelegramApiException {
		var telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		var properties = new ConfigUtil();

		try {
			log.info("About to register bot..");
			telegramBotsApi.registerBot(new Bot(properties.getUsername(), properties.getToken()));
			log.info("Bot started successfully! Waiting for messages..");
		} catch (TelegramApiRequestException e) {
			log.error("Bot registration failed ", e);
		}

	}
}

