package ma.avito.usere.domain.dto;

import ma.avito.usere.domain.model.User;

public class UserDto {

    private String name;
    private String email;
    private String avatar;

    public UserDto(String name, String email, String avatar) {
        this.name = name;
        this.email = email;
        this.avatar = avatar;
    }

    public static UserDto fromUser(User user) {
        return new UserDto(user.getName(), user.getEmail(), user.getAvatar());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
