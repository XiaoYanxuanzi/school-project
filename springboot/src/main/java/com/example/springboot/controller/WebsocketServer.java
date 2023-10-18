package com.example.springboot.controller;

import com.example.springboot.exception.ServiceException;
import org.springframework.stereotype.Component;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@ServerEndpoint("/chat/{teacherId}/{studentId}")
@Component
public class WebsocketServer {

    // 存储老师的Session对象
    private static final Map<Integer, Session> teacherSessions = new ConcurrentHashMap<>();
    // 存储学生的Session对象
    private static final Map<Integer, Session> studentSessions = new ConcurrentHashMap<>();

    /**
     * 连接建立成功后调用的方法
     *
     * @param session   客户端的Session对象
     * @param teacherId 老师的ID
     * @param studentId 学生的ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("teacher") Integer teacherId, @PathParam("student") Integer studentId) {
        if (teacherId != null) {
            // 将老师的Session对象存储到teacherSessions中
            teacherSessions.put(teacherId, session);
        } else if (studentId != null) {
            // 将学生的Session对象存储到studentSessions中
            studentSessions.put(studentId, session);
        }
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param session 客户端的Session对象
     * @param message 客户端发送的消息
     * @throws IOException
     */
    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        // 将消息发送给对应的用户
        Integer senderId = getUserIdBySession(session);
        Integer receiverId = getReceiverIdBySession(session);
        Session receiverSession = getSessionById(receiverId);
        if (receiverSession != null) {
            if (isUserOnline(receiverId)) {
                // 如果接收者在线，将消息发送给接收者
                receiverSession.getBasicRemote().sendText(message);
            } else {
                // 对方不在线，可以进行相应的处理
                throw new ServiceException("对方不在线");
            }
        }
    }

    /**
     * 连接关闭后调用的方法
     *
     * @param session 客户端的Session对象
     */
    @OnClose
    public void onClose(Session session) {
        Integer userId = getUserIdBySession(session);
        if (userId != null) {
            if (teacherSessions.containsKey(userId)) {
                // 如果是老师的Session对象，从teacherSessions中移除
                teacherSessions.remove(userId);
            } else if (studentSessions.containsKey(userId)) {
                // 如果是学生的Session对象，从studentSessions中移除
                studentSessions.remove(userId);
            }
        }
    }

    /**
     * 根据Session对象获取用户ID
     *
     * @param session 客户端的Session对象
     * @return 用户ID
     */
    private Integer getUserIdBySession(Session session) {
        // 根据session获取用户id
        Integer userId = (Integer) session.getUserProperties().get("userId");
        return userId;
    }

    /**
     * 根据Session对象获取接收者ID
     *
     * @param session 客户端的Session对象
     * @return 接收者ID
     */
    private Integer getReceiverIdBySession(Session session) {
        // 根据session获取接收者id
        Integer receiverId = (Integer) session.getUserProperties().get("receiverId");
        return receiverId;
    }

    /**
     * 根据用户ID获取对应的Session对象
     *
     * @param id 用户ID
     * @return Session对象
     */
    private Session getSessionById(Integer id) {
        // 根据id获取对应的session
        if (teacherSessions.containsKey(id)) {
            return teacherSessions.get(id);
        } else if (studentSessions.containsKey(id)) {
            return studentSessions.get(id);
        }
        return null;
    }

    /**
     * 判断用户是否在线
     *
     * @param userId 用户ID
     * @return 是否在线
     */
    private boolean isUserOnline(Integer userId) {
        return teacherSessions.containsKey(userId) || studentSessions.containsKey(userId);
    }

}
