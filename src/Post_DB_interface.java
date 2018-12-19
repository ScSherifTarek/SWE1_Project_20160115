
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Owner
 */
public class Post_DB_interface {
        boolean AddPost(Post post){ return false;}
        boolean deletePost(Post post){return false;}
        boolean updatePost(Post post){ return false;}
        Post GetPost(int postID){ return null;} 
        ArrayList<Post> GetPostsBy(Account acc){return null;}
        
}
