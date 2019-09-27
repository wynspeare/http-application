package application;

import server.HTTPServer;
import server.Router;
import server.handlers.DefaultHandler;
import server.handlers.EchoHandler;
import server.handlers.RedirectHandler;

public class App {
  private static int defaultPort = 5000;

  public static ServerLogger createLogger(String directory) {
    return new ServerLogger(directory);
  }

  public static void main(String[] args) {
    HTTPServer httpServer = new HTTPServer();
    httpServer.buildServerSocket(defaultPort);
    Router router = createRouter();
    httpServer.serve(router);
  }

  public static Router createRouter() {
    ServerLogger serverLogger = createLogger("Logs");
    System.out.println(serverLogger);
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
