package com.demo.ejb.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.ejb.models.Person;
import com.demo.ejb.sessionbean.CrudLocal;
/**
 * Servlet implementation class homeController
 */
@WebServlet("*.do")
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private CrudLocal crud;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeController() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String url=request.getServletPath(); 
        String action=url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
        System.out.println("url: "+url);
        System.out.println("action: "+action);
        switch (action) {
            case "index":
                index(request, response);
                break;
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            default:
                request.setAttribute("controller", "error");
                request.setAttribute("action", "index");
        }
        request.getRequestDispatcher("/index.jsp").forward(request, response);
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	private void index(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Read");
        System.out.println("read all" + crud.findAll().toString());
        request.setAttribute("list", crud.findAll());
        
    }

    private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone   = request.getParameter("phone");
        crud.addition(new Person(id, name, email, address, phone));
        request.getRequestDispatcher("/demoEJB/index.do").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone   = request.getParameter("phone");
        crud.edit(new Person(id, name, email, address, phone));
        request.getRequestDispatcher("/demoEJB/index.do").forward(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        crud.removeById(id);
        request.getRequestDispatcher("/demoEJB/index.do").forward(request, response);
    }

}
