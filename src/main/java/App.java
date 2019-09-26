import server.HTTPServer;
import server.Router;
import server.handlers.DefaultHandler;
import server.handlers.EchoHandler;
import server.handlers.RedirectHandler;

import static server.HTTPServer.serverLogger;

public class App {
  private static HTTPServer server;

  public App(HTTPServer httpServer) {
    this.server = httpServer;
  }

  public static void main(String[] args) {
    HTTPServer httpServer = new HTTPServer();
    App app = new App(httpServer);
    System.out.println(app.server.serverSocket);
//    try {
      start(app);
//    } finally {
//      httpServer.close();
//    }
  }

  public static void start(App app) {
    Router router = createRouter();
      app.server.serve(router);
  }

  public static Router createRouter() {
    Router router = new Router(serverLogger);

    router.addRoute("GET", "/simple_get", new DefaultHandler());
    router.addRoute("HEAD", "/simple_get", new DefaultHandler());
    router.addRoute("HEAD", "/get_with_body", new DefaultHandler());
    router.addRoute("POST", "/echo_body", new EchoHandler());
    router.addRoute("GET", "/redirect", new RedirectHandler("http://127.0.0.1:5000/simple_get"));
    router.addRoute("GET", "/test", new DefaultHandler());
    return router;
  }
}
