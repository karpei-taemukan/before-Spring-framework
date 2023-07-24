package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TestDto;
import service.TestService;

/**
 * Servlet implementation class TestController
 */
@WebServlet({ "/joinForm", "/mainPage", "/loginForm", "/join","/boardList"})
public class TestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = request.getServletPath();
		System.out.println("ServletPath: "+url);
		String path = request.getContextPath();
		System.out.println("ContextPath: "+path);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//response.sendRedirect(path+"/resultPage.jsp");
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out;
		TestService tsvc = new TestService();
		
		switch (url) { // 이 코드 없으면 각 페이지 로드가 안됨
		case "/joinForm":
			// 회원 가입 페이지 이동 
			response.sendRedirect(path+"/joinForm.jsp");
			break;
		case "/mainPage":
			// 메인 페이지 이동
			response.sendRedirect(path+"/mainPage.jsp");
			break;
		case "/loginForm":
			// 로그인 페이지 이동
			response.sendRedirect(path+"/loginForm.jsp");
			break;
		case "/boardList":
			// 1. BoardList페이지에 출력할 데이터 조회
			ArrayList<TestDto> list = tsvc.getBoardList(); 
			//request.setAttribute("데이터 이름", 저장할 데이터);
			request.setAttribute("tList", list);
			// Object 타입으로 저장된다 
			
			RequestDispatcher dispatcher =  request.getRequestDispatcher("boardList.jsp");
			// 응답을 받으면 소멸 x
			dispatcher.forward(request, response);
			
			
			// response.sendRedirect(path+"/boardList.jsp");
			// 응답을 받으면 소멸 o
			break;
		case "/join":
			// 1. 클라이언트의 파라메터 확인 
			String id = request.getParameter("joinId");
			System.out.println("id Parameter: "+id);
			String pw = request.getParameter("joinPw");
			System.out.println("pw Parameter: "+pw);
			String birth = request.getParameter("joinBirth");
			System.out.println("birth Parameter: "+birth);
			
			int joinResult = 0;
			
			if(joinResult > 0) {
				response.sendRedirect(path+"/joinSuccess.jsp?ch=y");
				out=response.getWriter();
				out.println("<script>");
				out.println("alert('성공');");
				out.println("location.href='"+path+"/mainPage.jsp'");			
				out.println("</script>");

			}
			else {
				response.sendRedirect(path+"/joinFail.jsp");
				out=response.getWriter();
				out.println("<script>");
				out.println("alert('실패');");
				out.println("history.back();");			
				out.println("</script>");
			}
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("post");
		doGet(request, response);
		
	}

}

