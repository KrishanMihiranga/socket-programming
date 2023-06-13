import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Main {
    
    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 3002);
            DataOutputStream dataOutputStream =new DataOutputStream(socket.getOutputStream());

            dataOutputStream.writeUTF("hola");
            
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
