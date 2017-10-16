package com.test.task.services.implementations;

import com.test.task.services.interfaces.GreetingsService;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class GreetingsServiceImpl implements GreetingsService {
	@Override
	public String getGreetingMessage(String name) {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour > 21 && hour < 6)
			return "Добрая ночь, " + name + '!';
		else if (hour < 10)
			return "Доброе утро, " + name + '!';
		else if (hour < 18)
			return "Добрый день, " + name + '!';
		else
			return "Добрый вечер, " + name + '!';
	}
}
