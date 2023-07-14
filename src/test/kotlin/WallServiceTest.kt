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
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 4325,
            text = "21 июня самый длинный световой день",
            replyOwnerId = 1,
            comments = Comments(canClose = false, canOpen = false),
            copyright = Copyright(1,"www.kkk.ru","name","type"),
            likes = Likes(userLikes = true),
            reposts = Reposts(count = 1),
            views = Views(0),
            postType = "copy",
            postSource = PostSource("vk","android","profileActivity","URL"),
            geo = null,
            signerId = null,
            copyHistory = null,
            canPin = false,
            donut = null
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
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 4325,
                text = "21 июня самый длинный световой день",
                replyOwnerId = 1,
                comments = Comments(canClose = false, canOpen = false),
                copyright = Copyright(1,"www.kkk.ru","name","type"),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                views = Views(0),
                postType = "copy",
                postSource = PostSource("vk","android","profileActivity","URL"),
                geo = null,
                signerId = null,
                copyHistory = null,
                canPin = false,
                donut = null
            )
        )
        service.add(
            Post(
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 4325,
                text = "21 июня самый длинный световой день",
                replyOwnerId = 1,
                comments = Comments(canClose = false, canOpen = false),
                copyright = Copyright(1,"www.kkk.ru","name","type"),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                views = Views(0),
                postType = "copy",
                postSource = PostSource("vk","android","profileActivity","URL"),
                geo = null,
                signerId = null,
                copyHistory = null,
                canPin = false,
                donut = null
            )
        )
        val postUpdate = Post(
            id = 2,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 4325,
            text = "22 июня самый длинный световой день",
            replyOwnerId = 1,
            comments = Comments(canClose = false, canOpen = false),
            copyright = Copyright(1,"www.kkk.ru","name","type"),
            likes = Likes(userLikes = true),
            reposts = Reposts(count = 1),
            views = Views(0),
            postType = "copy",
            postSource = PostSource("vk","android","profileActivity","URL"),
            geo = null,
            signerId = null,
            copyHistory = null,
            canPin = false,
            donut = null
        )

        val result = service.update(postUpdate)
        assertEquals(true, result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(
            Post(
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 4325,
                text = "21 июня самый длинный световой день",
                replyOwnerId = 1,
                comments = Comments(canClose = false, canOpen = false),
                copyright = Copyright(1,"www.kkk.ru","name","type"),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                views = Views(0),
                postType = "copy",
                postSource = PostSource("vk","android","profileActivity","URL"),
                geo = null,
                signerId = null,
                copyHistory = null,
                canPin = false,
                donut = null
            )
        )
        service.add(
            Post(
                ownerId = 1,
                fromId = 1,
                createdBy = 1,
                date = 4325,
                text = "21 июня самый длинный световой день",
                replyOwnerId = 1,
                comments = Comments(canClose = false, canOpen = false),
                copyright = Copyright(1,"www.kkk.ru","name","type"),
                likes = Likes(userLikes = true),
                reposts = Reposts(count = 1),
                views = Views(0),
                postType = "copy",
                postSource = PostSource("vk","android","profileActivity","URL"),
                geo = null,
                signerId = null,
                copyHistory = null,
                canPin = false,
                donut = null
            )
        )
        val postUpdate = Post(
            id = 25,
            ownerId = 1,
            fromId = 1,
            createdBy = 1,
            date = 4325,
            text = "21 июня самый длинный световой день",
            replyOwnerId = 1,
            comments = Comments(canClose = false, canOpen = false),
            copyright = Copyright(1,"www.kkk.ru","name","type"),
            likes = Likes(userLikes = true),
            reposts = Reposts(count = 1),
            views = Views(0),
            postType = "copy",
            postSource = PostSource("vk","android","profileActivity","URL"),
            geo = null,
            signerId = null,
            copyHistory = null,
            canPin = false,
            donut = null
        )

        val result = service.update(postUpdate)
        assertEquals(false, result)
    }

}