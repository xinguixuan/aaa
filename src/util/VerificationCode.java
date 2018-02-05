package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class VerificationCode {
	private static Random r = new Random();
	private static char[] chs = "0123456789".toCharArray();
	private static String[] ss = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private static final int NUMBER_OF_CHS = 4;
	private static final int IMG_WIDTH = 75;
	private static final int IMG_HEIGHT = 25;
	private static String code = "";

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 * ��֤�빤����
	 */
	public static BufferedImage getImg() throws IOException {
		BufferedImage image = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB); // ʵ����BufferedImage
		Graphics2D g = (Graphics2D) image.getGraphics();
		Color c = new Color(200, 200, 255); // ��֤��ͼƬ�ı�����ɫ
		g.setColor(c);
		g.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT); // ͼƬ�ı߿�
		// �趨����
		g.setFont(new Font("Arial Black", Font.PLAIN, 15));
		StringBuffer sb = new StringBuffer(); // ���ڱ�����֤���ַ���
		int index;// ������±�
		for (int i = 0; i < NUMBER_OF_CHS; i++) {
			index = r.nextInt(chs.length); // ���һ���±�
			g.setColor(new Color(r.nextInt(88), r.nextInt(210), r.nextInt(150))); // ���һ����ɫ
			g.drawString(chs[index] + "", 15 * i + 3, 18); // �����ַ�
			sb.append(chs[index]); // ��֤���ַ���
		}
		code = sb.toString();
		return image;
	}
	
	public static String getCode() {
		return code;
	}
}
