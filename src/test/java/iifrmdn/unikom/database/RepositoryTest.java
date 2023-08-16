package iifrmdn.unikom.database;

import iifrmdn.unikom.database.entity.Comment;
import iifrmdn.unikom.database.repository.CommentRepository;
import iifrmdn.unikom.database.repository.CommentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RepositoryTest {

    private CommentRepository commentRepository;

    @BeforeEach
    void setUp(){
        commentRepository = new CommentRepositoryImpl();
    }

    @Test
    void testInsert() {
        Comment comment = new Comment("iifrmdn@test.com","hai");
        commentRepository.insert(comment);

        Assertions.assertNotNull(comment.getId());
    }

    @Test
    void testFindById(){
        Comment comment = commentRepository.findById(3406);
        Assertions.assertNotNull(comment);
        System.out.println(comment.getId());
        System.out.println(comment.getEmail());
        System.out.println(comment.getComment());
    }

    @Test
    void testFindAll(){
        List<Comment> comments = commentRepository.findAll();
        System.out.println(comments.size());
    }

    @Test
    void testFindByEmail(){
        List<Comment> comments = commentRepository.findAllByEmail("iifrmdn@test.com");
        System.out.println(comments.size());
    }




}
