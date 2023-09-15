package com.WildCodeSchool.Projet_3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.WildCodeSchool.Projet_3.dto.ChatMessageDto;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class ChatMessageController {

    private SocketIOServer socketServer;

    ChatMessageController(SocketIOServer socketServer){
        this.socketServer=socketServer;

        this.socketServer.addConnectListener(onUserConnectWithSocket);
        this.socketServer.addDisconnectListener(onUserDisconnectWithSocket);

        /**
         * Here we create only one event listener
         * but we can create any number of listener
         * messageSendToUser is socket end point after socket connection user have to send message payload on messageSendToUser event
         */
        this.socketServer.addEventListener("messageSendToUser", ChatMessageDto.class, onSendMessage);

    }


    public ConnectListener onUserConnectWithSocket = new ConnectListener() {
        @Override
        public void onConnect(SocketIOClient client) {
            System.out.println("Perform operation on user connect in controller");
        }
    };


    public DisconnectListener onUserDisconnectWithSocket = new DisconnectListener() {
        @Override
        public void onDisconnect(SocketIOClient client) {
            System.out.println("Perform operation on user disconnect in controller");
        }
    };

    public DataListener<ChatMessageDto> onSendMessage = new DataListener<ChatMessageDto>() {
        @Override
        public void onData(SocketIOClient client, ChatMessageDto message, AckRequest acknowledge) throws Exception {

            /**
             * Sending message to target user
             * target user should subscribe the socket event with his/her name.
             * Send the same payload to user
             */

            System.out.println(message.getSenderName()+" user send message to user "+message.getTargetUserName()+" and message is "+message.getMessage());
            socketServer.getBroadcastOperations().sendEvent(message.getTargetUserName(),client, message);


            /**
             * After sending message to target user we can send acknowledge to sender
             */
            acknowledge.sendAckData("Message send to target user successfully");
        }
    };
    
}
