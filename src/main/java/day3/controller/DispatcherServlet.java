package day3.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 클라이언트의 요청을 가장 먼저 받아들이는 Front Controller.
// 클라이언트의 모든 요청을 받아서 처리한 후, 요청한 URL에 따라서 적절한 핸들러(Controller)에 요청을 전달
// 해당 핸들러가 반환한 결과를 뷰(View)에 전달하여 클라이언트에게 반환
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException{
        handlerMapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("./WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        process(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        process(request,response);
    }
    //핵심메소드
    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 1. 클라이언트의 요청 path 정보 추출
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        //2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다
        Controller ctrl = handlerMapping.getController(path);

        //3. 검색된 Controller를 실행한다.
        String viewName = ctrl.handleRequest(request, response);

        //4. viewResolver를 통해 viewName에 해당하는 화면을 검색한다
        String view = null;
        if (!viewName.contains(".do")) {
            view = viewResolver.getView(viewName);
        }else {
            view = viewName;
        }

        //5. 검색된 화면으로 이동한다
        response.sendRedirect(view);
    }

}
