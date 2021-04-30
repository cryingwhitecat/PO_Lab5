import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        var serverSocket = new ServerSocket(GameConstants.getPort());
        while (true) {
            try {
                var clientSocket = serverSocket.accept();
                System.out.println("connection established, client ip: "
                        + clientSocket.getInetAddress().toString());
                ServerThread st = new ServerThread(clientSocket);
                st.start();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connection Error");
            }
        }
    }

}

