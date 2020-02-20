/**
 * @author Turkov Fedor
 * @version dated Dec 05, 2019
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AWTException {
        Scanner in = new Scanner(System.in);
        System.out.print(" Введите сумму : ");
        int moneyAmount = in.nextInt();
        boolean canBuyAnything = false;
        int[] drinkPrices = {20, 80, 150, 40};
        String[] drinkNames = {"воду", "эспрессо", "капучино", "молоко"};

        for (int i = 0; i < drinkNames.length; i++) {

            if (drinkPrices[i] <= moneyAmount) {
                System.out.println("Вы можете купить " + drinkNames[i]);
                canBuyAnything = true;
            }
        }
        if (canBuyAnything == false) {
            System.out.println("Недостаточно средств");
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd_HHmmss");
        System.out.println(format.format(new Date()));

        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        System.out.println(image.getWidth() + "x" + image.getHeight());
    }
}
