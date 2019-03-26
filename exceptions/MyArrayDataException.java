package exceptions;

import java.text.MessageFormat;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;
    private String value;

    public MyArrayDataException(String message, int i, int j, String value) {
        super(message);
        this.i = i;
        this.j = j;
        this.value = value;
    }


    public void errorMsg(){
        System.out.println(MessageFormat.format("Ошибка преобразования данных, координаты i = {0}, j = {1}, значение {2}", i, j, value));
    }
}
