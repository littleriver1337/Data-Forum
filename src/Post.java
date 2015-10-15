/**
 * Created by MattBrown on 10/15/15.
 */
public class Post {
    int replyId;
    String author;
    String text;

    public Post(int replyId, String author, String text) {//control + n = create constructure
        this.replyId = replyId;
        this.author = author;
        this.text = text;
    }
}
