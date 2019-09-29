package ru.cloudStorage.example.client;

import java.io.IOException;
import java.net.Socket;

import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;
import ru.cloudStorage.example.common.AbstractMessage;



public class Network {
    public static final int PORT = 8188;
    private static final int MAX_OBJ_SIZE = 50 * 1024 * 1024;
    private static Socket socket;
    private static ObjectEncoderOutputStream oeos = null;
    private static ObjectDecoderInputStream odis = null;


    public static void start() {
        try  {
            socket = new Socket("localhost", PORT);
            oeos = new ObjectEncoderOutputStream(socket.getOutputStream());
            odis = new ObjectDecoderInputStream(socket.getInputStream(), MAX_OBJ_SIZE);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void stop() {
        try {
            oeos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            odis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean sendMsg(AbstractMessage msg) {
        try {
            oeos.writeObject(msg);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static AbstractMessage readObject() throws ClassNotFoundException, IOException {
        Object obj = odis.readObject();
        return (AbstractMessage) obj;
    }

}
