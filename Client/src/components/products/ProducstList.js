import React from "react";
import { useEffect, useState } from "react";
import { Button, ButtonGroup, Container, Table } from "reactstrap";
import { Link } from "react-router-dom";
import AppNavbar from "../nav/AppNavbar";
import Moment from "react-moment";

const ProductsList = () => {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch("/api/products")
      .then((response) => response.json())
      .then((data) => {
        setProducts(data);

        setLoading(false);
      });
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  const productList = products.map((product) => {
    return (
      <tr key={product.id}>
        <td>{product.id}</td>
        <td>{product.itemCode}</td>
        <td>{product.description}</td>
        <td>$ {product.price}</td>
        <td>{product.estate}</td>
        <td>
          <Moment format="DD/MM/YYYY">{product.createDate}</Moment>
        </td>
        <td>{product.creator.name}</td>
        <td>{product.supplier.name}</td>
        <td>{product.priceReductions.length}</td>
        <td>
          <ButtonGroup>
            <Button
              size="xl"
              color="primary"
              tag={Link}
              to={"/products/" + product.id}
            >
              Edit
            </Button>
          </ButtonGroup>
        </td>
      </tr>
    );
  });

  return (
    <div>
      <AppNavbar />
      <Container fluid>
        <h3>Products</h3>
        <div className="float-end">
          <Button color="success" tag={Link} to="/products/new">
            Add Product
          </Button>
        </div>
        <Table borderless striped className="mt-4">
          <thead>
            <tr>
              <th>Name</th>
              <th>Item Code</th>
              <th>Description</th>
              <th>Price</th>
              <th>State</th>
              <th>Create Date</th>
              <th>Creator</th>
              <th>suppliers</th>
              <th>Price Changes</th>
            </tr>
          </thead>
          <tbody>{productList}</tbody>
        </Table>
      </Container>
    </div>
  );
};

export default ProductsList;
