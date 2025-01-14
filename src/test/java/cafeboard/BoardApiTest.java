package cafeboard;

import cafeboard.Board.CreateBoardRequest;
import cafeboard.Board.UpdateBoardRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


public class BoardApiTest extends AcceptanceTest {

    @DisplayName("보드생성")
    @Test
    void createBoard() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());


    }

    @DisplayName("보드조회")
    @Test
    void findBoard() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());


//조회
        RestAssured
                .given().log().all()

                .when()
                .get("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("보드업뎃")
    @Test
    void updateBoard() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
        //보드업뎃
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new UpdateBoardRequest("공지사항수정"))
                .pathParam("boardId", 1L)
                .when()
                .post("/boards/{boardId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

    @DisplayName("보드삭제")
    @Test
    void deleteBoard() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new CreateBoardRequest("공지사항"))
                .when()
                .post("/boards")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
        //보드삭제
        RestAssured
                .given().log().all()
                .pathParam("boardId", 1L)
                .when()
                .delete("/boards/{boardId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }

}