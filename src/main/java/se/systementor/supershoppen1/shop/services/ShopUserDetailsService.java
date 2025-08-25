package se.systementor.supershoppen1.shop.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import se.systementor.supershoppen1.shop.model.UserAccount;
import se.systementor.supershoppen1.shop.model.UserAccountRepository;

@Service
public class ShopUserDetailsService implements UserDetailsService {

    @Autowired
    private UserAccountRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserAccount user = getUser(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<String> roles = user.getRoles();
        Set<SimpleGrantedAuthority> ga = new HashSet<>();
        for(String role:roles) {
            ga.add(new SimpleGrantedAuthority(role));
        }

        var springUser = new org.springframework.security.core.userdetails.User(
            username,
            user.getPassword(),
            ga );
        return springUser;
    }

    private UserAccount getUser(String username) {
        for(UserAccount r : userRepository.findAll())
        {
            if(r.getEmail().equals(username)) return r;
        }
        return null;
    }

    public List<UserAccount> getAll(){
        var l = new ArrayList<UserAccount>();
        for(UserAccount r : userRepository.findAll())
        {
            l.add(r);
        }
        return l;
    }

    public void save(UserAccount acc) {
        this.userRepository.save(acc);
    }
}