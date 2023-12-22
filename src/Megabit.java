import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Megabit extends JFrame {

    private JLabel imageLabel;
    private JLabel logoLabel;
    private List<JLabel> snowflakes;

    public Megabit() {
        // Настройка окна
        setTitle("Анимация Megabit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); // Темный фон

        // Загрузка изображения снега
        ImageIcon icon = new ImageIcon("C:\\Users\\Aorus\\OneDrive - Частное учреждение высшего образования МОСКОВСКАЯ АКАДЕМИЯ ПРЕДПРИНИМАТЕЛЬСТВА\\Рабочий стол\\хахаха\\neko_snow.jpg");

        // Создание метки с изображением
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 10, icon.getIconWidth(), icon.getIconHeight());
        add(imageLabel);

        // Загрузка логотипа
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Aorus\\OneDrive - Частное учреждение высшего образования МОСКОВСКАЯ АКАДЕМИЯ ПРЕДПРИНИМАТЕЛЬСТВА\\Рабочий стол\\хахаха\\megabit_logo.png");

        // Создание метки с логотипом Мегабит
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(getWidth() / 2 - logoIcon.getIconWidth() / 2, getHeight() / 2 - logoIcon.getIconHeight() / 2, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        add(logoLabel);

        // Создание списка снежинок
        snowflakes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            JLabel snowflake = new JLabel("*");
            snowflake.setForeground(Color.WHITE);
            snowflake.setBounds(random.nextInt(getWidth()), random.nextInt(getHeight()), 10, 10);
            add(snowflake);
            snowflakes.add(snowflake);
        }

        // Создание таймера для анимации
        javax.swing.Timer timer = new javax.swing.Timer(50, new ActionListener() {
            int deltaXImage = 2; // Скорость перемещения изображения по горизонтали
            int deltaYImage = 2; // Скорость перемещения изображения по вертикали

            int deltaXLogo = 3; // Скорость перемещения логотипа Мегабит по горизонтали
            int deltaYLogo = 0; // Логотип движется только по горизонтали

            int deltaYSnow = 5; // Скорость падения снежинок по вертикали

            @Override
            public void actionPerformed(ActionEvent e) {
                // Получение текущих координат меток
                int xImage = imageLabel.getX();
                int yImage = imageLabel.getY();

                int xLogo = logoLabel.getX();
                int yLogo = logoLabel.getY();

                // Перемещение изображения
                imageLabel.setBounds(xImage + deltaXImage, yImage + deltaYImage, icon.getIconWidth(), icon.getIconHeight());

                // Перемещение логотипа Мегабит
                logoLabel.setBounds(xLogo + deltaXLogo, yLogo + deltaYLogo, logoIcon.getIconWidth(), logoIcon.getIconHeight());

                // Перемещение снежинок
                for (JLabel snowflake : snowflakes) {
                    int xSnow = snowflake.getX();
                    int ySnow = snowflake.getY();
                    snowflake.setBounds(xSnow + random.nextInt(5) - 2, ySnow + deltaYSnow, 10, 10);

                    // Если снежинка достигла нижней границы окна, переместить её вверх и в случайное место горизонтально
                    if (ySnow > getHeight()) {
                        snowflake.setBounds(random.nextInt(getWidth()), 0, 10, 10);
                    }
                }

                // Ограничение перемещения изображения в пределах окна
                if (xImage + deltaXImage < 0 || xImage + deltaXImage > getWidth() - icon.getIconWidth()) {
                    deltaXImage = -deltaXImage;
                }
                if (yImage + deltaYImage < 0 || yImage + deltaYImage > getHeight() - icon.getIconHeight()) {
                    deltaYImage = -deltaYImage;
                }

                // Ограничение перемещения логотипа Мегабит в пределах окна
                if (xLogo + deltaXLogo < 0 || xLogo + deltaXLogo > getWidth() - logoIcon.getIconWidth()) {
                    deltaXLogo = -deltaXLogo;
                }
            }
        });

        // Запуск таймера
        timer.start();

        // Отображение окна
        setVisible(true);
    }

    public static void main(String[] args) {
        // Создание экземпляра класса Megabit
        new Megabit();
    }
}







