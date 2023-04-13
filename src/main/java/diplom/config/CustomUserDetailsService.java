package diplom.config;

import diplom.elements.User;
import diplom.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    //извлечение пользовотеля по userName
    @Override
    public UserDetails loadUserByUsername(String userEmail) {
        Optional<User> userOptional = userRepository.findUserByUserEmail(userEmail);
        if(userOptional.isPresent()){
            User user = userOptional.get();
            return new org.springframework.security.core.userdetails.User(
                    user.getUserEmail(),
                    user.getPassword(),
                    List.of(new SimpleGrantedAuthority(user.getRole().name())));
        }else {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
