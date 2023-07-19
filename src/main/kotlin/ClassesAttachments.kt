import javax.swing.plaf.basic.BasicTreeUI.TreeCancelEditingAction

class AttachmentPhoto(override val type: String, val photo: Photo) : Attachment
data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int
)

class AttachmentAudio(override val type: String, val audio: Audio) : Attachment
data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String,
    val lyricsId: Int,
    val albumId: Int,
    val genreId: Int,
    val date: Int,
    val noSearch: Boolean?,
    val isHd: Boolean?
)

class AttachmentVideo(override val type: String,val video:Video):Attachment
data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val image: Array<Image> = emptyArray(),
    val firstFrame: Array<FirstFrame> = emptyArray(),
    val date: Int,
    val addingDate:Int,
    val views: Int,
    val localViews: Int,
    val comments: Int,
    val player:String,
    val platform:String,
    val canAdd:Boolean=true,
    val isPrivat:Int?,
    val accessKey:String,
    val processing:Int?,
    val isFavorite:Boolean=false,
    val canComment:Boolean=true,
    val canEdit:Boolean=true,
    val canLike:Boolean=true,
    val canRepost:Boolean=true,
    val canSubscribe:Boolean=true,
    val canAndToFaves:Boolean=true,
    val canAttachLink:Boolean=true,
    val width: Int,
    val height: Int,
    val userId: Int,
    val converting:Boolean,
    val added:Boolean,
    val isSubscribed:Boolean
)

data class Image(val height: Int, val url: String, val width: Int, val withPadding: Int?)
data class FirstFrame(val height: Int,val url: String,val width: Int)

class AttachmentFile(override val type: String,val file:File):Attachment
data class File(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size:Int,
    val ext:String,
    val url: String,
    val date: Int,
    val type:Int //1-text, 2-archive..

)

class AttachmentGift(override val type: String,val gift: Gift):Attachment
data class Gift(
    val id:Int,
    val thumb256:String,
    val thumb96:String,
    val thumb48:String
)