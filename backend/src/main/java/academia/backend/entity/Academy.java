package academia.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "academy")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor

public class Academy {
    @Id
    @GeneratedValue()
}
