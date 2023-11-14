package Chats

import Chat
import Message


fun main() {
    val service = WallServiceChat
    service.addMessage(1, Message(text = "jjj"))
    println(service.getChats())
    service.addMessage(2, Message(text = "kkk"))
    service.addMessage(1, Message(text = "kkk"))
    println(service.getChats())
    service.deleteMessage(1, 0)
    println(service.getMessagesFromChat(1, 1))
    println(service.getUnreadChatsCount())
    println(service.getChats())
    println(service.lastMessageFromChats())
    println( service.deleteChat(0))
    println(service.getChats())
}

object WallServiceChat {
    private var chats = mutableListOf<Chat>()
    private fun addChat(chat: Chat) {
        chats += chat.copy()
    }

    fun deleteChat(idInterlocutor: Int): Boolean {
        return chats.remove(getChatById(idInterlocutor))
    }

    fun getChats(): List<Chat> {
        return chats
    }

    fun getChatById(idInterlocutor: Int): Chat? {
        return chats.find { it.idInterlocutor == idInterlocutor }
    }

    fun getMessagesFromChat(idInterlocutor: Int, countMessages: Int): List<Message>? {
        getChatById(idInterlocutor)?.messages?.takeLast(countMessages)
            ?.forEach { it.readStatus = true }
        return getChatById(idInterlocutor)?.messages?.takeLast(countMessages)
    }

    fun addMessage(idInterlocutor: Int, message: Message) {
        if (getChatById(idInterlocutor) == null) addChat(Chat(idInterlocutor))
        val indexChat = chats.indexOf(getChatById(idInterlocutor))
        var lastIdMessages = if (chats[indexChat].messages.isEmpty()) -1 else chats[indexChat].messages.last().id
        chats[indexChat].messages += message.copy(id = ++lastIdMessages)
    }

    fun deleteMessage(idInterlocutor: Int, idMessage: Int) {
        getChatById(idInterlocutor)?.messages?.removeIf { message: Message -> message.id == idMessage }
        //if (getChatById(idInterlocutor)?.messages?.isEmpty() == true) deleteChat(idInterlocutor)
    }

    fun getUnreadChatsCount(): Int {
        return chats.count { chat -> chat.messages.any { !it.readStatus } }
    }

    fun lastMessageFromChats(): String {
        return chats.asSequence()
            .map { it.messages.lastOrNull()?.text ?: "Нет сообщений" }
            .joinToString(separator = "\n")
            .ifEmpty { "Нет чатов" }
    }

    fun clear() {
        chats = mutableListOf()
    }
}




