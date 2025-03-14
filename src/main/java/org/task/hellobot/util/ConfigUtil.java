package org.task.hellobot.util;

import org.task.hellobot.BotApp;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

	private final String username;
	private final String token;

	public ConfigUtil() {
		var config = new Properties();

		try (var app = BotApp.class.getClassLoader().getResourceAsStream("app.properties")) {
			config.load(app);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load properties, ", e);
		}

		this.username = config.getProperty("tg.bot.username");
		this.token = config.getProperty("tg.bot.token");
	}

	public String getUsername() {
		return username;
	}

	public String getToken() {
		return token;
	}
}
