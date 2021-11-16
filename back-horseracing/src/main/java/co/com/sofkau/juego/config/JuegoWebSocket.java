package co.com.sofkau.juego.config;

import co.com.sofkau.juego.domain.Juego;
import co.com.sofkau.juego.domain.command.IniciarJuegoCommand;
import co.com.sofkau.juego.usecase.IniciarJuegoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import java.util.ArrayList;
import java.util.List;

public class JuegoWebSocket extends TextWebSocketHandler {

    @Autowired
    private IniciarJuegoUseCase useCase;

    private final List<WebSocketSession> webSocketSessions = new ArrayList<>();


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        webSocketSessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {

        var juego = iniciar(message.getPayload());

        for (WebSocketSession webSocketSession : webSocketSessions){
            while (juego.jugando()){
                juego.moverCabbalos();
                TextMessage newMessage = new TextMessage(juego.toJSON());
                webSocketSession.sendMessage(newMessage);
                Thread.sleep(300);
            }
            TextMessage newMessage = new TextMessage(juego.toJSON());
            webSocketSession.sendMessage(newMessage);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        webSocketSessions.add(session);
    }

    public Juego iniciar(String id){
        IniciarJuegoCommand command = new IniciarJuegoCommand(id);
        return useCase.apply(command);
    }
}
