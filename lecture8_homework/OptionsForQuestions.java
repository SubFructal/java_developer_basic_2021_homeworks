package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture8_homework;

public class OptionsForQuestions {

	private static final String[][] OPTIONS_FOR_QUESTIONS = new String[5][4];

	static {
		OPTIONS_FOR_QUESTIONS[0][0] = "Красно-чёрная";
		OPTIONS_FOR_QUESTIONS[0][1] = "Красно-сине-белая";
		OPTIONS_FOR_QUESTIONS[0][2] = "Бело-голубая";
		OPTIONS_FOR_QUESTIONS[0][3] = "Чёрно-оранжевая";

		OPTIONS_FOR_QUESTIONS[1][0] = "Гафний";
		OPTIONS_FOR_QUESTIONS[1][1] = "Кобальт";
		OPTIONS_FOR_QUESTIONS[1][2] = "Бериллий";
		OPTIONS_FOR_QUESTIONS[1][3] = "Теллур";

		OPTIONS_FOR_QUESTIONS[2][0] = "Романист";
		OPTIONS_FOR_QUESTIONS[2][1] = "Драматург";
		OPTIONS_FOR_QUESTIONS[2][2] = "Поэт";
		OPTIONS_FOR_QUESTIONS[2][3] = "Эссеист";

		OPTIONS_FOR_QUESTIONS[3][0] = "Тбилиси";
		OPTIONS_FOR_QUESTIONS[3][1] = "Ереван";
		OPTIONS_FOR_QUESTIONS[3][2] = "Баку";
		OPTIONS_FOR_QUESTIONS[3][3] = "Минск";

		OPTIONS_FOR_QUESTIONS[4][0] = "Кирасиры";
		OPTIONS_FOR_QUESTIONS[4][1] = "Уланы";
		OPTIONS_FOR_QUESTIONS[4][2] = "Драгуны";
		OPTIONS_FOR_QUESTIONS[4][3] = "Гусары";
	}

	public static String[][] getOptionsForQuestions() {
		return OPTIONS_FOR_QUESTIONS;
	}

}