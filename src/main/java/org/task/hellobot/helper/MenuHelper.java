package org.task.hellobot.helper;


import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class MenuHelper {

	public ReplyKeyboardMarkup buildMainMenu() {
		return createKeyboard(new KeyboardButton("Далі"));
	}

	public ReplyKeyboardMarkup buildNextMenu() {
		return createKeyboard(new KeyboardButton("Назад"));
	}

	private ReplyKeyboardMarkup createKeyboard(KeyboardButton thirdButton) {
		var keyboardMarkup = new ReplyKeyboardMarkup();
		keyboardMarkup.setResizeKeyboard(true);

		var row1 = new KeyboardRow();
		row1.add(new KeyboardButton("Кнопка 1"));
		row1.add(new KeyboardButton("Кнопка 2"));

		var row2 = new KeyboardRow();
		row2.add(thirdButton);

		List<KeyboardRow> keyboard = new ArrayList<>();
		keyboard.add(row1);
		keyboard.add(row2);

		keyboardMarkup.setKeyboard(keyboard);
		return keyboardMarkup;
	}

}
