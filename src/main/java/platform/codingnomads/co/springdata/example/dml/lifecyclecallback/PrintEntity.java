package platform.codingnomads.co.springdata.example.dml.lifecyclecallback;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PrintEntity {

    @Id
    @GeneratedValue
    private Long id;

    // write your methods here
    @PrePersist
    @PreUpdate
    private void printPrePersist(){
        System.out.println("Updating or Saving PrintEntity " + id + " now...");
    }

    @PostPersist
    private void printPostPersist(){
        System.out.println("PrintEntity " + this.id + " persisted before this");
    }

    @PostUpdate
    private void printPostUpdate(){
        System.out.println("Just updated PrintEntity " + id + "...");
    }
}
