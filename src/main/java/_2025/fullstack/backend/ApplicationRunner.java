package _2025.fullstack.backend;

import _2025.fullstack.backend.domain.user.entity.User;
import _2025.fullstack.backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ApplicationRunner implements CommandLineRunner {

    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception{
        User user1 = User.builder()
                .username("user1")
                .password("pw1")
                .nickname("nn1")
                .role("ROLE_USER")
                .totalScore(300)
                .allCleared(true)
                .build();
        User user2 = User.builder()
                .username("user2")
                .password("pw2")
                .nickname("nn2")
                .role("ROLE_USER")
                .totalScore(240)
                .allCleared(true)
                .build();
        User user3 = User.builder()
                .username("user3")
                .password("pw3")
                .nickname("nn3")
                .role("ROLE_USER")
                .totalScore(190)
                .allCleared(true)
                .build();
        User user4 = User.builder()
                .username("user4")
                .password("pw4")
                .nickname("nn4")
                .role("ROLE_USER")
                .totalScore(280)
                .allCleared(true)
                .build();

        userRepository.saveAllAndFlush(List.of(user1, user2, user3, user4));
    }
}
