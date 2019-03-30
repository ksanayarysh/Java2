package chat.client;

import chat.network.TCPConnection;
import chat.network.TCPConnectionListener;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleClient implements TCPConnectionListener {
    public static final String IP_ADDR = "127.0.0.1";
    public static final int PORT = 8189;

    public static void main(String[] args) {
        new ConsoleClient();
    }

    private TCPConnection connection;
    private Scanner sc = new Scanner(System.in);

    public ConsoleClient() {
        try {
            connection = new TCPConnection(this, IP_ADDR, PORT);
            while (true) {
                String str = sc.nextLine();
                if (str.equals("/end")) {
                    connection.disconnect();
                    break;
                } else {
                    connection.sendString(str);
                }
            }
        } catch (IOException e) {
            printMessage("Connection exception: " + e);
        }
    }


    @Override
    public void onConnectionReady(TCPConnection tcpConnection) {
        printMessage("Connection ready... ");
    }

    @Override
    public void onReceiveString(TCPConnection tcpConnection, String value) {
        printMessage(value);
    }

    @Override
    public void onDisconnect(TCPConnection tcpConnection) {
        printMessage("Connection closed ");
    }

    @Override
    public void onException(TCPConnection tcpConnection, Exception e) {
        printMessage("Connection exception: " + e);
    }

    private synchronized void printMessage(String msg) {
        System.out.println(msg);
    }
}
