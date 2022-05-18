package contuoller;

import java.io.IOException;

import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class BaseServlet extends HttpServlet {
	
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	   try {
		   // ��ȡ�����ʶ
           String methodName = request.getParameter("method");
           // ��ȡָ������ֽ������
           Class<? extends BaseServlet> clazz = this.getClass();//�����thisָ���Ǽ̳�BaseServlet����
           // ͨ������ֽ�������ȡ�������ֽ������
           Method method = clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
           // �÷���ִ��
           method.invoke(this, request, response);

       } catch (Exception e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
    }
   
//   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//	   
//    }
//
//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request, response);
//    }

    
//    //ֱ�ӽ�����Ķ������л�Ϊjson������д�ؿͻ���
//    public void writeValue(Object obj,HttpServletResponse response) throws ServletException, IOException {
//    	ObjectMapper mapper=new ObjectMapper();
//		response.setContentType("application/json;charset=utf-8");
//		mapper.writeValue(response.getOutputStream(),obj);
//	
//    }
//    
//    //������Ķ������л�Ϊjson������
//    public String writeValueAsString(Object obj,HttpServletResponse response) throws ServletException, IOException {
//    
//    	ObjectMapper mapper=new ObjectMapper();
//		response.setContentType("application/json;charset=utf-8");
//		return mapper.writeValueAsString(obj);
//	
//    	
//    }
}

