package ex0503.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class SuggestServlet
 */
@WebServlet("/suggestServlet")
public class SuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String words[] = {"�ڹ� ���α׷���","HTML������","��Ʈ��Ʈ������ �������϶�"
			,"���б������ε�","�ڹٽ�ũ��Ʈ ����","JQuery���ѵ�"};
       
	/*
	 * ù�ܾ ������ �ܾ ã�Ƽ� List�� ��� �������ִ� �޼ҵ� �ۼ�
	 */
	private List<String> search(String keyWord){
		List<String> list = new ArrayList<>();
		for(String word:words) {
			if(word.toUpperCase().startsWith(keyWord.toUpperCase())) {
				list.add(word);
			}
		}
		
		return list;
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); //post��� �ѱ����ڵ� ����
		response.setContentType("text/html;charset=UTF-8");
		String keyWord=request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord);
		//front�� �����͸� �����ϱ� ���ؼ� text�������� ��ȯ�غ���
		//����|�ܾ�,�ܾ�,�ܾ�
		PrintWriter out = response.getWriter();
		//front���������� ����
/*		out.println(list.size()+"|");
		for(int i=0;i<list.size();i++) {
			if(i==(list.size()-1)) {
				out.print(list.get(i));
			}else {
				out.print(list.get(i)+",");
			}
		}*/
		
		/////////////////////////////////////////////////////
		//list�� json���·� ��ȯ�ؼ� front�� ������[{}{}{}]//
		/////////////////////////////////////////////////////
		JSONArray jsonArr=JSONArray.fromObject(list);
		out.println(jsonArr);

	}

}