package Chats


import Message
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceChatTest {
    private val service=WallServiceChat

    @Before
    fun clearBeforeTest() {
        WallServiceChat.clear()
    }
    @Test
    fun getUnreadChatsCount() {
        service.addMessage(1,Message(text = "lll"))
        service.addMessage(2,Message(text = "jjj"))
        assertEquals(2,service.getUnreadChatsCount())
    }

    @Test
    fun getChatById() {
        service.addMessage(1,Message(text = "lll"))
        service.addMessage(2,Message(text = "jjj"))

        assertEquals(1,service.getChatById(1)?.idInterlocutor)
    }

    @Test
    fun getMessagesFromChat() {
        service.addMessage(1,Message(text = "lll"))
        service.addMessage(1,Message(text = "jjj"))
        assertEquals( 1,service.getMessagesFromChat(1,1)?.count())
    }
    @Test
    fun getMessagesFromChatStatusRead() {
        service.addMessage(1,Message(text = "lll"))
        service.addMessage(1,Message(text = "jjj"))
        assertEquals( 0,service.getMessagesFromChat(1,2)?.count { !it.readStatus })
    }

    @Test
    fun addMessage() {
        service.addMessage(1,Message(text = "lll"))
        assertEquals(1,service.getChatById(1)?.messages?.count())
    }

    @Test
    fun deleteMessage() {
        service.addMessage(1,Message(text = "lll"))
        service.addMessage(1,Message(text = "jjj"))
        service.deleteMessage(1,0)
        val result=service.getChatById(1)?.messages?.find { it.id==0 }
        assertEquals(null, result )
    }
    @Test
    fun lastMessageFromChats() {
        service.addMessage(1,Message(text = "lll"))
        service.addMessage(2,Message(text = "lll1"))
        service.addMessage(1,Message(text = "lll2"))
        val result=service.lastMessageFromChats().count()
        assertEquals(2, result )
    }
    @Test
    fun deleteChat() {
        service.deleteChat(1)
        assertEquals(null,service.getChatById(1))
    }

}