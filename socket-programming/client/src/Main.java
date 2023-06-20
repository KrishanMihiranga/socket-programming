import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 3002);

            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message="";
            String reply="";

            while (!message.equals("end-chat")){
                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();

                message = dataInputStream.readUTF();
                System.out.println("Server : "+message);

            }

            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
