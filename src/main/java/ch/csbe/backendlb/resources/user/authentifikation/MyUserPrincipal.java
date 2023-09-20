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
        // Implementieren Sie die Berechtigungslogik hier, falls benötigt.
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
        return true; // Implementieren Sie die Logik für das Ablaufdatum des Kontos, falls benötigt.
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implementieren Sie die Logik für gesperrte Konten, falls benötigt.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implementieren Sie die Logik für abgelaufene Anmeldeinformationen, falls benötigt.
    }

    @Override
    public boolean isEnabled() {
        return true; // Implementieren Sie die Logik für deaktivierte Konten, falls benötigt.
    }
}
