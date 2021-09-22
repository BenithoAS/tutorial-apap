package apap.tutorial.emsidi.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "menu")
public class MenuModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noMenu;

    @NonNull
    @Size(max = 30)
    @Column(name = "nama_menu", nullable = false)
    private String namaMenu;

    @Column(name = "is_available", nullable = false)
    private Boolean isAvailable;

    //Relasi degan CabangModel
    @ManyToMany(mappedBy = "listMenu")
    List<CabangModel> listCabang;
}
