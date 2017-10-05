/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smallfe.clerk;

import com.google.gson.Gson;
import com.smallfe.clerk.model.UIMessage;
import com.smallfe.clerk.util.CryptoUtils;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet for encryption feature.
 * @author mkucukdemir
 */
public class EncryptionServlet extends HttpServlet {

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet EncryptionServlet</title>");            
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet EncryptionServlet at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("application/json;charset=UTF-8");
    Gson gson = new Gson();
    PrintWriter out = response.getWriter();
    String plainText = request.getParameter("plain");
    String alphabet = request.getParameter("alphabet");
    Integer magic = new Integer(-1);
    String cipherText = new String();
    UIMessage uiMessage;
    try {
      magic = new Integer(request.getParameter("magic"));
    } catch (NumberFormatException e) {
      uiMessage = new UIMessage(UIMessageStatus.ERROR, "Magic cannot be parsed");
      out.print(gson.toJson(uiMessage));
      out.flush();
      return;
    }
    try {
      cipherText = CryptoUtils.encrypt(plainText, magic, alphabet);
      uiMessage = new UIMessage(UIMessageStatus.OK, cipherText);
      out.print(gson.toJson(uiMessage));
      out.flush();
      return;
    } catch (Exception e) {
      uiMessage = new UIMessage(UIMessageStatus.ERROR, "Encryption error");
      out.print(gson.toJson(uiMessage));
      out.flush();
      return;
    }
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }

}
