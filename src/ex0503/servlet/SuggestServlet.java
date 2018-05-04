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
	
	private String words[] = {"자바 프로그래밍","HTML마스터","부트스트랩으로 디자인하라"
			,"웹학교별로인듯","자바스크립트 공부","JQuery편한듯"};
       
	/*
	 * 첫단어가 동일한 단어를 찾아서 List에 담아 리턴해주는 메소드 작성
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
		request.setCharacterEncoding("UTF-8"); //post방식 한글인코딩 설정
		response.setContentType("text/html;charset=UTF-8");
		String keyWord=request.getParameter("keyWord");
		
		List<String> list = this.search(keyWord);
		//front로 데이터를 전송하기 위해서 text형식으로 변환해본다
		//개수|단어,단어,단어
		PrintWriter out = response.getWriter();
		//front보낼데이터 설정
/*		out.println(list.size()+"|");
		for(int i=0;i<list.size();i++) {
			if(i==(list.size()-1)) {
				out.print(list.get(i));
			}else {
				out.print(list.get(i)+",");
			}
		}*/
		
		/////////////////////////////////////////////////////
		//list를 json형태로 변환해서 front로 보내기[{}{}{}]//
		/////////////////////////////////////////////////////
		JSONArray jsonArr=JSONArray.fromObject(list);
		out.println(jsonArr);

	}

}