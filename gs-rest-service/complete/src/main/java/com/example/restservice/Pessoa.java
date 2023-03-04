package com.example.restservice;
import java.sql.Connection;

public class Pessoa {

    private int id;
    private String idNomePessoa;
    private int idNumeroFila;
    private int idCadastrarTelefone;
    private Connection conn;

    public Pessoa() {

    }
    public Pessoa (String idNomePessoa, int idNumeroFila, int idCadastrarTelefone) {
        this.id = id;
        this.idNomePessoa = idNomePessoa;
        this.idNumeroFila = 1;
        this.idCadastrarTelefone = idCadastrarTelefone;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection( "jdbc: mysql://localhost:8080/contas?useSSL=false", "xxxxxxx", "xxxxxx");
            Statement stmt = this.conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXIST (idCadastrarTelefone INT, idNumeroFila INT, idNomePessoa VARCHAR (255)"); 
            stmt.execute("INSET INTO conta VALUES (" + this.idCadastrarTelefone + ", "+ this.idNomePessoa + " , "+ this.idNumeroFila + ")");

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void idNomePessoa(String idNomePessoa) {
        this.idNomePessoa = idNomePessoa;
    }
    public void idCadastrarTelefone(int idCadastrarTelefone) {
        this.idCadastrarTelefone = idCadastrarTelefone;
    }
    public void idNumeroFila(int idNumeroFila) {
        this.idNumeroFila = idNumeroFila;
    }

    public void id(int id){
        this.id = id;
    }

    public String idNomePessoa() {
        return idNomePessoa;
    }
    public int idCadastrarTelefone() {
        return idCadastrarTelefone;
    }
    public double idNumeroFila() {
        return idNumeroFila;
    }

    public int id(){
        return id;
    }

//Método para cadastrar pessoa no Banco
public void cadastrarNome(String idNovoNome) {
    this.idNomePessoa = idNovoNome;
    try {
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("UPDATE PESSOA SET PESSOA" + this.idNomePessoa + "WHERE idNomePessoa" + this.idNumeroFila);
    } catch (Exception e ){
        System.out.println(e);
    }
    
}

//Método para cadastrar telefone no Banco
public void cadastrarTelefone(int idNovoCadastroTelefone) {
    this.idCadastrarTelefone = idNovoCadastroTelefone;
    try {
        Statement stmt = this.conn.createStatement();
        stmt.executeUpdate("UPDATE PESSOA SET TELEFONE" + this.idCadastrarTelefone + "WHERE idCadastrarTelefone" + this.idNumeroFila);
    } catch (Exception e ){
        System.out.println(e);
    }
    
}
    }




    