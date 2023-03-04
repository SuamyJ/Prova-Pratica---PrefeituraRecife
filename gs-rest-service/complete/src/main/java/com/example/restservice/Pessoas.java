import com.example.restservice.Pessoa;

@Entity
@Table(name = "pessoas")


public class Pessoas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "idNomePessoa", nullable = false)
    private String idNomePessoa;
    
    @Column(name = "idCadastrarTelefone", nullable = false)
    private int idCadastrarTelefone;
    
    @Column(name = "idNumeroFila", nullable = false)
    private int idNumeroFila;
}