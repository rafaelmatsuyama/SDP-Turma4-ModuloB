package lab05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto getProdutoById(int id) {
        System.out.println("getProdutoById()");
        return produtoRepository.findById(id).get();
    }
    public List<Produto> getAllProdutos(){
        System.out.println("getAllProdutos()");
        List<Produto> lista = new ArrayList<>();
        produtoRepository.findAll().forEach(e -> lista.add(e));
        return lista;
    }

    public Produto addProduto(Produto produto){
        System.out.println("addProduto()");
        return produtoRepository.save(produto);
    }

    public Produto updateProduto(Produto produto) {
        System.out.println("addProduto()");
        return produtoRepository.save(produto);
    }

    public void deleteProduto(int id) {
        System.out.println("deleteProduto()");
        produtoRepository.delete(produtoRepository.findById(id).get());
    }
}
