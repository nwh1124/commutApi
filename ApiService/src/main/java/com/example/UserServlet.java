package com.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/api/data")
public class UserServlet extends HttpServlet {
    private final Gson gson = new Gson();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String time = request.getParameter("param");
    	
        // 응답 콘텐츠 타입을 JSON으로 설정
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // 응답 데이터 생성
        ResponseData responseData = new ResponseData();
        responseData.setMessage("전송 받은 시간 : " + time);

        // Java 객체를 JSON 문자열로 변환
        String jsonResponse = gson.toJson(responseData);

        // 클라이언트에 응답 데이터 전송
        PrintWriter out = response.getWriter();
        out.print(jsonResponse);
        out.flush();
    }
}