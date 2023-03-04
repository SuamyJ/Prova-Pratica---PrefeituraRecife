@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PessoaTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Test
    public void testAdicionarPessoa() throws Exception {
        Pessoa pessoa = new Pessoa("Nome", 20, 0);

        mockMvc.perform(post("/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pessoa)))
                .andExpect(status().isOk());

        List<Pessoa> pessoas = pessoaRepository.findAll();
        assertThat(pessoas).hasSize(1);
        assertThat(pessoas.get(0).getNome()).isEqualTo("Nome");
        assertThat(pessoas.get(0).getIdade()).isEqualTo(20);
        assertThat(pessoas.get(0).getPosicaoFila()).isEqualTo(1);
    }
}