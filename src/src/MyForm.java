import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class MyForm implements ActionListener {

    private final JFrame myFrame;
    private final Container container;
    //private  Date birthDay;
    private final JLabel title;
    private final JLabel dayLabel;
    private final JLabel monthLabel;
    private final JLabel yearLabel;
    private final JLabel resultLabel;

    private final JComboBox day;
    private final JComboBox month;
    private final JComboBox year;
    private final JButton calcButton;
    private final JButton resetButton;
    private final JTextField firstName;

    private Date birthDate;
    private Date today;
    private final SimpleDateFormat dol;
    private final String pattern = "dd-MMM-yyyy";
    private String birDat = null;
    private long daysOfLife = 0;
    private long diffInTime=0;
   // private
   private String days[] =
                 { "1", "2", "3", "4", "5",
                   "6", "7", "8", "9", "10",
                   "11", "12", "13", "14", "15",
                   "16", "17", "18", "19", "20",
                   "21", "22", "23", "24", "25",
                   "26", "27", "28", "29", "30",
                   "31" };
private String months[] =
                 { "Jan", "feb", "Mar", "Apr",
                   "May", "Jun", "July", "Aug",
                   "Sup", "Oct", "Nov", "Dec" };
private String years[] =
                 {  "1920","1921","1922","1923",
                    "1924","1925","1926","1927",
                    "1928","1929","1930","1931",
                    "1932","1933","1934","1935",
                    "1936","1937","1938","1939",
                    "1940","1941","1942","1943",
                    "1944","1945","1946","1947",
                    "1948","1949","1950","1951",
                    "1952","1953","1954","1955",
                    "1956","1957","1958","1959",
                    "1960","1961","1962","1963",
                    "1964","1965","1966","1967",
                    "1968","1969","1970","1971",
                    "1972","1973","1974","1975",
                    "1976","1977","1978","1979",
                    "1980","1981","1982","1983",
                    "1984","1985","1986","1987",
                    "1988","1989","1990","1991",
                    "1992","1993","1994","1995",
                    "1996","1997","1998","1999",
                    "2000","2001","2002","2003",
                    "2004","2005","2006","2007",
                    "2008","2009","2010","2011",
                    "2012","2013","2014","2015",
                    "2016","2017","2018","2019",
                    "2020","2021","2022"};

    public MyForm() throws ParseException {
        myFrame = new JFrame("How many years");
        myFrame.setBounds(300, 90, 700, 350);
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myFrame.setResizable(false);

        container = myFrame.getContentPane();
        container.setBackground(Color.gray);
        container.setLayout(null);

        firstName = new JTextField();
        firstName.setFont(new Font("Arial", Font.BOLD, 20));
        firstName.setSize(130,30);
        firstName.setLocation(250,100);
        container.add(firstName);

        title = new JLabel();
        title.setText("Program calculating how many days you are alive");
        title.setSize(420,20);
        title.setLocation(150,20);
        title.setFont(new Font("Arial", Font.BOLD, 14));
        container.add(title);

        dayLabel = new JLabel();
        dayLabel.setText("Day");
        dayLabel.setSize(60,20);
        dayLabel.setLocation(160,180);
        container.add(dayLabel);

        monthLabel = new JLabel();
        monthLabel.setText("Month");
        monthLabel.setSize(60,20);
        monthLabel.setLocation(220,180);
        container.add(monthLabel);

        yearLabel = new JLabel();
        yearLabel.setText("Year");
        yearLabel.setSize(60,20);
        yearLabel.setLocation(290,180);
        container.add(yearLabel);

        day = new JComboBox(days);
        day.setSize(50,20);
        day.setLocation(150,200);
        container.add(day);

        month = new JComboBox(months);
        month.setSize(60,20);
        month.setLocation(210,200);
        container.add(month);

        year = new JComboBox(years);
        year.setSize(60,20);
        year.setLocation(280,200);
        container.add(year);

        calcButton = new JButton("Calc");
        calcButton.setSize(100,40);
        calcButton.setLocation(360,190);
        calcButton.addActionListener(this);
        container.add(calcButton);

        resetButton = new JButton("Reset");
        resetButton.setSize(100,40);
        resetButton.setLocation(470,190);
        resetButton.addActionListener(this);
        container.add(resetButton);

        resultLabel = new JLabel();
        resultLabel.setSize(600,20);
        resultLabel.setLocation(100,260);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 20));
        resultLabel.setVisible(false);
        container.add(resultLabel);

        dol = new SimpleDateFormat(pattern);

        myFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calcButton)
        {
            birDat = (String) day.getSelectedItem() + "-" + (String) month.getSelectedItem() + "-" + year.getSelectedItem();
            try {
                birthDate = dol.parse(birDat);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
            today = new Date();
            diffInTime = today.getTime() - birthDate.getTime();
            daysOfLife = (diffInTime / (1000 * 60 * 60 * 24));
            System.out.println(birthDate);
            resultLabel.setText(firstName.getText() + " ,your number of days alive is : " + Long.toString(daysOfLife));
            resultLabel.setVisible(true);
        }else {
            myFrame.dispose();
            try {
                new MyForm();
            } catch (ParseException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
