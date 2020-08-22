package server.handlers;

import server.interfaces.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {

    private Server server;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String nick;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Server server, Socket socket) {
        try {
            this.server = server;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.nick = "";
            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException e) {
                } finally {
                    closeConnection();
                }
            }).start();
        } catch (IOException e) {
            throw new RuntimeException("Проблемы при создании обработчика клиента");
        }
    }

    private void authentication() {
        while (true) {
            try {
                String string = dis.readUTF();
                dos.flush();
                if (string.startsWith("/auth")) {
                    String[] dataArray = string.split("\\s");
                    String nick = server.getAuthService().getNick(dataArray[1], dataArray[2]);
                    if (nick != null) {
                        if (!server.isNickBusy(nick)) {
                            sendMsg("/authOk " + nick);
                            this.nick = nick;
                            server.broadcastMsg(this.nick + " Joined the chat");
                            server.subscribe(this);
                            return;
                        } else {
                            sendMsg("You are logged in");
                        }
                    } else {
                        sendMsg("Incorrect password or login");
                    }
                }
            } catch (Exception e) {

            }
        }
    }

    public void sendMsg(String msg) {
        try {
            dos.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMessage() throws IOException {
        while (true) {
            String clientStr = dis.readUTF();
            System.out.println("from " + this.nick + ":" + clientStr);
            if (clientStr.contains("/exit")) {
                return;
            }
            if (clientStr.startsWith("/w3")) {
                String[] dataArray = clientStr.split("\\s", 3);
                if (dataArray.length > 2) {
                    server.unicastMsg(this.nick + ": " + dataArray[2], dataArray[1]);
                }
            } else {
                server.broadcastMsg(this.nick + ": " + clientStr);
            }
        }
    }


    private void closeConnection() {
        server.unsubscribe(this);
        server.broadcastMsg(this.nick + " left the chat");
        try {
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
