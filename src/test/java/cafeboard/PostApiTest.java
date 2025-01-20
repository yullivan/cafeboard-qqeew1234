package cafeboard;

import cafeboard.Board.CreateBoardRequest;
import cafeboard.Post.CreatePostRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PostApiTest extends AcceptanceTest {

    @DisplayName("포스트생성")
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
    }


    @DisplayName("포스트삭제")
    @Test
    void DeletePost() {
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
                .pathParam("postId", 1L)

                .when()
                .delete("/posts/{postId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }


    @DisplayName("포스트업뎃")
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
//업뎃
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreatePostRequest("글 제목수정", 1L, "게시글내용수정"))
                .pathParam("postId", 1L)
                .when()
                .post("/posts/{postId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("포스트조회")
    @Test
    void findPost() {
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
//조회
        RestAssured
                .given().log().all()

                .when()
                .get("/posts")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }


    @DisplayName("특정게시글조회")
    @Test
    void findDetailPost() {
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
//특정게시글조회
        RestAssured
                .given().log().all()

                .pathParam("postId", 1L)

                .when()
                .get("/posts/{postId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }


    @DisplayName("특정 게시판의 게시글 목록 조회")
    @Test
    void findPostListByBoard() {
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
//특정 게시판의 게시글 목록 조회
        RestAssured
                .given().log().all()

                .pathParam("boardId", 1L)

                .when()
                .get("/boards/{boardId}/posts")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }


    @DisplayName("특정 게시글의 댓글 목록 조회")
    @Test
    void findCommentListByPost() {
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
//특정 게시글의 댓글 목록 조회
        RestAssured
                .given().log().all()

                .pathParam("postId", 1L)

                .when()
                .get("/posts/{postId}/comments")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

}