package group25.group25.usermanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import group25.group25.task.model.Task;
import group25.group25.workspace.model.Workspace;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @ManyToMany(mappedBy = "assignedUsers")
    @JsonIgnore
    private Set<Workspace> workspaces = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_fname")
    private String firstName;

    @Column(name = "user_lname")
    private String lastName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_username")
    private String username;

    @Column(name = "security_answer")
    private String answer;

    @OneToMany
    @JoinColumn(name = "card_user")
    @JsonIgnore
    private Set<Task> tasks;

    public User(String email, String firstName, String lastName, String password, String username, String answer) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        this.answer = answer;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Workspace> getWorkspaces() {
        return workspaces;
    }
    public String getSecurityAnswer() {
        return answer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.answer = securityAnswer;
    }

    public void setWorkspaces(Set<Workspace> workspaces) {
        this.workspaces = workspaces;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
