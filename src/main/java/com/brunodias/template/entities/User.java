package com.brunodias.template.entities;

import com.brunodias.template.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.SuperBuilder;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
public class User extends BaseEntity implements UserDetails {

    @NotBlank(message = "O campo nome não pode ficar em branco")
    private String firstName;

    @NotBlank(message = "O campo sobrenome não pode ficar em branco")
    private String lastName;

    @NotBlank(message = "O campo de email não pode ficar em branco")
    @Column(unique = true)
    @Email(message = "Por favor, digite o e-mail no formato correto!")
    private String email;

    @NotBlank(message = "O campo de senha não pode ficar em branco")
    @Size(min = 5, message = "A senha deve ter pelo menos 5 caracteres")
    private String password;

    @Enumerated(EnumType.STRING) // especificar como um campo do tipo enum deve ser mapeado para uma coluna em um
    private UserRole role;

    @OneToMany(mappedBy = "author")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;


    public String getFullName(){
        return firstName + " " + lastName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == UserRole.ADMIN)
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        else
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
