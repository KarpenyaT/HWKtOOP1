import java.util.Objects

fun main() {
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
    val post2 = Post(
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
    val postUpdate = Post(
        id = 2,
        ownerId = 1,
        fromId = 1,
        createdBy = 1,
        date = 4325,
        text = "23 июня самый длинный световой день",
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
    println(service.add(post))
    println(service.add(post2))
    println(service.update(postUpdate))
    println(service.get(3))
}

data class Post(
    val id: Int=0,
    val ownerId: Int,
    val fromId:Int,
    val createdBy:Int,
    val date:Int,
    val text: String,
    val replyOwnerId:Int,
    val friendsOnly: Boolean = false,
    val comments: Comments?,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val views: Views,
    val postType: String = "post", //post, copy,reply,postpone,suggest
    val postSource:PostSource,
    val geo: Geo?,
    val signerId:Int?,
    val copyHistory:Array<Reposts>?=emptyArray(),
    val canPin: Boolean = true,
    val canDelete: Boolean = true,
    val canEdit: Boolean = true,
    val isPinned:Boolean=false,
    val marketAsAds:Boolean=false,
    val isFavorite:Boolean=false,
    val donut:Donut?,
    val postponedId:Boolean=false
)

data class Comments(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Copyright(
    val id:Int,
    val link:String,
    val name:String,
    val type:String
)
data class Likes(
    val count: Int = 0,
    val userLikes: Boolean,
    val canLikes: Boolean = true,
    val canPublish: Boolean = true
)

data class Reposts(val count: Int = 0, val userReposted: Boolean = false)

data class Views(val count:Int)

data class PostSource(
    val type:String, //vk, widget,api,rss,sms
    val platform:String,//android,iphone, wphone
    val data:String,//type=vk: profileActivity,profilePhoto; type=widget: comments,like,poll
    val url:String
)
data class Geo(
    val type: String,
    val coordinates:String,
    val place:Place?
)
data class Place(
    val id: Int,
    val title:String,
    val latitude:Int,
    val longitude:Int,
    val created:Int,
    val icon:String,
    val checkins:Int,
    val updated:Int,
    val type:Int,
    val country:Int,
    val city:Int,
    val address:String
)
data class Donut(
    val isDonut: Boolean=false,
    val paidDuration:Int,
    val placeholder:Objects,
    val canPublishFreeCopy:Boolean=false,
    val editMode:String="all"// all, duration
)
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