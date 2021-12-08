package ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework;

/*
Обработка ошибок
Придумать несколько взаимосвязанных классов, -resource
в которых использовать три способа обработки исключений (вывод
ошибки, rethrow и еще один, на выбор)
А так же использована конструкция try-with
Вместо обращения к реальным ресурсам можно использовать классы-заглушки
Результатом выполнения задания является код на гитхабе оформленный в виде pull request

Моя модель:
Читаю из базы данных имя файла;
По имени файла считываю содержимое соответствующего файла;
Содержимое записываю в другой файл-копию;
Файл копию передаю по сети;
В процессе обрабатываю исключения.
 */

import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception.EmptyFileContentException;
import ru.sendgoods.otus.java_developer_basic_2021_homeworks.lecture13_homework.exception.WrongInputFileNameException;

import java.io.IOException;
import java.net.ConnectException;
import java.util.Optional;

public class ExceptionsHandler {

    public static void main(String[] args) throws WrongInputFileNameException {
        try (Database dataBase = new Database(); FileReader fileReader = new FileReader();
             FileWriter fileWriter = new FileWriter(); WebConnection webConnection = new WebConnection()) {

            Optional<String> optionalInputFileContent = fileReader.readFile(dataBase, "sql expression");
            String inputFileContent = optionalInputFileContent.orElseThrow(() ->
                    new EmptyFileContentException("empty input file content"));

//            System.out.println(inputFileContent);

            webConnection.connectWithWeb();
            System.out.println(webConnection.sendFile(fileWriter, 000000, "output file name",
                    inputFileContent));

        } catch (ConnectException e) {
            System.out.println(e.getMessage());
            System.exit(53);
        } catch (EmptyFileContentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new WrongInputFileNameException("wrong input file name from database", e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}