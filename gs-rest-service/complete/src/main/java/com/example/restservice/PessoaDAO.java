public class PessoaDAO {
    private SessionFactory sessionFactory;

    public PessoaDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void salvar(Pessoa pessoa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(pessoa);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    //Método para buscar pessoa pelo id

    public Pessoa buscarPorId(Long id) {
        Session session = sessionFactory.openSession();
        Pessoa pessoa = null;
        try {
            pessoa = (Pessoa) session.get(Pessoa.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pessoa;
    }
    
    //Método para buscar pessoa pelo nome

    public void atualizar(Pessoa pessoa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.update(pessoa);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    //Método para excluir pessoa pelo pessoa

    public void excluir(Pessoa pessoa) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete(pessoa);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    //Método para listar pessoa

    public List<Pessoa> listarTodos() {
        Session session = sessionFactory.openSession();
        List<Pessoa> pessoas = null;
        try {
            pessoas = session.createQuery("FROM Pessoa").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return pessoas;
    }
}