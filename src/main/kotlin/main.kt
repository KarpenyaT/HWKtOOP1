fun main() {
    val post = Post(
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 4325,
        text = "21 июня самый длинный световой день",
        replyOwnerId = 1,
        comments = Comments(canClose = false, canOpen = false),
        copyright = Copyright(1, "www.kkk.ru", "name", "type"),
        likes = Likes(userLikes = true),
        reposts = Reposts(count = 1),
        views = Views(0),
        postType = "copy",
        postSource = PostSource("vk", "android", "profileActivity", "URL"),
        attachments= arrayOf(AttachmentAudio(
            "Audio",
            Audio(
                1,
                1,
                "author",
                "title",
                4,
                "ljk",
                1,
                1,
                1,
                7,
                null,
                null))),
        geo = null,
        signerId = null,
        copyHistory = null,
        canPin = false,
        donut = null
    )
    val post2 = Post(
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 4325,
        text = "21 июня самый длинный световой день",
        replyOwnerId = 1,
        comments = Comments(canClose = false, canOpen = false),
        copyright = Copyright(1, "www.kkk.ru", "name", "type"),
        likes = Likes(userLikes = true),
        reposts = Reposts(count = 1),
        views = Views(0),
        postType = "copy",
        postSource = PostSource("vk", "android", "profileActivity", "URL"),
        attachments = arrayOf(AttachmentGift("Gift",Gift(1,"a","a","a"))),
        geo = null,
        signerId = null,
        copyHistory = null,
        canPin = false,
        donut = null
    )
    val postUpdate = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 4325,
        text = "23 июня самый длинный световой день",
        replyOwnerId = 1,
        comments = Comments(canClose = false, canOpen = false),
        copyright = Copyright(1, "www.kkk.ru", "name", "type"),
        likes = Likes(userLikes = true),
        reposts = Reposts(count = 1),
        views = Views(0),
        postType = "copy",
        postSource = PostSource("vk", "android", "profileActivity", "URL"),
        attachments = arrayOf(AttachmentGift("Gift",Gift(1,"a","a","a"))),
        geo = null,
        signerId = null,
        copyHistory = null,
        canPin = false,
        donut = null
    )
    val service = WallService
    println(service.add(post))
    println(service.add(post2))
    println(service.update(postUpdate))
    println(service.get(1))
    println(service.get(1).attachments?.get(0))
}

object WallService {
    private var posts = emptyArray<Post>()
    private var lastId: Int = 0
    fun clear() {
        posts = emptyArray()
        lastId = 0
    }

    fun add(post: Post): Post {
        posts += post.copy(id = lastId + 1)
        lastId = posts.last().id
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, postArr) in posts.withIndex()) {
            if (postArr.id == post.id) {
                posts[index] = post
                return true
            }
        }
        return false
    }

    fun get(index: Int): Post {
        return posts[index]
    }

}