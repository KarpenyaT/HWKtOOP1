fun main() {
    val post = Post(
        ownerId = 2,
        text = "21 июня самый длинный световой день",
        comments = Comments(canClose = false, canOpen = false),
        likes = Likes(userLikes = true),
        reposts = Reposts(count = 1),
        postType = "copy",
        canPin = false
    )
    val post2 = Post(
        ownerId = 2,
        text = "21 июня самый длинный световой день",
        comments = Comments(canClose = false, canOpen = false),
        likes = Likes(userLikes = true),
        reposts = Reposts(count = 1),
        postType = "copy",
        canPin = false
    )
    val postUpdate = Post(
        id = 2,
        ownerId = 2,
        text = "22 июня самый длинный световой день",
        comments = Comments(canClose = false, canOpen = false),
        likes = Likes(userLikes = true),
        reposts = Reposts(count = 1),
        canPin = false
    )
    val service = WallService
    println(service.add(post))
    println(service.add(post2))
    println(service.update(postUpdate))
    println(service.get(3))
}

data class Post(
    val id: Int = 0,
    val ownerId: Int,
    val text: String,
    val friendsOnly: Boolean = false,
    val comments: Comments,
    val likes: Likes,
    val reposts: Reposts,
    val postType: String = "post",
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Likes(
    val count: Int = 0,
    val userLikes: Boolean,
    val canLikes: Boolean = true,
    val canPublish: Boolean = true
)

data class Reposts(val count: Int = 0, val userReposted: Boolean = false)

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