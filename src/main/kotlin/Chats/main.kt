package Chats

import Chat
import Message


fun main() {
    val service = WallServiceChat
    service.addMessage(1, Message(text = "jjj"))
    println(service.getChatById(1))
    service.addMessage(1, Message(text = "kkk"))
    println(service.getChatById(1))
    //service.deleteMessage(1,1)
    println(service.getMessagesFromChat(1, 1))
    println(service.getUnreadChatsCount())
    service.getChats()
//    println( service.deleteChat(0))
//    println(service.getChats())
}

object WallServiceChat {
    private var chats = mutableListOf<Chat>()
    private fun addChat(chat: Chat) {
        chats += chat.copy()
    }

    fun deleteChat(idInterlocutor: Int): Boolean {
        return chats.remove(getChatById(idInterlocutor))
    }

    fun getChats() {
        chats.forEach { println(it) }
    }

    fun getChatById(idInterlocutor: Int): Chat? {
        return chats.find { it.idInterlocutor == idInterlocutor }
    }

    fun getMessagesFromChat(idInterlocutor: Int, countMessages: Int): List<Message>? {
        getChatById(idInterlocutor)?.messages?.filter { it.id < countMessages }?.forEach { it.readStatus = true }
        return getChatById(idInterlocutor)?.messages?.filter { it.id < countMessages }
    }

    fun addMessage(idInterlocutor: Int, message: Message) {
        if (getChatById(idInterlocutor) == null) addChat(Chat(idInterlocutor))
        val indexChat = chats.indexOf(getChatById(idInterlocutor))
        chats[indexChat].messages += message.copy(id = chats[indexChat].messages.size)
    }

    fun deleteMessage(idInterlocutor: Int, idMessage: Int) {
        getChatById(idInterlocutor)?.messages?.removeIf { message: Message -> message.id == idMessage }
        if (getChatById(idInterlocutor)?.messages?.isEmpty() == true) deleteChat(idInterlocutor)
    }

    fun getUnreadChatsCount(): Int {
        return chats.count { it.messages.count { it -> !it.readStatus } > 0 }
    }

    fun clear() {
        WallServiceChat.chats = mutableListOf()
    }
}




