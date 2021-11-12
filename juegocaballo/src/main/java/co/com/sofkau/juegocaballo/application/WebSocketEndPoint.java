package co.com.sofkau.juegocaballo.application;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint(value = "/juego/{id}")
public class WebSocketEndPoint {

    @OnOpen
    public void onOpen(Session session) throws IOException {

        session.getBasicRemote().sendText("Test OnOpen");
    }

    @OnMessage
    public void onMessage(Session session, String idJuego) throws IOException {
        // Handle new messages
    }

    @OnClose
    public void onClose(Session session) throws IOException {
        // WebSocket connection closes
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

}
