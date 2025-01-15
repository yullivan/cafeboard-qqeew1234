package cafeboard.Member;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MemberService {


    @Autowired
    private MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Long registerMember(MemberResponse memberResponse) {
        if (memberRepository.existsByUserName(memberResponse.userName())){
            throw new IllegalArgumentException("이미존재하는유저네임.");
        }

        Member member = new Member();
        member.setUserName(memberResponse.userName());
        member.setUserPassword(member.getUserPassword());
        member.setUserEmail(member.getUserEmail());

        memberRepository.save(member);
        return  member.getId();

    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}
