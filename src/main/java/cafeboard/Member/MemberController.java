package cafeboard.Member;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //회원가입
    @PostMapping("/register")
    public ResponseEntity<String> registerMember(@RequestBody MemberResponse memberResponse){
        Long memberId = memberService.registerMember(memberResponse);
        return ResponseEntity.ok("회원가입아이디 : " + memberId);
    }


//    //회원가입
//    @PostMapping("/register")
//    void memberNew(@Valid @RequestBody MemberNewRequest request){
//        Long memberId = memberService.registerMember(registerMember(request));
//    }




    //회원탈퇴
    @DeleteMapping("/{memberId}")
    public ResponseEntity<String> deleteMember(@PathVariable Long memberId){
        memberService.deleteMember(memberId);
        return ResponseEntity.ok("삭제아이디 : " + memberId);
    }


    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest){
        memberService.login(loginRequest);
        System.out.println("로그인ㅇㅋ");
    }

}
