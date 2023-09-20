package ch.csbe.backendlb.resources.user.authentifikation;

import ch.csbe.backendlb.resources.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

public class MyUserPrincipal implements UserDetails {
    private User user;

    public MyUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Implement the logic to retrieve user's authorities (roles) here if needed.
        return null;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implement the logic for account expiration if needed.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implement the logic for locked accounts if needed.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implement the logic for expired credentials if needed.
    }

    @Override
    public boolean isEnabled() {
        return true; // Implement the logic for disabled accounts if needed.
    }
}
