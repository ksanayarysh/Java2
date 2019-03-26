package exceptions;

public class ProcessArray {

    public void sumArray(String array[][]) throws MyArraySizeException, MyArrayDataException {
        String[] row;

        if (array.length != 4)  throw new MyArraySizeException("Неверный размер массива!");

        for (int i = 0; i < 4; i++) {
            row = array[i];
            if (row.length != 4) throw new MyArraySizeException("Неверный размер массива!");

        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (Exception e)
                {
                    throw new MyArrayDataException("Ошибка преобразования строки", i, j, array[i][j]);
                }
            }
        }
        System.out.println("Сумма элементов массива = " + sum);
    }
}
