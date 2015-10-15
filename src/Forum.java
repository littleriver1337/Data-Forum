import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by MattBrown on 10/15/15.
 */
public class Forum {
    public static void main(String[] args) {
        ArrayList<Post> posts = new ArrayList();//creating a new array list of posts
        String postContent = readFile("post.txt");//post.txt is the name of the text file we are pulling information from
        String[] lines = postContent.split("\n");//split content feature defined as "\n"

        for (String line: lines){//pulls lies
            String[] columns = line.split("\\|");// the \\ breaks the | in order for it to seperate columns by |
            int replyId = Integer.valueOf(columns[0]);
            String author = columns [1];
            String text = columns [2];
            Post post = new Post(replyId, author, text);
            posts.add(post);
        }

        Scanner scanner = new Scanner(System.in);
        int postId = -1;
        while (true){
            printPost(posts, postId);
            System.out.println("Enter posts id to see replies");
            postId = Integer.valueOf(scanner.nextLine());
        }
    }

    static void printPost(ArrayList<Post> posts, int postId){//created new method
        int id = 0;//dictates post number
        for (Post post : posts){//ask for clarification on this
            if (post.replyId == postId){
                System.out.println(String.format("[%d] %s (%s)", id, post.text, post.author));
            }
            id++;//adds +1
        }
    }

    static String readFile(String fileName) {//copy and paste when I need to read/write files
        File f = new File(fileName);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }

    }

    static void writeFile(String fileName, String fileContent){//copy and paste when you need to read/write files
        File f = new File(fileName);
        try{
            FileWriter fw = new FileWriter(f);
            fw.write(fileContent);
            fw.close();
        } catch (Exception e) {

        }
    }
}