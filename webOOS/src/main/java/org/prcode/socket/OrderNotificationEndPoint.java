package org.prcode.socket;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

/**
 * @className: OrderNotificationEndPoint.
 * @date: 2017-11-24 14:57
 * @author: kangduo
 * @description: ()
 */
@ServerEndpoint("/ws/order/") //WebSocket客户端建立连接的地址
@Component
public class OrderNotificationEndPoint {

    /**
     * 存活的session集合
     */
    private static Map<String, Session> livingSessions = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        livingSessions.put(session.getId(), session);
        System.out.println("新加入了webSocket, sessionId：" + session.getId());
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("webSocket发生错误, sessionId:" + session.getId());
        error.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {
        livingSessions.remove(session.getId());
        System.out.println("webSocket关闭，sessionId:" + session.getId());
    }

    private void sendMessage(Session session, String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessageToAll(String message) {
        livingSessions.forEach((sessionId, session) -> sendMessage(session, message));
    }
}
