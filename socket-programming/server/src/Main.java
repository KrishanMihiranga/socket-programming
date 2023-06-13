import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        try {

            //creating a server socket
            ServerSocket serverSocket= new ServerSocket(3002);
            //accept request and move to new socket
            Socket socket = serverSocket.accept();
            //Java application used inputStream to read the data
            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());

            String message = dataInputStream.readUTF();
            System.out.println("Client : " + message);

            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
