package server.interfaces;

import server.handlers.ClientHandler;

public interface Server {

    int PORT = 8189;

    boolean isNickBusy(String nick);

    void broadcastMsg(String msg);

    void unicastMsg(String msg, String nick);

    void subscribe(ClientHandler clientHandler);

    void unsubscribe(ClientHandler clientHandler);

    AuthService getAuthService();
}
