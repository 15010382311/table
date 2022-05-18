package contuoller;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
/**
 * ��֤��
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		
		//������֪ͨ�������Ҫ����
		response.setHeader("pragma","no-cache");
		response.setHeader("cache-control","no-cache");
		response.setHeader("expires","0");
		
		//���ڴ��д���һ����80����30��ͼƬ��Ĭ�Ϻ�ɫ����
		//����һ����
		//����������
		//����������ɫ
		int width = 80;
		int height = 30;
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_USHORT_565_RGB);
		
		//��ȡ����
		Graphics g = image.getGraphics();
		//���û�����ɫΪ��ɫ
		g.setColor(Color.BLUE);
		//���ͼƬ
		g.fillRect(0,0, width,height);
		
		//����4�������֤�룬12Ey
		String checkCode = getCheckCode();
		//����֤�����HttpSession��
		request.getSession().setAttribute("CHECKCODE_SERVER",checkCode);
		
		//���û�����ɫΪ��ɫ
		g.setColor(Color.YELLOW);
		//���������С��
		g.setFont(new Font("����",Font.ITALIC,24));
		//��ͼƬ��д����֤��
		g.drawString(checkCode,15,25);
		
		//���ڴ��е�ͼƬ����������
		//����һ��ͼƬ����
		//��������ͼƬ�ĸ�ʽ����PNG,JPG,GIF
		//��������ͼƬ���������ȥ
		ImageIO.write(image,"PNG",response.getOutputStream());
	}
	/**
	 * ����4λ����ַ��� 
	 */
	private String getCheckCode() {
		String base = "0123456789ABCDEFGabcdefg";
		int size = base.length();
		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i=1;i<=4;i++){
			//����0��size-1�����ֵ
			int index = r.nextInt(size);
			//��base�ַ����л�ȡ�±�Ϊindex���ַ�
			char c = base.charAt(index);
			//��c���뵽StringBuffer��ȥ
			sb.append(c);
		}
		return sb.toString();
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request,response);
	}
}







