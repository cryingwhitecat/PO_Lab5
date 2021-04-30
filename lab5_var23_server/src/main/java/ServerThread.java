import java.io.*;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ServerThread extends Thread{
    private final Socket clientSocket;
    static final List<String> words = Arrays.asList("java", "python", "css");
    ServerThread(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    public void run(){
        BufferedReader input = null;
        BufferedWriter out = null;

        try {
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            if(GameConstants.isFinished()){
                try {
                Utils.writeToStream(out,"You've lost :-(");
                clientSocket.close();
                return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            var randomWord = Utils.getRandomElement(words);
            var shuffled = Utils.shuffleString(randomWord);
            Utils.writeToStream(out, shuffled);
            var response = Utils.readFromStream(input);
            var anyMatch = words.stream().anyMatch(x -> x.equals(response));
            if(anyMatch){
                Utils.writeToStream(out, "You've won!");
                GameConstants.setFinished(true);
            }
        }
    }
}
