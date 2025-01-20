package cafeboard.Member;

import cafeboard.JwtProvider;
import cafeboard.SecurityUtils;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


@Service
public class MemberService {


    private MemberRepository memberRepository;
    private final JwtProvider jwtProvider;

    public MemberService(MemberRepository memberRepository, JwtProvider jwtProvider) {
        this.memberRepository = memberRepository;
        this.jwtProvider = jwtProvider;
    }

    @Transactional
    public Long registerMember(MemberResponse memberResponse) {
        if (memberRepository.existsByUserName(memberResponse.userName())){
            throw new IllegalArgumentException("이미존재하는유저네임.");
        }

        Member member = new Member();
        member.setUserName(memberResponse.userName());
        String hexPassword = SecurityUtils.sha256Encrypt(memberResponse.userPassword());
        member.setUserPassword(hexPassword);
//        member.setUserPassword(member.getUserPassword());
        member.setUserEmail(memberResponse.userEmail());

        memberRepository.save(member);
        return  member.getId();

    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }


    /// ///////////////////////////
    public LoginResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findByUserName(loginRequest.id())
                .orElseThrow(() -> new IllegalArgumentException("아이디 또는 비밀번호가 틀립니다"));

        String hexPassword = SecurityUtils.sha256Encrypt(loginRequest.password());

        if (!member.getUserPassword().equals(hexPassword)) {
            throw new IllegalArgumentException("아이디 또는 비밀번호가 틀립니다");
        }

        String token = jwtProvider.createToken(member.getUserName());
        return new LoginResponse(token);


//        Math.max(1, 3) -> 3
        // jwtProvider.createToken(member.getUserName()) -> eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
    }
}
