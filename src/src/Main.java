import javax.swing.*;
import java.text.ParseException;

public class Main {
    public static void main(String[] args)  throws ParseException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new MyForm();
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}