package ma.avito.usere.domain.dto;

public class UserCreatedResponse {

    private Integer id;

    public UserCreatedResponse() {

    }

    public UserCreatedResponse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
