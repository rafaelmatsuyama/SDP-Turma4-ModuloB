package lab05;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Produto {
    @Id
    @Column
    private int id;
    @Column
    private String nome_produto;
    @Column
    private int quantidade;
    @Column
    private double preco;

    public Produto() {
    }

    public Produto(int id, String nome_produto, int quantidade, double preco) {
        this.id = id;
        this.nome_produto = nome_produto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Carrinho{" +
                "id=" + id +
                ", nome_produto='" + nome_produto + '\'' +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
