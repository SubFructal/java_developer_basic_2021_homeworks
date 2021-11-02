package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture8_homework;

public class Questions {

	private static final String[] QUESTIONS = new String[5];

	static {
		QUESTIONS[0] = "Какого цвета лента Георгиевского креста, учреждённого в 1807 году?";
		QUESTIONS[1] = "Какой химический элемент назван в честь злого подземного гнома?";
		QUESTIONS[2] = "Кто первым получил Нобелевскую премию по литературе?";
		QUESTIONS[3] = "В какой из этих столиц бывших союзных республик раньше появилось метро?";
		QUESTIONS[4] = "Какой вид кавалерии предназначался для боевых действий как в конном, так и в пешем строю?";
	}

	public static String[] getQuestions() {
		return QUESTIONS;
	}

}