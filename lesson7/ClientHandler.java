package lesson7;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable {

    private static int clientsCount = 0;
    private Server server;
    private Socket clientSocket;
    private PrintWriter outMessage;
    private Scanner inMessage;
    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public ClientHandler(Socket clientSocket, Server server) {
        try {
            clientsCount++;
            this.server = server;
            this.clientSocket = clientSocket;
            this.outMessage = new PrintWriter(clientSocket.getOutputStream());
            this.inMessage = new Scanner(clientSocket.getInputStream());
            this.nickName = "";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }


    }

    private void close() {
        server.removeClientFromServer(this);
        clientsCount--;
        server.sendMsgToAllClients("In our chat client count is " + clientsCount);
    }

    public void sendMsg(String msg) {
        outMessage.println(msg);
        outMessage.flush();

    }

    @Override
    public void run() {

        try {
            server.sendMsgToAllClients("We have a new clients");

            while (true) {
                if (inMessage.hasNext()) {
                    String clientMsg = inMessage.nextLine();
                    System.out.println(clientMsg);

                    if (clientMsg.equalsIgnoreCase("EXIT")) {
                        break;
                    }

                    if (clientMsg.startsWith("/w")) {
                        String nick = clientMsg.split(" ")[1];
                        server.sendMsgToNickName(nick, clientMsg);
                    } else if (clientMsg.startsWith("/name")) {
                        nickName = clientMsg.split(" ")[1];
                    }
                    else server.sendMsgToAllClients(clientMsg);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close();
        }


    }
}
