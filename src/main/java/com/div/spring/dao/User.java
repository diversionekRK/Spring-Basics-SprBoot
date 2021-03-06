package com.div.spring.dao;

import com.div.spring.validation.FormValidationGroup;
import com.div.spring.validation.PersistanceValidationGroup;
import com.div.spring.validation.ValidEmail;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Div on 2018-05-07.
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @NotBlank(groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 8, max = 25, groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    @Pattern(regexp = "^\\w{8,}$", groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    @Id
    @Column(name = "username")
    private String username;

    @NotBlank(groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    @Pattern(regexp = "^\\S+$", groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 8, max = 15, groups = {FormValidationGroup.class})
    private String password;

    @ValidEmail(groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    private String email;

    @NotBlank(groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    @Size(min = 5, max = 60, message = "Name must be between 5 and 100 characters",
            groups = {PersistanceValidationGroup.class, FormValidationGroup.class})
    private String name;

    private boolean enabled = false;
    private String authority;

    public User() {
    }

    public User(String username, String password, String email, String name, boolean enabled, String authority) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.enabled = enabled;
        this.authority = authority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (enabled != user.enabled) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        return authority != null ? authority.equals(user.authority) : user.authority == null;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (enabled ? 1 : 0);
        result = 31 * result + (authority != null ? authority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", authority='" + authority + '\'' +
                '}';
    }
}
