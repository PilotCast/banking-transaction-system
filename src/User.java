import java.util.UUID;

public class User {
    //System generated
    private final String userId;

    //Selected
    private String username;

    public User(String chosenUsername) {
        if (chosenUsername == null || chosenUsername.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");
        }

        //Randomly makes a number sequence to be the userId
        this.userId = "USR" + UUID.randomUUID().toString().substring(0, 8);

        //chosenUsername
        this.username = chosenUsername;
    }



    //Setters
    public void updateUsername(String newUserName) {
        if (newUserName == null || newUserName.isBlank()) {
            throw new IllegalArgumentException("Username cannot be blank");}
        this.username = newUserName;}

    //Getters
    String getUserId() {
        return this.userId; }
    String getUsername() {
        return this.username; }


}
