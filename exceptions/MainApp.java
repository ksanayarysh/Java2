package exceptions;

public class MainApp {
    public static void main(String[] args) {
        ProcessArray p = new ProcessArray();
        String[][] a = {{"1", "2", "10", "12"},
                        {"1", "2", "1", "2"},
                        {"1", "2", "1", "2"},
                        {"1", "2", "1", "2"}};
        try {
            p.sumArray(a);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            e.errorMsg();
        }
    }
}
