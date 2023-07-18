import { useState, useEffect } from "react";
import "./Table.css";

// const fakeProducts = [
//   {
//     id: 1,
//     nome: "Chocolate",
//     quantidade: 1,
//     preco: "5.00",
//   },
//   {
//     id: 2,
//     nome: "Leite",
//     quantidade: 1,
//     preco: "5.50",
//   },
//   {
//     id: 3,
//     nome: "Farinha de trigo",
//     quantidade: 1,
//     preco: "6.00",
//   },
// ];

const baseUrl = "https://64a36aeab45881cc0ae6574b.mockapi.io/produtos"

function Table() {
  const [data, setData] = useState([]);
  //   const [loading, setLoading] = useState(true);
  //   const [error, setError] = useState(null);

  // código para a requisição get dos produtos
  function getProducts() {
    fetch(baseUrl)
      .then((response) => response.json())
      .then((response) => setData(response));
  }

  useEffect(() => {
    // setData(fakeProducts);

    getProducts();
    // usamos um setInterval para atualizar a listagem de produtos de tempos em tempos
    const interval = setInterval(() => getProducts(), 20000);
    return () => {
      clearInterval(interval);
    };
  }, []);

  function deleteProduct(id) {
    fetch(`${baseUrl}/${id}`, {
      method: "DELETE",
    }).then(() => getProducts());
  }

  return (
    <table>
      <tbody>
        <tr>
          <th>Id</th>
          <th>Nome</th>
          <th>Quantidade</th>
          <th>Preço</th>
          <th></th>
        </tr>
        {data &&
          data.length > 0 &&
          data.map(({ id, nome, quantidade, preco }) => (
            <tr key={id}>
              <td>{id}</td>
              <td>{nome}</td>
              <td>{quantidade}</td>
              <td>{preco}</td>
              <td>
                <a href="#" onClick={() => deleteProduct(id)}>
                  Remover
                </a>
              </td>
            </tr>
          ))}
      </tbody>
    </table>
  );
}

export default Table;
