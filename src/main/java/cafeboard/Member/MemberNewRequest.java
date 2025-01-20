package cafeboard.Member;

import jakarta.validation.constraints.NotBlank;

public record MemberNewRequest(
        @NotBlank String userName,
        @NotBlank String userPassword,
        @NotBlank String userEmail


) {




}
