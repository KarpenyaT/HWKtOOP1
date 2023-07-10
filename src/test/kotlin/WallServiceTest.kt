import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        val post = Post(
            ownerId = 2,
            text = "21 июня самый длинный световой день",
            comments = Comments(canClose = false, canOpen = false),
            likes = Likes(userLikes = true),
            reposts = Reposts(count = 1),
            postType = "copy",
            canPin = false
        )
        val service = WallService
        service.add(post)
        assertEquals(1, service.get(0).id)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        service.add(
            Post(
                ownerId = 2,
                text = "21 июня самый длинный световой день",
                comments = Comments(canClose = false, canOpen = false),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                postType = "copy",
                canPin = false
            )
        )
        service.add(
            Post(
                ownerId = 2,
                text = "21 июня самый длинный световой день",
                comments = Comments(canClose = false, canOpen = false),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                postType = "copy",
                canPin = false
            )
        )
        val postUpdate = Post(
            id = 2,
            ownerId = 2,
            text = "22 июня самый длинный световой день",
            comments = Comments(canClose = false, canOpen = false),
            likes = Likes(userLikes = true),
            reposts = Reposts(count = 1),
            postType = "copy",
            canPin = false
        )

        val result = service.update(postUpdate)
        assertEquals(true, result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(
            Post(
                ownerId = 2,
                text = "21 июня самый длинный световой день",
                comments = Comments(canClose = false, canOpen = false),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                postType = "copy",
                canPin = false
            )
        )
        service.add(
            Post(
                ownerId = 2,
                text = "21 июня самый длинный световой день",
                comments = Comments(canClose = false, canOpen = false),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                postType = "copy",
                canPin = false
            )
        )
        val postUpdate = Post(
            id = 25,
            ownerId = 2,
            text = "22 июня самый длинный световой день",
            comments = Comments(canClose = false, canOpen = false),
            likes = Likes(userLikes = true),
            reposts = Reposts(count = 1),
            postType = "copy",
            canPin = false
        )

        val result = service.update(postUpdate)
        assertEquals(false, result)
    }

}