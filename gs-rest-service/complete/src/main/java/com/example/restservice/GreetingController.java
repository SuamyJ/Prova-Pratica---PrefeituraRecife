package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/pessoas")
	public class PessoaController {
		@Autowired
		private PessoaDAO pessoaDAO;
		
		@Autowired
		private SMSProvider smsProvider;
		
		@GetMapping
		public List<Pessoa> listarPessoas() {
			return pessoaDAO.listarTodos();
		}
		
		@PostMapping
		public ResponseEntity<?> adicionarPessoa(@RequestBody Pessoa pessoa) {
			pessoaDAO.salvar(pessoa);
			smsProvider.enviarSMS(pessoa);
			return ResponseEntity.ok().build();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long id) {
			Pessoa pessoa = pessoaDAO.buscarPorId(id);
			if (pessoa == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(pessoa);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
			Pessoa pessoa = pessoaDAO.buscarPorId(id);
			if (pessoa == null) {
				return ResponseEntity.notFound().build();
			}
			pessoa.setNome(pessoaAtualizada.getNome());
			pessoa.setIdade(pessoaAtualizada.getIdade());
			pessoa.setPosicaoFila(pessoaAtualizada.getPosicaoFila());
			pessoaDAO.atualizar(pessoa);
			return ResponseEntity.ok().build();
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<?> excluirPessoa(@PathVariable Long id) {
			Pessoa pessoa = pessoaDAO.buscarPorId(id);
			if (pessoa == null) {
				return ResponseEntity.notFound().build();
			}
			pessoaDAO.excluir(pessoa);
			return ResponseEntity.ok().build();
		}
	}
	}
