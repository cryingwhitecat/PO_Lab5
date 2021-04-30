import java.io.*;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        var clientSocket = new Socket("localhost", 1200);
        var reader = new BufferedReader(new InputStreamReader(System.in));
        var in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        var out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("Possible words: java, python, css");
        while(true){
            var serverOutput = in.readLine();
            var gameEnded = serverOutput.split(" ").length > 1;
            System.out.println(serverOutput);
            if(gameEnded){
                return;
            }
            System.out.print("Enter your guess: ");
            var guess = reader.readLine();
            out.write(guess + "\n");
            out.flush();
        }
    }
}
