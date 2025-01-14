package cafeboard;

import cafeboard.Board.CreateBoardRequest;
import cafeboard.Comments.CreateCommentRequest;
import cafeboard.Comments.UpdateCommentRequest;
import cafeboard.Post.CreatePostRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


public class CommentTest extends AcceptanceTest {

    @DisplayName("코멘트생성")
    @Test
    void createPost() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreatePostRequest("글 제목", 1L, "게시글내용"))
                .when()
                .post("/posts")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateCommentRequest("댓글내용어쩌구", 1L, 1L))
                .when()
                .pathParam("postId", 1L)
                .post("/posts/{postId}/comment")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("코멘트수정")
    @Test
    void updatePost() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreatePostRequest("글 제목", 1L, "게시글내용"))
                .when()
                .post("/posts")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateCommentRequest("댓글내용어쩌구", 1L, 1L))
                .when()
                .pathParam("postId", 1L)
                .post("/posts/{postId}/comment")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());


//댓글수정
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new UpdateCommentRequest("댓글내용어쩌구저쩌구", 1L))
                .pathParam("commentId", 1L)
                .when()
                .post("/comment/{commentId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("코멘트삭제")
    @Test
    void deletePost() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreatePostRequest("글 제목", 1L, "게시글내용"))
                .when()
                .post("/posts")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateCommentRequest("댓글내용어쩌구", 1L, 1L))
                .when()
                .pathParam("postId", 1L)
                .post("/posts/{postId}/comment")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());


//댓글삭제
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("commentId", 1L)
                .when()
                .delete("/comment/{commentId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

//    RestAssured
//            .given().log().all()
//                .contentType(ContentType.JSON)
//                .when()
//                .delete("/posts/{postsId}")
//                .then().log().all()
//                .statusCode(HttpStatus.OK.value());


}