import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {

            //creating a server socket
            ServerSocket serverSocket= new ServerSocket(3002);
            //accept request and move to new socket
            Socket socket = serverSocket.accept();
            //Java application used inputStream to read the data
            System.out.println("client accepted!");

            DataInputStream dataInputStream =new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String message="";
            String reply="";

            while (!message.equals("end-chat")){
                message = dataInputStream.readUTF();
                System.out.println("Client : "+message);

                reply = bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
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
