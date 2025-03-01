package com.example.board_back.service.implement;

import com.example.board_back.dto.request.auth.SignInRequestDto;
import com.example.board_back.dto.request.auth.SignUpRequestDto;
import com.example.board_back.dto.response.ResponseDto;
import com.example.board_back.dto.response.auth.SignInResponseDto;
import com.example.board_back.dto.response.auth.SignUpResponseDto;
import com.example.board_back.entity.UserEntity;
import com.example.board_back.provider.JwtProvider;
import com.example.board_back.repository.UserRepository;
import com.example.board_back.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 생성자를 직접 만들어서 의존성 주입하는 방법을 권장
public class AuthServiceImplement implements AuthService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    // 패스워드 암호화는 PasswordEncoder의 BCryptPasswordEncoder 구현체를 통해 암호화 + 직접 의존성을 주입해줌
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {

        try {
            // email, nickname, telNumber 중복 검사
            String email = dto.getEmail();
            boolean existedEmail = userRepository.existsByEmail(email);
            if(existedEmail) return SignUpResponseDto.duplicateEmail();

            String nickname = dto.getNickname();
            boolean existedNickname = userRepository.existsByNickname(nickname);
            if(existedNickname) return SignUpResponseDto.duplicateNickname();

            String telNumber = dto.getTelNumber();
            boolean existedTelNumber = userRepository.existsByTelNumber(telNumber);
            if(existedTelNumber) return SignUpResponseDto.duplicateTelNumber();

            // password 암호화 후 테이블에 추가
            String password = dto.getPassword();
            String encodedPassword = passwordEncoder.encode(password);
            dto.setPassword(encodedPassword);

            // 코드의 간결성을 위해서 UserEntity에 dto를 받는 생성자를 정의해서 암호화된 password를 설정해줌
            UserEntity userEntity = new UserEntity(dto);
            userRepository.save(userEntity); // DB에 바뀐 password를 저장

        } catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {

        String token = null;

        try {

            String email = dto.getEmail();
            UserEntity userEntity = userRepository.findByEmail(email);
            if(userEntity == null) {
                return SignInResponseDto.signInFail();
            }

            String password = dto.getPassword();
            String encodedPassword = userEntity.getPassword();

            // password와 encodedPassword를 비교
            boolean isMatched = passwordEncoder.matches(password, encodedPassword);
            if(!isMatched) return SignInResponseDto.signInFail();

            // jwtProvider의 create를 활용해서 token을 만들어줌
            token = jwtProvider.create(email);

        } catch(Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignInResponseDto.success(token);
    }
}
