package cafeboard;

import cafeboard.Member.MemberResponse;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class MemberTest extends AcceptanceTest {

    @DisplayName("회원가입")
    @Test
    void joinMember() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new MemberResponse("멤버1","486","이메일어쩌구"))
                .when()
                .post("/members/register")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }


    @DisplayName("회원탈퇴")
    @Test
    void exitMember() {
        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .body(new MemberResponse("멤버1","486","이메일어쩌구"))
                .when()
                .post("/members/register")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());

        RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("memberId", 1L)
                .when()
                .delete("/members/{memberId}")
                .then().log().all()
                .statusCode(HttpStatus.OK.value());
    }


}