package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture8_homework;

public final class ValidAnswers {

	private static final String[] VALID_ANSWERS = new String[] { "D", "B", "C", "A", "C" };
	private static int validAnswersCount;

	public static String[] getValidAnswers() {
		return VALID_ANSWERS;
	}

	public static int getValidAnswersCount() {
		return validAnswersCount;
	}

	public static void incrementValidAnswersCount() {
		validAnswersCount++;
	}

}