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
        // ��������� ����
        setTitle("�������� Megabit");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(null);
        getContentPane().setBackground(Color.BLACK); // ������ ���

        // �������� ����������� �����
        ImageIcon icon = new ImageIcon("C:\\Users\\Aorus\\OneDrive - ������� ���������� ������� ����������� ���������� �������� �������������������\\������� ����\\������\\neko_snow.jpg");

        // �������� ����� � ������������
        imageLabel = new JLabel(icon);
        imageLabel.setBounds(10, 10, icon.getIconWidth(), icon.getIconHeight());
        add(imageLabel);

        // �������� ��������
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\Aorus\\OneDrive - ������� ���������� ������� ����������� ���������� �������� �������������������\\������� ����\\������\\megabit_logo.png");

        // �������� ����� � ��������� �������
        logoLabel = new JLabel(logoIcon);
        logoLabel.setBounds(getWidth() / 2 - logoIcon.getIconWidth() / 2, getHeight() / 2 - logoIcon.getIconHeight() / 2, logoIcon.getIconWidth(), logoIcon.getIconHeight());
        add(logoLabel);

        // �������� ������ ��������
        snowflakes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            JLabel snowflake = new JLabel("*");
            snowflake.setForeground(Color.WHITE);
            snowflake.setBounds(random.nextInt(getWidth()), random.nextInt(getHeight()), 10, 10);
            add(snowflake);
            snowflakes.add(snowflake);
        }

        // �������� ������� ��� ��������
        javax.swing.Timer timer = new javax.swing.Timer(50, new ActionListener() {
            int deltaXImage = 2; // �������� ����������� ����������� �� �����������
            int deltaYImage = 2; // �������� ����������� ����������� �� ���������

            int deltaXLogo = 3; // �������� ����������� �������� ������� �� �����������
            int deltaYLogo = 0; // ������� �������� ������ �� �����������

            int deltaYSnow = 5; // �������� ������� �������� �� ���������

            @Override
            public void actionPerformed(ActionEvent e) {
                // ��������� ������� ��������� �����
                int xImage = imageLabel.getX();
                int yImage = imageLabel.getY();

                int xLogo = logoLabel.getX();
                int yLogo = logoLabel.getY();

                // ����������� �����������
                imageLabel.setBounds(xImage + deltaXImage, yImage + deltaYImage, icon.getIconWidth(), icon.getIconHeight());

                // ����������� �������� �������
                logoLabel.setBounds(xLogo + deltaXLogo, yLogo + deltaYLogo, logoIcon.getIconWidth(), logoIcon.getIconHeight());

                // ����������� ��������
                for (JLabel snowflake : snowflakes) {
                    int xSnow = snowflake.getX();
                    int ySnow = snowflake.getY();
                    snowflake.setBounds(xSnow + random.nextInt(5) - 2, ySnow + deltaYSnow, 10, 10);

                    // ���� �������� �������� ������ ������� ����, ����������� � ����� � � ��������� ����� �������������
                    if (ySnow > getHeight()) {
                        snowflake.setBounds(random.nextInt(getWidth()), 0, 10, 10);
                    }
                }

                // ����������� ����������� ����������� � �������� ����
                if (xImage + deltaXImage < 0 || xImage + deltaXImage > getWidth() - icon.getIconWidth()) {
                    deltaXImage = -deltaXImage;
                }
                if (yImage + deltaYImage < 0 || yImage + deltaYImage > getHeight() - icon.getIconHeight()) {
                    deltaYImage = -deltaYImage;
                }

                // ����������� ����������� �������� ������� � �������� ����
                if (xLogo + deltaXLogo < 0 || xLogo + deltaXLogo > getWidth() - logoIcon.getIconWidth()) {
                    deltaXLogo = -deltaXLogo;
                }
            }
        });

        // ������ �������
        timer.start();

        // ����������� ����
        setVisible(true);
    }

    public static void main(String[] args) {
        // �������� ���������� ������ Megabit
        new Megabit();
    }
}







