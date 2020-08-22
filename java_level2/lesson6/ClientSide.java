import java.io.*;
import java.net.Socket;


public class ClientSide {

    private final static String SERVER_ADDRESS = "localhost";
    private final static Integer SERVER_PORT = 5115;
    private static volatile Socket socket;
    private static DataOutputStream dos;
    private static DataInputStream dis;
    private static volatile boolean workFinished;

    public static void main(String[] args) throws IOException {

        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        Reader reader = new Reader();
        Writer writer = new Writer();
        writer.start();
        reader.start();

        try {
            while (!workFinished) {
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {

        }
        reader.interrupt();
        writer.interrupt();
        closeConnection();
    }

    private static void closeConnection() {
        try {
            socket.close();
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class Reader extends Thread {

        @Override
        public void run() {
            while (socket.isConnected() && !this.isInterrupted()) {
                try {
                    String string = dis.readUTF();
                    if (string.equals("exit")) {
                        System.out.println("Work is finished");
                        workFinished = true;
                        break;
                    }
                    System.out.println("Server:" + string);

                } catch (Exception e) {
                }
            }
        }
    }

    public static class Writer extends Thread {

        @Override
        public void run() {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (socket.isConnected() && !this.isInterrupted()) {
                try {
                    String readed = bufferedReader.readLine();
                    dos.writeUTF(readed);
                    if (readed.equals("exit")) {
                        System.out.println("Work is finished");
                        workFinished = true;
                        break;
                    }
                } catch (Exception e) {
                }
            }
        }

    }


}